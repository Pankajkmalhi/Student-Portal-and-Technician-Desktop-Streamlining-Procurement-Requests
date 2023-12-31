/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFram;

import Dao.MyDao;
import Entities.Item;
import Helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Items extends javax.swing.JFrame {

    /**
     * Creates new form Items
     */
    public Items() {
        initComponents();
        allItems();
    }

    public boolean validateForm() {

        String retDate = ((JTextField) issueDateTxt.getDateEditor().getUiComponent()).getText();

        if (nameTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Name");
            nameTxt.requestFocus();
            return false;

        }
        if (modelTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter User Id");
            modelTxt.requestFocus();
            return false;
        }
        if (quantityTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity");
            quantityTxt.requestFocus();
            return false;
        }
        if (borrowedTxt.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Borrow");
            borrowedTxt.requestFocus();
            return false;
        }

        if (retDate.equals("")) {
            JOptionPane.showMessageDialog(this, "Please select a  date");
            return false;
        }

        return true;

    }

    public void allItems() {
        String name;

        DefaultTableModel model;
        model = (DefaultTableModel) itemsTable.getModel();
        model.setRowCount(0);

        try {

            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT * FROM item   ";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                name = rs.getString("name");
                String itemModels = rs.getString("model");
                String quantity = rs.getString("quantity");
                String expiry_date = rs.getString("expirydate");

                Object[] obj = {rs.getString("id"), name, itemModels, quantity, rs.getString("value"), expiry_date
                };
                model = (DefaultTableModel) itemsTable.getModel();
                model.addRow(obj);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void allItemsByName() {
        String name;

        DefaultTableModel model;
        model = (DefaultTableModel) itemsTable.getModel();
        model.setRowCount(0);

        try {

            Connection con = ConnectionProvider.getConnection();
            String sql = "SELECT * FROM item  WHERE name LIKE '%" + searchNameTxt.getText() + "%'  ";

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                name = rs.getString("name");
                String itemModels = rs.getString("model");
                String quantity = rs.getString("quantity");
                String expiry_date = rs.getString("expirydate");
//                String expiry_date = rs.getString("expiry_date");

                Object[] obj = {rs.getString("id"), name, itemModels, quantity, rs.getString("value"), expiry_date
                };
                model = (DefaultTableModel) itemsTable.getModel();
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
        jLabel1 = new javax.swing.JLabel();
        rSLabelImage1 = new rojerusan.RSLabelImage();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        nameTxt = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        modelTxt = new app.bolivia.swing.JCTextField();
        jLabel31 = new javax.swing.JLabel();
        quantityTxt = new app.bolivia.swing.JCTextField();
        jLabel32 = new javax.swing.JLabel();
        rSMaterialButtonCircle12 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle13 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle14 = new necesario.RSMaterialButtonCircle();
        idTxt = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        borrowedTxt = new app.bolivia.swing.JCTextField();
        issueDateTxt = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        itemsTable = new rojerusan.RSTableMetro();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        searchNameTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Items");

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        rSLabelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSLabelImage1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSLabelImage1MouseEntered(evt);
            }
        });
        rSLabelImage1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rSLabelImage1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(rSLabelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Name :");

        nameTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        nameTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTxtFocusLost(evt);
            }
        });
        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTxtKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Add Items");

        modelTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        modelTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        modelTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modelTxtFocusLost(evt);
            }
        });
        modelTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                modelTxtKeyTyped(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Model :");

        quantityTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        quantityTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quantityTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityTxtFocusLost(evt);
            }
        });
        quantityTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityTxtKeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Quantity :");

        rSMaterialButtonCircle12.setBackground(new java.awt.Color(48, 59, 59));
        rSMaterialButtonCircle12.setText("Add ");
        rSMaterialButtonCircle12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle12ActionPerformed(evt);
            }
        });

        rSMaterialButtonCircle13.setBackground(new java.awt.Color(48, 59, 59));
        rSMaterialButtonCircle13.setText("Delete");
        rSMaterialButtonCircle13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle13ActionPerformed(evt);
            }
        });

        rSMaterialButtonCircle14.setBackground(new java.awt.Color(48, 59, 59));
        rSMaterialButtonCircle14.setText("Update");
        rSMaterialButtonCircle14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle14ActionPerformed(evt);
            }
        });

        idTxt.setForeground(new java.awt.Color(255, 255, 255));
        idTxt.setText("0");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Borrowed :");

        borrowedTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        borrowedTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        borrowedTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                borrowedTxtFocusLost(evt);
            }
        });
        borrowedTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                borrowedTxtKeyTyped(evt);
            }
        });

        issueDateTxt.setBackground(new java.awt.Color(204, 204, 204));
        issueDateTxt.setDateFormatString("yyyy/MM/dd");
        issueDateTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        issueDateTxt.setPreferredSize(new java.awt.Dimension(91, 18));
        issueDateTxt.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                issueDateTxtAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        issueDateTxt.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                issueDateTxtPropertyChange(evt);
            }
        });
        issueDateTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                issueDateTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                issueDateTxtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(issueDateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(borrowedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSMaterialButtonCircle14, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSMaterialButtonCircle12, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSMaterialButtonCircle13, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrowedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(issueDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(rSMaterialButtonCircle12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSMaterialButtonCircle14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(rSMaterialButtonCircle13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        itemsTable.setBackground(new java.awt.Color(153, 153, 153));
        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Model", "Quantity", "Borrowed", "Expiry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemsTable.setColorBackgoundHead(new java.awt.Color(153, 153, 153));
        itemsTable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        itemsTable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        itemsTable.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        itemsTable.setColorSelForeground(new java.awt.Color(0, 0, 0));
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(itemsTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        searchNameTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchNameTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(searchNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGap(78, 78, 78))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtFocusLost

    private void nameTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtKeyTyped

    private void modelTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_modelTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_modelTxtFocusLost

    private void modelTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modelTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_modelTxtKeyTyped

    private void quantityTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtFocusLost

    private void quantityTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtKeyTyped

    private void rSMaterialButtonCircle12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle12ActionPerformed
        if (validateForm()) {
            String name = nameTxt.getText();
            String model = modelTxt.getText();
            int quantity = Integer.parseInt(quantityTxt.getText());
            LocalDate date = LocalDate.now();
            String retDate = ((JTextField) issueDateTxt.getDateEditor().getUiComponent()).getText();

            MyDao dao = new MyDao(ConnectionProvider.getConnection());

            Item items = new Item(name, model, 0, quantity, retDate);

            try {
                boolean insert = dao.insertItem(items);

                if (insert) {
                    JOptionPane.showMessageDialog(this, " Some things Wrong");
                    allItems();
                } else {
                    JOptionPane.showMessageDialog(this, " Inserted");
                    allItems();

                }

            } catch (SQLException ex) {
                Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }

    }//GEN-LAST:event_rSMaterialButtonCircle12ActionPerformed

    private void itemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) itemsTable.getModel();
        int selectedIndex = itemsTable.getSelectedRow();

        idTxt.setText(model.getValueAt(selectedIndex, 0).toString());
        nameTxt.setText(model.getValueAt(selectedIndex, 1).toString());
        modelTxt.setText(model.getValueAt(selectedIndex, 2).toString());

        quantityTxt.setText(model.getValueAt(selectedIndex, 3).toString());
        borrowedTxt.setText(model.getValueAt(selectedIndex, 4).toString());

    }//GEN-LAST:event_itemsTableMouseClicked

    private void rSLabelImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSLabelImage1MouseClicked
        TechnicianDashBoard main = new TechnicianDashBoard();
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSLabelImage1MouseClicked

    private void rSLabelImage1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rSLabelImage1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSLabelImage1KeyPressed

    private void rSMaterialButtonCircle13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle13ActionPerformed

        int id = Integer.parseInt(idTxt.getText());

        MyDao dao = new MyDao(ConnectionProvider.getConnection());

        try {
            boolean update = dao.deleteItemById(id);

            if (update) {
                JOptionPane.showMessageDialog(this, " Deleted");
                allItems();
            } else {
                JOptionPane.showMessageDialog(this, " Some Errors");
                allItems();

            }

        } catch (SQLException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_rSMaterialButtonCircle13ActionPerformed

    private void rSMaterialButtonCircle14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle14ActionPerformed

        if (validateForm()) {

            int id = Integer.parseInt(idTxt.getText());
            String name = nameTxt.getText();
            String model = modelTxt.getText();
            int quantity = Integer.parseInt(quantityTxt.getText());
            String retDate = ((JTextField) issueDateTxt.getDateEditor().getUiComponent()).getText();

            MyDao dao = new MyDao(ConnectionProvider.getConnection());

            Item items = new Item(id, name, model, 0, quantity, retDate);

            try {
                boolean update = dao.updateItemById(items);

                if (update) {
                    JOptionPane.showMessageDialog(this, " Updated");
                    allItems();
                } else {
                    JOptionPane.showMessageDialog(this, " Some Errors");
                    allItems();

                }

            } catch (SQLException ex) {
                Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_rSMaterialButtonCircle14ActionPerformed

    private void borrowedTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_borrowedTxtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_borrowedTxtFocusLost

    private void borrowedTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_borrowedTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_borrowedTxtKeyTyped

    private void searchNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNameTxtKeyPressed
        allItemsByName();
    }//GEN-LAST:event_searchNameTxtKeyPressed

    private void rSLabelImage1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSLabelImage1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_rSLabelImage1MouseEntered

    private void issueDateTxtAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_issueDateTxtAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_issueDateTxtAncestorAdded

    private void issueDateTxtPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_issueDateTxtPropertyChange

    }//GEN-LAST:event_issueDateTxtPropertyChange

    private void issueDateTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_issueDateTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_issueDateTxtKeyReleased

    private void issueDateTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_issueDateTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_issueDateTxtKeyTyped

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
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Items().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField borrowedTxt;
    private javax.swing.JLabel idTxt;
    private com.toedter.calendar.JDateChooser issueDateTxt;
    private rojerusan.RSTableMetro itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private app.bolivia.swing.JCTextField modelTxt;
    private app.bolivia.swing.JCTextField nameTxt;
    private app.bolivia.swing.JCTextField quantityTxt;
    private rojerusan.RSLabelImage rSLabelImage1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle12;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle13;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle14;
    private javax.swing.JTextField searchNameTxt;
    // End of variables declaration//GEN-END:variables
}
