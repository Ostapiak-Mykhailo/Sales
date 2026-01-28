package views;


import models.Product;
import utils.Validator;

import java.util.Scanner;

// View
public class SalesView {

    String name;
    int quantity;
    double price;
    Scanner scanner;
    Product model;

    public SalesView(Product model) {
        this.model = model;
    }

    public void getInputs() {

        scanner = new Scanner(System.in);

        System.out.println("Input the product name");
        name = Validator.validateName(scanner);
        model.setName(name);

        System.out.println("Input quantity");
        quantity = Validator.validateQuantityInput(scanner);
        model.setQuantity(quantity);

        System.out.println("Input price");
        price = Validator.validatePriceInput(scanner);
        model.setPrice(price);

        scanner.close();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
