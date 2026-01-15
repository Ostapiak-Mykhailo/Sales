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
        return quantity * price;
    }

    @Override
    public double calculateIncomeTax(double income) {
        return income * TAX_RATE;
    }

    @Override
    public double calculateIncome(double income, double incomeTax) {
        return income - incomeTax;
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
