package ui;

import domain.model.Meals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OverviewPage extends Page {
    public OverviewPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=Overview");
    }

    //String productName, String typeName, double price, String description
    public boolean containsMeals(ArrayList<Meals> meals) {
        List<WebElement> tds = driver.findElements(By.tagName("td"));
        int size = meals.size();
        int counter = 0;
        for (Meals meal : meals) {
            for (WebElement td : tds) {
                    String d = td.getAttribute("value");
                if (meal.getProductName().equals(d)) {
                    counter++;
                }
            }
        }
        if (counter == size) {
            return true;
        }else {
            return false;
        }
    }
}
