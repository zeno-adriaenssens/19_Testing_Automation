package domain.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Meals {
    private String productName;
    private String typeName;
    private double price;
    private String description;


    public Meals(String productName, String typeName, double price, String description) {
        setProductName(productName);
        setTypeName(typeName);
        setPrice(price);
        setDescription(description);
    }


    public String getProductName() {
        return productName;
    }

    private void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTypeName() {
        return typeName;
    }

    private void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
