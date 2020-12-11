package ui;

import domain.model.Meals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This page Will run al the test for the test cases where the an overview is shown
 */
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
        Boolean containsMeal = false;
        for (WebElement tr : trs) {
            List<WebElement> tds = tr.findElements(By.tagName("td"));
            for (WebElement td : tds) {
                String productName = td.getAttribute("innerHTML");
                if (meal.equals(td.getAttribute("innerHTML"))) {
                    containsMeal = true;

                }
                if (containsMeal && price.equals(td.getAttribute("innerHTML"))) {
                    return true;
                }

            }
            containsMeal = false;
        }
        return  false;
    }


    public boolean isSortedByType(){
        List<WebElement> typeNames = driver.findElements(By.className("typeName"));
        List<WebElement> tableRow = driver.findElements(By.tagName("tr"));
        String currentType = "";
        int counter = 0;
        int indexInList = 0;
        boolean  isSorted = true;
        for (WebElement tr : tableRow) {
            List<WebElement> allTD = tr.findElements(By.tagName("td"));
            counter = 0;
            if(allTD.size() > 0) {
                String productName = allTD.get(0).getAttribute("innerHTML");
                String productType = typeNames.get(indexInList).getAttribute("innerHTML");
                for (WebElement td : allTD) {
                    String a = td.getAttribute("innerHTML");
                    if (a.isEmpty()) {
                        counter += 1;
                    }
                    if (counter == 4 && !productName.equals(""))            //4 waardes zijn leeg --> nieuw type begint in de lijst
                        currentType = productName;
                }
                if (currentType.equals("Broodjes:")) {
                    if (!productType.equals("") && !productType.equals("Broodje")) {
                        isSorted = false;
                    }
                }
                if (currentType.equals("Wraps:")) {
                    if (!productType.equals("Wrap")  && !productType.equals("")) {
                        isSorted = false;
                    }
                }
                if (currentType.equals("Soepen:")) {
                    if (!productType.equals("Soep") && !productType.equals("")) {
                        isSorted = false;
                    }
                }

                if (currentType.equals("Pasta's:")) {
                    if (!productType.equals("Pasta") && !productType.equals("")) {
                        isSorted = false;
                    }
                }
                indexInList += 1;
            }
        }
        return isSorted;
    }

    public boolean containsDescription(String meal, String description, String Vegetarian) {
        List<WebElement> trlist = driver.findElements(By.tagName("tr"));
        boolean containsMeal = false;
        boolean containsDescription = false;
        for (WebElement tr : trlist) {
            List<WebElement> tdlist = tr.findElements(By.tagName("td"));
            for (WebElement td : tdlist) {
                String inner = td.getAttribute("innerHTML");
                if (meal.equals(inner)) {
                    containsMeal = true;
                }
                if (containsMeal && description.equals(inner)) {
                    containsDescription = true;
                }
                if (containsDescription && Vegetarian.equals(inner)) {
                    return true;
                }
            }
            containsMeal = false;
            containsDescription = false;
        }
        return  false;
    }
}
