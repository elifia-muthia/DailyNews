/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magang;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.ScrollPaneConstants.*;

/**
 *
 * @author 44280
 */
public class newsSearch extends javax.swing.JFrame {

    newsAPI napi;
    newDesc nd;

    /**
     * Creates new form newsSearch
     */
    public newsSearch(newsAPI n) {
        initComponents();
        napi = n;
        this.setLocationRelativeTo(null);
        this.pack();
        jScrollPane1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        System.out.println(napi.keyWord);
        lblSearched.setText("Results for \"" + napi.keyWord + "\"");
        ResultSet rs = napi.searchNews();
        String title1 = "", url1 = "", title2 = "", url2 = "";
        String title3 = "", url3 = "", title4 = "", url4 = "";
        String title5 = "", url5 = "", desc1 = "", desc2 = "";
        String desc3 = "", desc4 = "", desc5 = "";
        Icon icon = null;
        BufferedImage img = null;
        try {
            int count = 1;
            String in = "";
            int size = napi.countNumNews();
            while (rs.next() && count <= size) {
                if (in.equalsIgnoreCase(rs.getString("title"))) {
                    break;
                }
                switch (count) {
                    case 1:
                        title1 = rs.getString("title");
                        url1 = rs.getString("urlToImage");
                        desc1 = rs.getString("description");
                    case 2:
                        title2 = rs.getString("title");
                        url2 = rs.getString("urlToImage");
                        desc2 = rs.getString("description");
                    case 3:
                        title3 = rs.getString("title");
                        url3 = rs.getString("urlToImage");
                        desc3 = rs.getString("description");
                    case 4:
                        title4 = rs.getString("title");
                        url4 = rs.getString("urlToImage");
                        desc4 = rs.getString("description");
                    case 5:
                        title5 = rs.getString("title");
                        url5 = rs.getString("urlToImage");
                        desc5 = rs.getString("description");
                }
                in = rs.getString("title");
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblTxt1.setText("<html>" + title1 + "</html>");
        lblTxt2.setText("<html>" + title2 + "</html>");
        lblTxt3.setText("<html>" + title3 + "</html>");
        lblTxt4.setText("<html>" + title4 + "</html>");
        lblTxt5.setText("<html>" + title5 + "</html>");
        
        lblDesc1.setText("<html>" + desc1 + "</html>");
        lblDesc2.setText("<html>" + desc2 + "</html>");
        lblDesc3.setText("<html>" + desc3 + "</html>");
        lblDesc4.setText("<html>" + desc4 + "</html>");
        lblDesc5.setText("<html>" + desc5 + "</html>");
        
        try {
            URL url = new URL(url1);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblIm1.getWidth(), lblIm1.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblIm1.setIcon(icon);
        } catch (Exception e) {
            lblIm1.setText("N/A");
        }
        try {
            URL url = new URL(url2);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblIm2.getWidth(), lblIm2.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblIm2.setIcon(icon);
        } catch (Exception e) {
            lblIm2.setText("N/A");
        }
        try {
            URL url = new URL(url3);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblIm3.getWidth(), lblIm3.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblIm3.setIcon(icon);
        } catch (Exception e) {
            lblIm3.setText("N/A");
        }
        try {
            URL url = new URL(url4);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblIm4.getWidth(), lblIm4.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblIm4.setIcon(icon);
        } catch (Exception e) {
            lblIm4.setText("N/A");
        }
        try {
            URL url = new URL(url5);
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(lblIm5.getWidth(), lblIm5.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(dimg);
            lblIm5.setIcon(icon);
        } catch (Exception e) {
            lblIm5.setText("N/A");
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lblSearched = new javax.swing.JLabel();
        lblIm1 = new javax.swing.JLabel();
        lblIm2 = new javax.swing.JLabel();
        lblIm3 = new javax.swing.JLabel();
        lblIm4 = new javax.swing.JLabel();
        lblIm5 = new javax.swing.JLabel();
        lblTxt1 = new javax.swing.JLabel();
        lblTxt2 = new javax.swing.JLabel();
        lblTxt3 = new javax.swing.JLabel();
        lblDesc1 = new javax.swing.JLabel();
        lblDesc2 = new javax.swing.JLabel();
        lblDesc3 = new javax.swing.JLabel();
        lblTxt4 = new javax.swing.JLabel();
        lblDesc4 = new javax.swing.JLabel();
        lblTxt5 = new javax.swing.JLabel();
        lblDesc5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        lblIm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIm1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIm1MouseClicked(evt);
            }
        });

        lblIm2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIm2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIm2MouseClicked(evt);
            }
        });

        lblIm3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIm3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIm3MouseClicked(evt);
            }
        });

        lblIm4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIm4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIm4MouseClicked(evt);
            }
        });

        lblIm5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIm5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIm5MouseClicked(evt);
            }
        });

        lblTxt1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        lblTxt1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblTxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTxt1MouseClicked(evt);
            }
        });

        lblTxt2.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        lblTxt2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblTxt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTxt2MouseClicked(evt);
            }
        });

        lblTxt3.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        lblTxt3.setToolTipText("");
        lblTxt3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblTxt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTxt3MouseClicked(evt);
            }
        });

        lblDesc1.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        lblDesc1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDesc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDesc1MouseClicked(evt);
            }
        });

        lblDesc2.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        lblDesc2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDesc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDesc2MouseClicked(evt);
            }
        });

        lblDesc3.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        lblDesc3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDesc3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDesc3MouseClicked(evt);
            }
        });

        lblTxt4.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        lblTxt4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblTxt4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTxt4MouseClicked(evt);
            }
        });

        lblDesc4.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        lblDesc4.setToolTipText("");
        lblDesc4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDesc4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDesc4MouseClicked(evt);
            }
        });

        lblTxt5.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        lblTxt5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblTxt5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTxt5MouseClicked(evt);
            }
        });

        lblDesc5.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        lblDesc5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDesc5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDesc5MouseClicked(evt);
            }
        });

        jButton1.setText("<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblIm5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(lblDesc5, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDesc4, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDesc3, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblIm2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIm3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblIm4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblIm1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblSearched, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1))
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearched, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(15, 15, 15)
                .addComponent(lblTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDesc1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(lblIm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(lblTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDesc2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(lblIm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(lblTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDesc3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIm3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(lblTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIm4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesc4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(lblTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIm5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 382, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblTxt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTxt3MouseClicked
        String title = lblTxt3.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblTxt3MouseClicked

    private void lblTxt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTxt2MouseClicked
        String title = lblTxt2.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblTxt2MouseClicked

    private void lblTxt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTxt1MouseClicked
        String title = lblTxt1.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblTxt1MouseClicked

    private void lblIm5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIm5MouseClicked
        String title = lblTxt5.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblIm5MouseClicked

    private void lblIm4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIm4MouseClicked
        String title = lblTxt4.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblIm4MouseClicked

    private void lblIm3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIm3MouseClicked
        String title = lblTxt3.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblIm3MouseClicked

    private void lblIm2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIm2MouseClicked
        String title = lblTxt2.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblIm2MouseClicked

    private void lblIm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIm1MouseClicked
        String title = lblTxt1.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblIm1MouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            napi.setKeyWord(txtSearch.getText().replace("\n", ""));
            newsSearch ns = new newsSearch(napi);
            ns.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped

    }//GEN-LAST:event_txtSearchKeyTyped

    private void lblTxt4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTxt4MouseClicked
        String title = lblTxt4.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblTxt4MouseClicked

    private void lblTxt5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTxt5MouseClicked
        String title = lblTxt5.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblTxt5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        newsHeadline nh = new newsHeadline(napi);
        nh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblDesc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesc1MouseClicked
        String title = lblTxt1.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblDesc1MouseClicked

    private void lblDesc2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesc2MouseClicked
        String title = lblTxt2.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblDesc2MouseClicked

    private void lblDesc3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesc3MouseClicked
        String title = lblTxt3.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblDesc3MouseClicked

    private void lblDesc4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesc4MouseClicked
        String title = lblTxt4.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblDesc4MouseClicked

    private void lblDesc5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesc5MouseClicked
        String title = lblTxt5.getText();
        if (title.length() > 1) {
            title = title.replace("<html>", "").replace("</html>", "");
            napi.setNewsSelected(title);
            nd = new newDesc(this, napi);
            nd.setVisible(true);
            this.dispose();
        } else {

        }
    }//GEN-LAST:event_lblDesc5MouseClicked

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
            java.util.logging.Logger.getLogger(newsSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newsSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newsSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newsSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new newsSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesc1;
    private javax.swing.JLabel lblDesc2;
    private javax.swing.JLabel lblDesc3;
    private javax.swing.JLabel lblDesc4;
    private javax.swing.JLabel lblDesc5;
    private javax.swing.JLabel lblIm1;
    private javax.swing.JLabel lblIm2;
    private javax.swing.JLabel lblIm3;
    private javax.swing.JLabel lblIm4;
    private javax.swing.JLabel lblIm5;
    private javax.swing.JLabel lblSearched;
    private javax.swing.JLabel lblTxt1;
    private javax.swing.JLabel lblTxt2;
    private javax.swing.JLabel lblTxt3;
    private javax.swing.JLabel lblTxt4;
    private javax.swing.JLabel lblTxt5;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
