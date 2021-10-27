/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author 44280
 */
public class newsAPI {

    JSONArray articles;
    Connection con;
    APILog apil = new APILog();
    String newsSelected;
    String userStatus;
    String keyWord = "";

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    
    public boolean getIsAdmin(String username, String pass) {
        boolean check = false;
        ResultSet rs = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] res = md.digest(pass.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < res.length; i++) {
                sb.append(Integer.toString((res[i] & 0xff) + 0x100, 16)).substring(1);
            }
            String hash = sb.toString();
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:8080/news", "root", "");
            Statement s = con.createStatement();
            String query = "SELECT username, password, status FROM accounts WHERE username = \"" + username + "\"";
            rs = s.executeQuery(query);
            String user = "", password = "", status = "";
            while (rs.next()) {
                user = rs.getString("username");
                System.out.println(user);
                password = rs.getString("password");
                System.out.println(password);
                status = rs.getString("status");
                System.out.println(status);
            }
            if (password.equals(hash) && status.equalsIgnoreCase("admin")) {
                check = true;
            }
        } catch (Exception e) {
            check = false;
        }
        System.out.println(check);
        return check;
    }
    
    public static void main(String[] args) throws Exception {
        newsAPI n = new newsAPI();
        n.start();
        System.out.println("connected");
        n.refreshNews();
    }

    public void start() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:8080/news", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  

    public boolean verifyAcc(String username, String pass) {
        boolean check = false;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] res = md.digest(pass.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < res.length; i++) {
                sb.append(Integer.toString((res[i] & 0xff) + 0x100, 16)).substring(1);
            }
            String hash = sb.toString();
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:8080/"
                    + "news", "root", "");
            Statement s = con.createStatement();
            String query = "SELECT username, password, status FROM accounts WHERE username = \"" + username + "\"";
            ResultSet rs = s.executeQuery(query);
            String user = "", password = "", status = "";
            while (rs.next()) {
                user = rs.getString("username");
                password = rs.getString("password");
                status = rs.getString("status");
            }
            if (password.equals(hash)) {
                check = true;
            }
        } catch (Exception e) {
            check = false;
        }
        return check;
    }

    public ResultSet sourceNames() {
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:8080/"
                    + "news", "root", "");
            Statement s = con.createStatement();
            String select = "SELECT name, COUNT(*) AS count FROM news GROUP BY name";
            rs = s.executeQuery(select);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet filterNews(String chosenSource) {
        ResultSet rs = null;
        try {
            Statement s = con.createStatement();
            String select = "SELECT title, description, author, publishedAt FROM news WHERE name = \"" + chosenSource + "\" ORDER BY publishedAt DESC";
            rs = s.executeQuery(select);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void setNewsSelected(String title) {
        newsSelected = title;
    }

    public void refreshNews() {
        try {
            URL url = new URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=f55248a166aa435487385e368c448d47");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //opens connection
            apil.setRequest();
            String reqMethod = "GET";
            conn.setRequestMethod(reqMethod);
            apil.setType(reqMethod);

            StringBuilder result = new StringBuilder();
            String line;

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                while ((line = in.readLine()) != null) {
                    result.append(line);
                    result.append(System.lineSeparator());
                }
            }
            conn.disconnect();
            apil.setResponse();
            JSONObject rawAPIResponse = new JSONObject(result.toString());
            //    System.out.println(mainObj);
            articles = rawAPIResponse.getJSONArray("articles");

            updateDB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkIfExists(String title) {
        boolean check = true;
        ResultSet rs;
        try {
            Statement s = con.createStatement();

            String query = "SELECT title FROM news WHERE title = \"" + title.replaceAll("\"", "") + "\"";
            rs = s.executeQuery(query);

            if (rs.next() != false) {
                // while (rs.next()) {
                //    String res = rs.getString("title");
                //    System.out.println(res);
                //  }
                check = true;
            } else {
                check = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public void updateDB() {
        try {

            for (int i = 0; i < articles.length(); i++) {
                String id, name, author, title, description, url, urlToImage, publishedAt;

                JSONObject sub = articles.getJSONObject(i);
                JSONObject source = sub.getJSONObject("source");

                title = sub.get("title").toString();

                if (checkIfExists(title) == false) {
                    PreparedStatement ps = con.prepareStatement("INSERT INTO news (id, name, "
                            + "author, title, description, url, urlToImage, publishedAt) VALUES (?,?,?,?,?,?,?,?)");
                    id = source.get("id").toString();
                    ps.setString(1, id);

                    name = source.get("name").toString();
                    ps.setString(2, name);

                    author = sub.get("author").toString();
                    ps.setString(3, author);

                    ps.setString(4, title);

                    description = sub.get("description").toString();
                    ps.setString(5, description);

                    url = sub.get("url").toString();
                    ps.setString(6, url);
                    apil.setUrl(url);

                    urlToImage = sub.get("urlToImage").toString();
                    ps.setString(7, urlToImage);

                    publishedAt = sub.get("publishedAt").toString();
                    publishedAt = publishedAt.replaceAll("T", " ").replaceAll("Z", "");
                    ps.setString(8, publishedAt);

                    //    System.out.println("\n" + ps + "\n");
                    ps.executeUpdate();
                    apil.updateAPILog();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getNewsSelected(/*String title*/) {
        ResultSet rs = null;
        try {
            Statement s = con.createStatement();
            String select = "SELECT name, title, description, author, publishedAt, urlToImage FROM news WHERE title = \"" + newsSelected.replaceAll("\"", "") + "\"";
            rs = s.executeQuery(select);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getCnnNews() {
        ResultSet rs = null;
        try {
            Statement s = con.createStatement();
            String query = "SELECT title, urlToImage FROM news WHERE name = \"CNN\" AND urlToImage != \"null\" ORDER BY publishedAt DESC LIMIT 2";
            rs = s.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getWashNews() {
        ResultSet rs = null;
        try {
            Statement s = con.createStatement();
            String query = "SELECT title, urlToImage FROM news WHERE name = \"The Washington Post\" AND urlToImage != \"null\"ORDER BY publishedAt DESC LIMIT 2";
            rs = s.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet getTopNews() {
        ResultSet rs = null;
        try {
            Statement s = con.createStatement();
            String query = "SELECT title, urlToImage FROM news WHERE urlToImage != \"null\" AND name != \"The Washington Post\" AND name"
                    + " != \"CNN\" ORDER BY publishedAt DESC LIMIT 1";
            rs = s.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet searchNews() {
        ResultSet rs = null;
        try {
            Statement s = con.createStatement();
            String query = "SELECT title, urlToImage, description FROM news WHERE title LIKE '%" + keyWord + "%' ORDER BY publishedAt DESC LIMIT 5";
            rs = s.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public int countNumNews() {
        ResultSet rs = null;
        int size = 0;
        try {
            Statement s = con.createStatement();
            String query = "SELECT COUNT(*) AS count FROM news WHERE title LIKE '%"+keyWord+"%' ORDER BY publishedAt DESC LIMIT 5";
            rs = s.executeQuery(query);
            while (rs.next()) {
                size = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
       
    public void addAccount(String fullName, String username, String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] res = md.digest(pass.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < res.length; i++) {
                sb.append(Integer.toString((res[i] & 0xff) + 0x100, 16)).substring(1);
            }
            String hash = sb.toString();
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:8080/"
                    + "news", "root", "");
            Statement s = con.createStatement();
            String query = "INSERT INTO accounts (status, full_name, username, password) VALUES (\"user\", \""+ fullName+"\", \"" + username + "\", \"" + hash + "\")";
            s.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }
