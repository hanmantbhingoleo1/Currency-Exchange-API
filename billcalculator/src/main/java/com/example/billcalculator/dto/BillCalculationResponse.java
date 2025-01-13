package com.example.billcalculator.dto;

public class BillCalculationResponse {

    private double totalAmount;
    private double groceryAmount;
    private String userType;
    private int customerTenure;
    private String originalCurrency;
    private String targetCurrency;
    private double discountAmount;
    private double amountAfterDiscount;
    private double exchangeRate;
    private double finalPayableAmount;

    public BillCalculationResponse(double totalAmount, double groceryAmount, String userType, int customerTenure,
                                   String originalCurrency, String targetCurrency, double discountAmount,
                                   double amountAfterDiscount, double exchangeRate, double finalPayableAmount) {
        this.totalAmount = totalAmount;
        this.groceryAmount = groceryAmount;
        this.userType = userType;
        this.customerTenure = customerTenure;
        this.originalCurrency = originalCurrency;
        this.targetCurrency = targetCurrency;
        this.discountAmount = discountAmount;
        this.amountAfterDiscount = amountAfterDiscount;
        this.exchangeRate = exchangeRate;
        this.finalPayableAmount = finalPayableAmount;
    }

    // Getters and setters
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

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getAmountAfterDiscount() {
        return amountAfterDiscount;
    }

    public void setAmountAfterDiscount(double amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getFinalPayableAmount() {
        return finalPayableAmount;
    }

    public void setFinalPayableAmount(double finalPayableAmount) {
        this.finalPayableAmount = finalPayableAmount;
    }
}
