package MyFram;

import Dao.MyDao;
import Entities.BorrowedProduct;
import Helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentBorrowed extends javax.swing.JFrame {

    /**
     * Creates new form StudentBorrowed
     */
    public StudentBorrowed() {
        initComponents();

        myBorrowedtemsPennding();
        myBorrowedtemsApprove();
    }

    // this is retrive data FROM borrowed_products tableby status = handover
    public void myBorrowedtemsApprove() {
        String productName, productModel, studentName, studentPhone, status, dateOfReturn, return_Status;
        int id, quantity;

        DefaultTableModel model = (DefaultTableModel) itemsTableApproved.getModel();
        model.setRowCount(0);

        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT * FROM borrowed_products  Where Status = ?  ORDER BY dateOfReturn DESC ";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "handover");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                productName = rs.getString("productName");
                productModel = rs.getString("productModel");
                quantity = rs.getInt("quantity");

                dateOfReturn = rs.getString("dateOfReturn");
                studentPhone = rs.getString("studentPhone");
                studentName = rs.getString("studentName");
                dateOfReturn = rs.getString("dateOfReturn");
                status = rs.getString("status");
                return_Status = rs.getString("return_Status");

                Object[] obj = {productName, productModel, quantity,
                    studentName, studentPhone, dateOfReturn, status, return_Status};
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // this is retrive data FROM borrowed_products tableby status = handover search by user name
    public void myBorrowedtemsApproveAndSearchName() {
        String productName, productModel, studentName, studentPhone, status, dateOfReturn, return_Status;
        int id, quantity;

        DefaultTableModel model = (DefaultTableModel) itemsTableApproved.getModel();
        model.setRowCount(0);

        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT * FROM borrowed_products  Where Status = ? AND studentName LIKE '%" + searchNameTxt.getText() + "%'  ORDER BY dateOfReturn DESC ";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "handover");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                productName = rs.getString("productName");
                productModel = rs.getString("productModel");
                quantity = rs.getInt("quantity");

                dateOfReturn = rs.getString("dateOfReturn");
                studentPhone = rs.getString("studentPhone");
                studentName = rs.getString("studentName");
                dateOfReturn = rs.getString("dateOfReturn");
                status = rs.getString("status");
                return_Status = rs.getString("return_Status");

                Object[] obj = {productName, productModel, quantity,
                    studentName, studentPhone, dateOfReturn, status, return_Status};
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void myBorrowedtemsPenndingAndSearchByName() {
        String productName, productModel, studentName, studentPhone, status, dateOfReturn;
        int id, quantity;

        DefaultTableModel model = (DefaultTableModel) itemsTablepennding.getModel();
        model.setRowCount(0);

        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT * FROM borrowed_products  Where Status = ?   AND studentName LIKE '%" + searchNameTxt.getText() + "%'   ORDER BY dateOfReturn DESC ";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "pending");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                productName = rs.getString("productName");
                productModel = rs.getString("productModel");
                quantity = rs.getInt("quantity");

                dateOfReturn = rs.getString("dateOfReturn");
                studentPhone = rs.getString("studentPhone");
                studentName = rs.getString("studentName");
                dateOfReturn = rs.getString("dateOfReturn");
                status = rs.getString("status");
                String return_Status = rs.getString("return_Status");

                Object[] obj = {productName, productModel, quantity,
                    studentName, studentPhone, dateOfReturn, status, return_Status};
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void myBorrowedtemsPennding() {
        String productName, productModel, studentName, studentPhone, status, dateOfReturn;
        int id, quantity;

        DefaultTableModel model = (DefaultTableModel) itemsTablepennding.getModel();
        model.setRowCount(0);

        try {
            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT * FROM borrowed_products  Where Status = ?  ORDER BY dateOfReturn DESC ";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "pending");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                productName = rs.getString("productName");
                productModel = rs.getString("productModel");
                quantity = rs.getInt("quantity");

                dateOfReturn = rs.getString("dateOfReturn");
                studentPhone = rs.getString("studentPhone");
                studentName = rs.getString("studentName");
                dateOfReturn = rs.getString("dateOfReturn");
                status = rs.getString("status");
                String return_Status = rs.getString("return_Status");

                Object[] obj = {productName, productModel, quantity,
                    studentName, studentPhone, dateOfReturn, status, return_Status};
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        rSLabelImage2 = new rojerusan.RSLabelImage();
        searchNameTxt = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        itemsTableApproved = new rojerusan.RSTableMetro();
        jPanel20 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        itemsTablepennding = new rojerusan.RSTableMetro();
        jPanel19 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabelproductName = new javax.swing.JLabel();
        jLabelProductName = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        prdctLabel = new javax.swing.JLabel();
        quantityLabl = new javax.swing.JLabel();
        quantityLabl1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Borroewd Items");

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        rSLabelImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSLabelImage2MouseClicked(evt);
            }
        });

        searchNameTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchNameTxtActionPerformed(evt);
            }
        });
        searchNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchNameTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchNameTxt)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                .addGap(473, 473, 473))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSLabelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        itemsTableApproved.setBackground(new java.awt.Color(153, 153, 153));
        itemsTableApproved.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product Model", "Quantity ", "Student Name", "Contact", "Date of Return", "Status", "Return Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemsTableApproved.setColorBackgoundHead(new java.awt.Color(153, 153, 153));
        itemsTableApproved.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        itemsTableApproved.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        itemsTableApproved.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        itemsTableApproved.setColorSelForeground(new java.awt.Color(0, 0, 0));
        itemsTableApproved.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsTableApprovedMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(itemsTableApproved);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Approved Items");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        itemsTablepennding.setBackground(new java.awt.Color(153, 153, 153));
        itemsTablepennding.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product Model", "Quantity ", "Student Name", "Contact", "Date of Return", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemsTablepennding.setColorBackgoundHead(new java.awt.Color(153, 153, 153));
        itemsTablepennding.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        itemsTablepennding.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        itemsTablepennding.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        itemsTablepennding.setColorSelForeground(new java.awt.Color(0, 0, 0));
        itemsTablepennding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsTablepenndingMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(itemsTablepennding);

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Pennding Items");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Hand over");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelproductName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelproductName.setText("-");

        jLabelProductName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelProductName.setText("-");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Return");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        prdctLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prdctLabel.setText("-");

        quantityLabl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantityLabl.setText("-");

        quantityLabl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantityLabl1.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelproductName, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(prdctLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLabl, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(quantityLabl1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabelproductName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prdctLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityLabl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityLabl1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(433, 433, 433)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(106, 106, 106)))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemsTableApprovedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableApprovedMouseClicked
        DefaultTableModel model = (DefaultTableModel) itemsTableApproved.getModel();
        int selectedIndex = itemsTableApproved.getSelectedRow();

        jLabelProductName.setText(model.getValueAt(selectedIndex, 0).toString());
        quantityLabl1.setText(model.getValueAt(selectedIndex, 2).toString());
    }//GEN-LAST:event_itemsTableApprovedMouseClicked

    private void itemsTablepenndingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTablepenndingMouseClicked
        DefaultTableModel model = (DefaultTableModel) itemsTablepennding.getModel();
        int selectedIndex = itemsTablepennding.getSelectedRow();

        jLabelproductName.setText(model.getValueAt(selectedIndex, 3).toString());
        prdctLabel.setText(model.getValueAt(selectedIndex, 0).toString());
        quantityLabl.setText(model.getValueAt(selectedIndex, 2).toString());


    }//GEN-LAST:event_itemsTablepenndingMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String name = jLabelproductName.getText();
        String product = prdctLabel.getText();
        int quantity = Integer.parseInt(quantityLabl.getText());

        MyDao dao = new MyDao(ConnectionProvider.getConnection());
        BorrowedProduct bp = new BorrowedProduct();
        bp.setStudentName(name);
        bp.setProductName(product);
        bp.setQuantity(quantity);
        try {
            boolean updt = dao.updateItemBorrowedStatus(bp);
            if (updt) {
                myBorrowedtemsPennding();
                myBorrowedtemsApprove();

                dao.updateItemValueDecrease(product, quantity);
                JOptionPane.showMessageDialog(this, "Updated");

            } else {
                JOptionPane.showMessageDialog(this, "Error");

            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentBorrowed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    private void rSLabelImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSLabelImage2MouseClicked
        TechnicianDashBoard main = new TechnicianDashBoard();
        main.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_rSLabelImage2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String product = jLabelProductName.getText();
        int quantity = Integer.parseInt(quantityLabl1.getText());

        MyDao dao = new MyDao(ConnectionProvider.getConnection());
        BorrowedProduct bp = new BorrowedProduct();
        bp.setStudentName(product);
        try {
            boolean updt = dao.updateItemBorrowedReturnedStatus(bp);
            if (updt) {
                JOptionPane.showMessageDialog(this, "Updated");
                myBorrowedtemsPennding();
                myBorrowedtemsApprove();

                dao.updateItemValueIncrease(product, quantity);

            } else {
                JOptionPane.showMessageDialog(this, "Error");

            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentBorrowed.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchNameTxtActionPerformed

    private void searchNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNameTxtKeyPressed
        myBorrowedtemsApproveAndSearchName();
        myBorrowedtemsPenndingAndSearchByName();
    }//GEN-LAST:event_searchNameTxtKeyPressed

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
            java.util.logging.Logger.getLogger(StudentBorrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentBorrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentBorrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentBorrowed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentBorrowed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSTableMetro itemsTableApproved;
    private rojerusan.RSTableMetro itemsTablepennding;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelProductName;
    private javax.swing.JLabel jLabelproductName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel prdctLabel;
    private javax.swing.JLabel quantityLabl;
    private javax.swing.JLabel quantityLabl1;
    private rojerusan.RSLabelImage rSLabelImage2;
    private javax.swing.JTextField searchNameTxt;
    // End of variables declaration//GEN-END:variables
}
