/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.libraryui;


public class LibraryUI extends javax.swing.JFrame {

    /**
     * Creates new form LibraryUI
     */
    public LibraryUI() {
        initComponents();
        this.setLocationRelativeTo(null); // Center main window on screen
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        bookMenuItem = new javax.swing.JMenuItem();
        publisherMenuItem = new javax.swing.JMenuItem();
        memberMenuItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        query3MenuItem = new javax.swing.JMenuItem();
        query7MenuItem = new javax.swing.JMenuItem();
        query4MenuItem = new javax.swing.JMenuItem();
        query6MenuItem = new javax.swing.JMenuItem();
        query5MenuItem = new javax.swing.JMenuItem();
        borrowedFiveMenuItem = new javax.swing.JMenuItem();
        pubAfterYearMenuItem = new javax.swing.JMenuItem();
        Views = new javax.swing.JMenu();
        updateableMenuItem = new javax.swing.JMenuItem();
        nonUpdateableMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Managment Library Database ");

        jPanel1.setBackground(new java.awt.Color(52, 55, 56));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(181, 181, 181));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Project  Library  in  DBMS  mySQL");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(181, 181, 181));
        jLabel2.setText("Group:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(181, 181, 181));
        jLabel3.setText("Βεκράκης Εμμανουήλ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(181, 181, 181));
        jLabel4.setText("Βουλγαρίδης Ιωάννης");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(181, 181, 181));
        jLabel5.setText("Γιαννιός Γεώργιος-Ταξιάρχης");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(181, 181, 181));
        jLabel6.setText("Ε.Μ.Π. 2019 - Ηλεκρολόγων Μηχανικών & Μηχανικών Υπολογιστών");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/libraryui/database3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel6)
                .addGap(23, 23, 23))
        );

        jMenu1.setText("File");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tables");

        bookMenuItem.setText("Book");
        bookMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(bookMenuItem);

        publisherMenuItem.setText("Publisher");
        publisherMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(publisherMenuItem);

        memberMenuItem.setText("Member");
        memberMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(memberMenuItem);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Queries");

        query3MenuItem.setText("Published by");
        query3MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                query3MenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(query3MenuItem);

        query7MenuItem.setText("Find Book");
        query7MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                query7MenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(query7MenuItem);

        query4MenuItem.setText("Total Salaries");
        query4MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                query4MenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(query4MenuItem);

        query6MenuItem.setText("Books Written");
        query6MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                query6MenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(query6MenuItem);

        query5MenuItem.setText("Older Employees");
        query5MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                query5MenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(query5MenuItem);

        borrowedFiveMenuItem.setText("BorrowedFive");
        borrowedFiveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowedFiveMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(borrowedFiveMenuItem);

        pubAfterYearMenuItem.setText("PubAfterYear");
        pubAfterYearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pubAfterYearMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(pubAfterYearMenuItem);

        jMenuBar1.add(jMenu3);

        Views.setText("Views");

        updateableMenuItem.setText("Updateable");
        updateableMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateableMenuItemActionPerformed(evt);
            }
        });
        Views.add(updateableMenuItem);

        nonUpdateableMenuItem.setText("Non-updateable");
        nonUpdateableMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonUpdateableMenuItemActionPerformed(evt);
            }
        });
        Views.add(nonUpdateableMenuItem);

        jMenuBar1.add(Views);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // Close database and Exit
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void nonUpdateableMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonUpdateableMenuItemActionPerformed
        new BorrowedCountFrame().setVisible(true);
    }//GEN-LAST:event_nonUpdateableMenuItemActionPerformed

    private void bookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookMenuItemActionPerformed
        new bookFrame().setVisible(true);
    }//GEN-LAST:event_bookMenuItemActionPerformed

    private void memberMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberMenuItemActionPerformed
        new memberFrame().setVisible(true);
    }//GEN-LAST:event_memberMenuItemActionPerformed

    private void publisherMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherMenuItemActionPerformed
        new publisherFrame().setVisible(true);
    }//GEN-LAST:event_publisherMenuItemActionPerformed

    private void updateableMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateableMenuItemActionPerformed
        new bookPositionFrame().setVisible(true);
    }//GEN-LAST:event_updateableMenuItemActionPerformed

    private void borrowedFiveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowedFiveMenuItemActionPerformed
        new borrowedFiveQuery().setVisible(true);
    }//GEN-LAST:event_borrowedFiveMenuItemActionPerformed

    private void pubAfterYearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pubAfterYearMenuItemActionPerformed
        new PubAfterYearQuery().setVisible(true);
    }//GEN-LAST:event_pubAfterYearMenuItemActionPerformed

    private void query3MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query3MenuItemActionPerformed
        new PublishedQuery().setVisible(true);
    }//GEN-LAST:event_query3MenuItemActionPerformed

    private void query4MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query4MenuItemActionPerformed
        new TotalSalariesQuery().setVisible(true);
    }//GEN-LAST:event_query4MenuItemActionPerformed

    private void query5MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query5MenuItemActionPerformed
        new OlderEmployeesQuery().setVisible(true);
    }//GEN-LAST:event_query5MenuItemActionPerformed

    private void query6MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query6MenuItemActionPerformed
        new BooksWrittenQuery().setVisible(true);
    }//GEN-LAST:event_query6MenuItemActionPerformed

    private void query7MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_query7MenuItemActionPerformed
        new BookPositionQuery().setVisible(true);
    }//GEN-LAST:event_query7MenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(LibraryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryUI().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu Views;
    private javax.swing.JMenuItem bookMenuItem;
    private javax.swing.JMenuItem borrowedFiveMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem memberMenuItem;
    private javax.swing.JMenuItem nonUpdateableMenuItem;
    private javax.swing.JMenuItem pubAfterYearMenuItem;
    private javax.swing.JMenuItem publisherMenuItem;
    private javax.swing.JMenuItem query3MenuItem;
    private javax.swing.JMenuItem query4MenuItem;
    private javax.swing.JMenuItem query5MenuItem;
    private javax.swing.JMenuItem query6MenuItem;
    private javax.swing.JMenuItem query7MenuItem;
    private javax.swing.JMenuItem updateableMenuItem;
    // End of variables declaration//GEN-END:variables
}
