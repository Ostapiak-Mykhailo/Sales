package models;


import base.Fiscal;
import base.Income;

public class Product implements Fiscal, Income {

    private String name;
    private int quantity;
    private double price;
    private final double TAX_RATE = 0.05;

    @Override
    public double calculateIncome(int quantity, double price) {
        double income = quantity * price;
        return income;
    }

    @Override
    public void calculateIncomeTax(double income) {
        double incomeTax = income * TAX_RATE;
    }

    @Override
    public void calculateIncome(double income, double incomeTax) {
        double netIncome = income - incomeTax;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
