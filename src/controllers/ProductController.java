package controllers;

import models.Product;
import utils.Rounder;
import views.SalesView;

import java.math.BigDecimal;

// Controller
public class ProductController {

    Product model;
    SalesView view;

    // Конструктор
    public ProductController(Product model, SalesView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        view.getInputs();

        // 1) получение имени товара через модель;
        String productName = model.getName();

        // 2) вызов методов расчетов доходов и налога;
        double income = model.calculateIncome(model.getQuantity(), model.getPrice());
        double tax = model.calculateIncomeTax(income);
        double netIncome = model.calculateIncome(income, tax);

        // 3) округление расчетных значений;
        BigDecimal incomeRounded = Rounder.roundSum(income);
        BigDecimal taxRounded = Rounder.roundSum(tax);
        BigDecimal netIncomeRounded = Rounder.roundSum(netIncome);

        // 4) вывод расчетов по заданному формату.

        String output = "Product name: " + productName + "\n" +
                "Total income: " + incomeRounded + "\n" +
                "Tax paid: " + taxRounded + "\n" +
                "Net income: " + netIncomeRounded;

        view.getOutput(output);
    }
}
