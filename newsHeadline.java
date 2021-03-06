/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magang;

//import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author 44280
 */
public class newsHeadline extends javax.swing.JFrame {

    newsAPI napi;
    news news;
    newDesc nd;
    newsSearch ns;

    /**
     * Creates new form newsHeadline
     */
    public newsHeadline(newsAPI n) {
        napi = n;
        news = new news();
        ns = new newsSearch(napi);
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        ResultSet cnnrs = napi.getCnnNews();
        ResultSet washrs = napi.getWashNews();
        ResultSet toprs = napi.getTopNews();
        String cnnIm1 = "", cnnTx1 = "", cnnIm2 = "", cnnTx2 = "";
        String washIm1 = "", washTx1 = "", washIm2 = "", washTx2 = "";
        String topIm = "", topTx = "";
        Icon icon = null;
        BufferedImage img = null;
        try {
            int count = 1;
            while (cnnrs.next()) {
                if (count == 1) {
                    cnnIm1 = cnnrs.getString("urlToImage");
                    cnnTx1 = cnnrs.getString("title");
                } else {
                    cnnIm2 = cnnrs.getString("urlToImage");
                    cnnTx2 = cnnrs.getString("title");
                }
                count++;
            }
            count = 1;
            while (washrs.next()) {
                if (count == 1) {
                    washIm1 = washrs.getString("urlToImage");
                    washTx1 = washrs.getString("title");
                } else {
                    washIm2 = washrs.getString("urlToImage");
                    washTx2 = washrs.getString("title");
                }
                count++;
            }
            while (toprs.next()) {
                topIm = toprs.getString("urlToImage");
                topTx = toprs.getString("title");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblCnnText1.setText("<html>" + cnnTx1 + "</html>");
        lblCnnText2.setText("<html>" + cnnTx2 + "</html>");
        lblHeadText.setText("<html>" + topTx + "</html>");
        lblWashText1.setText("<html>" + washTx1 + "</html>");
        lblWashText2.setText("<html>" + washTx2 + "</html>");

        try {
            URL url = new URL(cnnIm1);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblCnnImage1.getWidth(), lblCnnImage1.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblCnnImage1.setIcon(icon);
        } catch (Exception e) {
            lblCnnImage1.setText("N/A");
        }
        try {
            URL url = new URL(cnnIm2);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblCnnImage2.getWidth(), lblCnnImage2.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblCnnImage2.setIcon(icon);
        } catch (Exception e) {
            lblCnnImage2.setText("N/A");
        }
        try {
            URL url = new URL(topIm);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblHeadImage.getWidth(), lblHeadImage.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblHeadImage.setIcon(icon);
        } catch (Exception e) {
            lblHeadImage.setText("N/A");
        }
        try {
            URL url = new URL(washIm1);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblWashImage1.getWidth(), lblWashImage1.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblWashImage1.setIcon(icon);
        } catch (Exception e) {
            lblWashImage1.setText("N/A");
        }
        try {
            URL url = new URL(washIm2);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblWashImage2.getWidth(), lblWashImage2.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblWashImage2.setIcon(icon);
        } catch (Exception e) {
            lblWashImage2.setText("N/A");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearch = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        lblCnnImage1 = new javax.swing.JLabel();
        lblCnnImage2 = new javax.swing.JLabel();
        lblCnnText1 = new javax.swing.JLabel();
        lblCnnText2 = new javax.swing.JLabel();
        lblHeadImage = new javax.swing.JLabel();
        lblHeadText = new javax.swing.JLabel();
        lblWashImage1 = new javax.swing.JLabel();
        lblWashImage2 = new javax.swing.JLabel();
        lblWashText1 = new javax.swing.JLabel();
        lblWashText2 = new javax.swing.JLabel();
        lblAdminLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblName.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 64)); // NOI18N
        lblName.setText("NEWS PORTAL");

        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setText("Search...");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CNN");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("WASHINGTON");

        lblCnnImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCnnImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCnnImage1MouseClicked(evt);
            }
        });

        lblCnnImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCnnImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCnnImage2MouseClicked(evt);
            }
        });

        lblCnnText1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lblCnnText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCnnText1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCnnText1MouseClicked(evt);
            }
        });

        lblCnnText2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lblCnnText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCnnText2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCnnText2MouseClicked(evt);
            }
        });

        lblHeadImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHeadImageMouseClicked(evt);
            }
        });

        lblHeadText.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lblHeadText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeadText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHeadTextMouseClicked(evt);
            }
        });

        lblWashImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWashImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWashImage1MouseClicked(evt);
            }
        });

        lblWashImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWashImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWashImage2MouseClicked(evt);
            }
        });

        lblWashText1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lblWashText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWashText1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWashText1MouseClicked(evt);
            }
        });

        lblWashText2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lblWashText2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWashText2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWashText2MouseClicked(evt);
            }
        });

        lblAdminLogin.setForeground(new java.awt.Color(0, 0, 255));
        lblAdminLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAdminLogin.setText("Admin Login");
        lblAdminLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblName)
                .addGap(381, 381, 381))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblCnnImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCnnText1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCnnImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCnnText2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblHeadImage, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                                    .addComponent(lblHeadText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(100, 100, 100)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblAdminLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(lblWashImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblWashText1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWashText2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWashImage2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblHeadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblHeadText, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblWashImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblWashText1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblWashImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblWashText2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(lblAdminLogin)
                                .addGap(34, 34, 34))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCnnImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCnnText1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lblCnnImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCnnText2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAdminLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminLoginMouseClicked
        newsAdmin na = new newsAdmin(napi);
        na.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAdminLoginMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        
    }//GEN-LAST:event_txtSearchKeyTyped

    private void lblCnnImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCnnImage1MouseClicked
        String title = lblCnnText1.getText();
        title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCnnImage1MouseClicked

    private void lblCnnText1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCnnText1MouseClicked
        String title = lblCnnText1.getText();title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCnnText1MouseClicked

    private void lblCnnImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCnnImage2MouseClicked
        String title = lblCnnText2.getText();
        title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCnnImage2MouseClicked

    private void lblCnnText2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCnnText2MouseClicked
        String title = lblCnnText2.getText();
        title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblCnnText2MouseClicked

    private void lblHeadImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHeadImageMouseClicked
        String title = lblHeadText.getText();
        title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblHeadImageMouseClicked

    private void lblHeadTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHeadTextMouseClicked
        String title = lblHeadText.getText();
        title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
    }//GEN-LAST:event_lblHeadTextMouseClicked

    private void lblWashImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWashImage1MouseClicked
        String title = lblWashText1.getText();
        title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblWashImage1MouseClicked

    private void lblWashText1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWashText1MouseClicked
        String title = lblWashText1.getText();
        title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
    }//GEN-LAST:event_lblWashText1MouseClicked

    private void lblWashImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWashImage2MouseClicked
        String title = lblWashText2.getText();
        title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblWashImage2MouseClicked

    private void lblWashText2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWashText2MouseClicked
        String title = lblWashText2.getText();
        title = title.replace("<html>", "").replace("</html>", "");
        napi.setNewsSelected(title);
        nd = new newDesc(this, napi);
        nd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblWashText2MouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            napi.setKeyWord(txtSearch.getText().replace("\n", ""));
            newsSearch ns = new newsSearch(napi);
            ns.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(newsHeadline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newsHeadline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newsHeadline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newsHeadline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new newsHeadline().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblAdminLogin;
    private javax.swing.JLabel lblCnnImage1;
    private javax.swing.JLabel lblCnnImage2;
    private javax.swing.JLabel lblCnnText1;
    private javax.swing.JLabel lblCnnText2;
    private javax.swing.JLabel lblHeadImage;
    private javax.swing.JLabel lblHeadText;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblWashImage1;
    private javax.swing.JLabel lblWashImage2;
    private javax.swing.JLabel lblWashText1;
    private javax.swing.JLabel lblWashText2;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
