package Dao;

import Entities.BorrowedProduct;
import Entities.Item;
import Entities.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDao {

    private Connection con;

    public MyDao(Connection con) {
        this.con = con;
    }

    // insert  Student
    public boolean insertStudent(Student student) {

        boolean f = false;

        try {

            String query = "INSERT INTO student (name,user_id,password,phone_number) VALUES (?,?,?,?)";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, student.getName());
            pst.setString(2, student.getUserId());
            pst.setString(3, student.getPassword());
            pst.setString(4, student.getPhoneNumber());

            pst.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }

    // insert borrowed records
    public boolean insertBorrowedProduct(BorrowedProduct borrowedProduct) {
        boolean f = false;
        try {
            String query = "INSERT INTO borrowed_products (productName, productModel, quantity, dateOfReturn, currentDateAndTime, studentName, studentPhone, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, borrowedProduct.getProductName());
            pst.setString(2, borrowedProduct.getProductModel());
            pst.setInt(3, borrowedProduct.getQuantity());
            pst.setString(4, borrowedProduct.getDateOfReturn());
            pst.setString(5, borrowedProduct.getCurrentDateAndTime());
            pst.setString(6, borrowedProduct.getStudentName());
            pst.setString(7, borrowedProduct.getStudentPhone());
            pst.setString(8, borrowedProduct.getStatus());

            pst.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    // insert item
    public boolean insertItem(Item item) throws SQLException {
        boolean f = false;
        String query = "INSERT INTO Item (name, model, value, quantity,expiryDate) VALUES (?, ?, ?, ?,?)";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getModel());
            statement.setDouble(3, item.getValue());
            statement.setInt(4, item.getQuantity());
            statement.setString(5, item.getExpiryDate());
//            statement.setDate(5, new java.sql.Date(item.getExpiryDate().getTime()));
            statement.executeUpdate();
        }

        return f;
    }

    public boolean updateItemValueIncrease(String itemName, double amountToAdd) throws SQLException {
        boolean f = false;
        String query = "UPDATE Item SET quantity = quantity + ? WHERE name = ?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setDouble(1, amountToAdd);
            statement.setString(2, itemName);
            statement.executeUpdate();
        }

        return f;
    }
    public boolean updateItemValueDecrease(String itemName, double amountToAdd) throws SQLException {
        boolean f = false;
        String query = "UPDATE Item SET quantity = quantity - ? WHERE name = ?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setDouble(1, amountToAdd);
            statement.setString(2, itemName);
            statement.executeUpdate();
        }

        return f;
    }

    // update item
    public boolean updateItemById(Item updatedItem) throws SQLException {
        boolean f = false;
        String query = "UPDATE Item SET name=?, model=?, value=?, quantity=? ,expiryDate = ? WHERE id=?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, updatedItem.getName());
            statement.setString(2, updatedItem.getModel());
            statement.setDouble(3, updatedItem.getValue());
            statement.setInt(4, updatedItem.getQuantity());
            statement.setString(5, updatedItem.getExpiryDate());
//            statement.setDate(5, new java.sql.Date(updatedItem.getExpiryDate().getTime()));
            statement.setInt(6, updatedItem.getId());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                f = true;
            }
        }

        return f;
    }

    // update borrowed_products status By Id
    public boolean updateItemBorrowedStatus(BorrowedProduct updatedItem) throws SQLException {
        boolean f = false;
        String query = "UPDATE borrowed_products SET status=?  WHERE studentName = ? AND productName =?  ";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, "handover");
            statement.setString(2, updatedItem.getStudentName());
            statement.setString(3, updatedItem.getProductName());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                f = true;
            }
        }

        return f;
    }

    public boolean updateItemBorrowedReturnedStatus(BorrowedProduct updatedItem) throws SQLException {
        boolean f = false;
        String query = "UPDATE borrowed_products SET return_Status = ? WHERE studentName = ? ";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, "Returned");
            statement.setString(2, updatedItem.getStudentName());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                f = true;
            }
        }

        return f;
    }

    // delete item by id
    public boolean deleteItemById(int itemId) throws SQLException {
        boolean f = false;
        String query = "DELETE FROM Item WHERE id=?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, itemId);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                f = true;
            }
        }

        return f;
    }

    // login Tecnicion by id and password
    public Student getTecniciantByIdAndPassword(String userId, String password) {
        Student user = null;

        System.out.println(userId);
        System.out.println(password);

        try {
            String query = "SELECT * FROM technician WHERE user_id=? AND password=? ";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, userId);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                user = new Student();
                user.setPassword(password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;

    }

    // login student by id and password
    public Student getStudentByIdAndPassword(String userId, String password) {
        Student user = null;

        System.out.println(userId);
        System.out.println(password);

        try {
            String query = "SELECT * FROM student WHERE user_id=? AND password=? ";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, userId);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                user = new Student();
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setUserId(rs.getString("user_id"));
                user.setPassword(password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;

    }

}
