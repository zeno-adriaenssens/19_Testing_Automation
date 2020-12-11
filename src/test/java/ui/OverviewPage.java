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

    public boolean containsMeals(ArrayList<Meals> meals) {
        List<WebElement> tds = driver.findElements(By.className("productName"));
        int size = meals.size();
        int counter = 0;
        for (Meals meal : meals) {
            for (WebElement td : tds) {
                    String d = td.getAttribute("innerHTML");
                    String a = meal.getProductName();
                if (a.equals(d)) {
                    counter++;
                    break;
                }
            }
        }
        return counter == size;
    }

    public boolean containsPrice(String meal , String price) {
        List<WebElement> trs = driver.findElements(By.tagName("tr"));
        Boolean containtsMeal = false;
        for (WebElement tr : trs) {
            List<WebElement> tds = tr.findElements(By.tagName("td"));
            for (WebElement td : tds) {
                String productName = td.getAttribute("innerHTML");
                if (meal.equals(td.getAttribute("innerHTML"))) {
                    containtsMeal = true;

                }
                if (containtsMeal && price.equals(td.getAttribute("innerHTML"))) {
                    return true;
                }

            }
            containtsMeal = false;
        }
        return  false;
    }

}
