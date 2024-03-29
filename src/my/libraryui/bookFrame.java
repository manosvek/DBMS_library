/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.libraryui;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import my.libraryui.ConnectionDB;

public class bookFrame extends javax.swing.JFrame {
    /**
     * Creates new form bookFrame
     */
    public bookFrame() {
        db_con = new ConnectionDB();
        
        initComponents();
        this.setLocationRelativeTo(null); // Align window on screen center
        
        try {
            try {
                Statement pubStmt = db_con.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String query = "select pubName from Publisher";
                ResultSet pubSet = pubStmt.executeQuery(query);
                
                insertButton.setEnabled(false);
                
                while (pubSet.next()){
                    publisherBox.addItem(pubSet.getString("pubName"));
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            if (result_set == null) {
                fetchResultSet();
            }
            if (result_set != null) {
                if (result_set.first()) {
                    isbn_book.setText(result_set.getString("ISBN"));
                    title_book.setText(result_set.getString("title"));
                    year_book.setText(result_set.getString("pubYear"));
                    pages_book.setText(result_set.getString("numPages"));
                    publisherBox.setSelectedItem(result_set.getString("pubName"));
                    ISBN = isbn_book.getText();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        isbn_book = new javax.swing.JTextField();
        title_book = new javax.swing.JTextField();
        year_book = new javax.swing.JTextField();
        pages_book = new javax.swing.JTextField();
        publisherBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Book table");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Insert - Update - Delete record on Book table");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Book record"));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ISBN:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Title:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Year:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Pages:");

        jLabel6.setText("Publisher");

        isbn_book.setColumns(15);

        publisherBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pages_book, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(year_book, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title_book)
                    .addComponent(isbn_book))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel6)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(publisherBox, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(isbn_book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(title_book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(year_book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(pages_book, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(publisherBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(previousButton)
                .addGap(10, 10, 10)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addGap(15, 15, 15))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, insertButton, newButton, nextButton, previousButton, updateButton});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextButton)
                        .addComponent(previousButton))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateButton)
                        .addComponent(deleteButton)
                        .addComponent(insertButton)
                        .addComponent(newButton)))
                .addGap(18, 18, 18)
                .addComponent(closeButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);  //Close bookFrame
    }//GEN-LAST:event_closeButtonActionPerformed

    
    public void fetchResultSet() {
        try {
            
            Statement stmt = db_con.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "select * from Book";
            result_set = stmt.executeQuery(query);
            
        } catch (Exception ex) {

            try {
                if (db_con.connection != null) {
                    db_con.closeCon();
                }
            } catch (Exception x) {
            }
        }
    }
    
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        updateButton.setEnabled(true);
        insertButton.setEnabled(false);
        try {
            if (result_set == null) {
                fetchResultSet();
            }
            if (result_set != null) {
                if (previousButton.isEnabled() == false)
                    previousButton.setEnabled(true);
                if (result_set.next()) {
                    isbn_book.setText(result_set.getString("ISBN"));
                    title_book.setText(result_set.getString("title"));
                    year_book.setText(result_set.getString("pubYear"));
                    pages_book.setText(result_set.getString("numPages"));
                    publisherBox.setSelectedItem(result_set.getString("pubName"));
                    
                    ISBN = isbn_book.getText();
                    insertButton.setEnabled(false);

                } else {
                    nextButton.setEnabled(false);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    
    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        updateButton.setEnabled(true);
        insertButton.setEnabled(false); 
        try {
            if (result_set == null) {
                fetchResultSet();
            }
            if (result_set != null) {
                if (nextButton.isEnabled() == false)
                    nextButton.setEnabled(true);
                
                if (result_set.previous()) {
                    isbn_book.setText(result_set.getString("ISBN"));
                    title_book.setText(result_set.getString("title"));
                    year_book.setText(result_set.getString("pubYear"));
                    pages_book.setText(result_set.getString("numPages"));
                    publisherBox.setSelectedItem(result_set.getString("pubName"));
                    
                    ISBN = isbn_book.getText();
                    insertButton.setEnabled(false);

                 } else {
                    previousButton.setEnabled(false);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    
    private void publisherBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherBoxActionPerformed

    }//GEN-LAST:event_publisherBoxActionPerformed

    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        insertButton.setEnabled(true);
        updateButton.setEnabled(false);
        isbn_book.setText("");
        title_book.setText("");
        year_book.setText("");
        pages_book.setText("");
        isbn_book.requestFocus();
    }//GEN-LAST:event_newButtonActionPerformed

    
    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        String isbn=isbn_book.getText().trim(), title=title_book.getText(), year=year_book.getText(), pages=pages_book.getText();
        String publisher = publisherBox.getSelectedItem().toString();
        try {
            Statement stmt = db_con.connection.createStatement();
            String query = "insert into Book values (\""+isbn+"\",\""+title+"\","+year+","+pages+",\""+publisher+"\");";
            
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Inserted a book!" );
            newButton.doClick();
            result_set = null;
        } catch (Exception ex) {
            if (ex.toString().contains("field")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Λάθος τύπος στοιχείων" );
            }
            else if (ex.toString().contains("duplicate")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Το βιβλίο με αυτό το ISBN ήδη υπάρχει" );
            }
            else if (ex.toString().contains("ISBN length")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Το μήκος του ISBN δεν είναι 13 χαρακτήρες" );
            }
            else if (ex.toString().contains("correct format")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! H σωστή μορφή του ISBN είναι: ###-###-###-#" );
            }
            else if (ex.toString().contains("Error! Year")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Το έτος πρέπει να είναι από το έτος ίδρυσης του εκδοτικού οίκου μέχρι το τρέχον" );
            }
            else if (ex.toString().contains("Error! Pages")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Οι σελίδες πρέπει να είναι θετικός αριθμός" );
            }
            else if (ex.toString().contains("\"\"")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Τα πεδία πρέπει να είναι συμπληρωμένα." );
            }
            else if (isbn.equals("")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Τα πεδία πρέπει να είναι συμπληρωμένα." );
            }
            else {
                JOptionPane.showMessageDialog(null, ex );
            }
        }
    }//GEN-LAST:event_insertButtonActionPerformed

    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String isbn=isbn_book.getText(), title=title_book.getText(), year=year_book.getText(), pages=pages_book.getText();
        String publisher = publisherBox.getSelectedItem().toString();
        
        try {
            Statement stmt = db_con.connection.createStatement();
            String query= "update Book set ISBN=\""+isbn+"\",title=\""+title+"\",pubYear="+year+",numPages="+pages+",pubName=\""+publisher+"\" where ISBN=\""+ISBN+"\";";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Updated a book!" );
        } catch (Exception ex) {
            if (ex.toString().contains("field")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Λάθος τύπος στοιχείων" );
            }
            else if (ex.toString().contains("ON UPDATE CASCADE")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Το βιβλίο αυτό είναι δανεισμένο" );
            }
            else if (ex.toString().contains("duplicate")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Το βιβλίο με αυτό το ISBN ήδη υπάρχει" );
            }
            else if (ex.toString().contains("ISBN length")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Το μήκος του ISBN δεν είναι 13 χαρακτήρες" );
            }
            else if (ex.toString().contains("correct format")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! H σωστή μορφή του ISBN είναι: ###-###-###-#" );
            }
            else if (ex.toString().contains("Error! Year")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Το έτος πρέπει να είναι από το έτος ίδρυσης του εκδοτικού οίκου μέχρι το τρέχον" );
            }
            else if (ex.toString().contains("Error! Pages")) {
                JOptionPane.showMessageDialog(null, "Σφάλμα! Οι σελίδες πρέπει να είναι θετικός αριθμός" );
            } 
            else {
                JOptionPane.showMessageDialog(null, ex );
            }
        }
        
        result_set = null;
        nextButton.doClick();
    }//GEN-LAST:event_updateButtonActionPerformed
        
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String isbn=isbn_book.getText();
        try {
            Statement stmt = db_con.connection.createStatement();
            String query= "delete from Book where ISBN=\""+isbn+"\";";
            stmt.executeUpdate(query);
            
            result_set = null;
            nextButton.doClick();
            JOptionPane.showMessageDialog(null, "Deleted a book!" );
        }
        catch (Exception ex) {
            if (ex.toString().contains("delete")) {
                JOptionPane.showMessageDialog(null, "Το βιβλίο είναι δανεισμένο από κάποιο μέλος.\n Δεν μπορεί να διαγραφεί!" );
            }
            else
                JOptionPane.showMessageDialog(null, ex );
        }                             
    }//GEN-LAST:event_deleteButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(bookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookFrame().setVisible(true);
            }
        });
    }

    
    final private ConnectionDB db_con;
//    private Statement stmt = null;
    private ResultSet result_set = null;
    private String ISBN = null;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JTextField isbn_book;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton newButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField pages_book;
    private javax.swing.JButton previousButton;
    private javax.swing.JComboBox<String> publisherBox;
    private javax.swing.JTextField title_book;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField year_book;
    // End of variables declaration//GEN-END:variables
}