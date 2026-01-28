package controllers;

import models.Product;
import utils.Rounder;
import views.SalesView;

import java.math.BigDecimal;

public class ProductController {

    Product model;
    SalesView view;

    public ProductController(Product model, SalesView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {
        view.getInputs();
        String productName = model.getName();

        double income = model.calculateIncome(model.getQuantity(), model.getPrice());
        double tax = model.calculateIncomeTax(income);
        double netIncome = model.calculateIncome(income, tax);

        BigDecimal incomeRounded = Rounder.roundSum(income);
        BigDecimal taxRounded = Rounder.roundSum(tax);
        BigDecimal netIncomeRounded = Rounder.roundSum(netIncome);

        String output = "Product name: " + productName + "\n" +
                "Total income: " + incomeRounded + "\n" +
                "Tax paid: " + taxRounded + "\n" +
                "Net income: " + netIncomeRounded;

        view.getOutput(output);
    }
}
