package Entities;

import java.sql.Date;
import java.sql.Timestamp;

public class BorrowedProduct {

    private int id;
    private String productName;
    private String productModel;
    private int quantity;
    private String dateOfReturn;
    private String currentDateAndTime;
    private String studentName;
    private String studentPhone;
    private String status;

    public BorrowedProduct() {
    }

    public BorrowedProduct(String productName, String productModel, int quantity, String dateOfReturn, String currentDateAndTime, String studentName, String studentPhone, String status) {
        this.productName = productName;
        this.productModel = productModel;
        this.quantity = quantity;
        this.dateOfReturn = dateOfReturn;
        this.currentDateAndTime = currentDateAndTime;
        this.studentName = studentName;
        this.studentPhone = studentPhone;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public String getCurrentDateAndTime() {
        return currentDateAndTime;
    }

    public void setCurrentDateAndTime(String currentDateAndTime) {
        this.currentDateAndTime = currentDateAndTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
