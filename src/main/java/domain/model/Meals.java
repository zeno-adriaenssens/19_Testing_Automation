package domain.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This page make our meal objects
 */

public class Meals {
    private String productName;
    private String typeName;
    private String price;
    private String description;
    private String vegetarisch;


    public Meals(String productName, String typeName, String price, String description, String vegetarisch) {
        setProductName(productName);
        setTypeName(typeName);
        setPrice(price);
        setDescription(description);
        setVegetarisch(vegetarisch);
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

    public String getPrice() {
        return price;
    }

    private void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public String getVegetarisch() {
        return vegetarisch;
    }

    public void setVegetarisch(String vegetarisch) {
        this.vegetarisch = vegetarisch;
    }
}
