package com.example.billcalculator.model;

public class Bill {

    private double totalAmount;
    private double groceryAmount;
    private String userType;
    private int customerTenure;
    private String originalCurrency;
    private String targetCurrency;

    // Getters and Setters

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getGroceryAmount() {
        return groceryAmount;
    }

    public void setGroceryAmount(double groceryAmount) {
        this.groceryAmount = groceryAmount;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getCustomerTenure() {
        return customerTenure;
    }

    public void setCustomerTenure(int customerTenure) {
        this.customerTenure = customerTenure;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
}
