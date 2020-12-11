package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmptyOverviewPage extends Page {
    public EmptyOverviewPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=Overview&leeg=ja");
    }
    public boolean isPageEmpty(String error){
        WebElement emptyPage = driver.findElement(By.id("empty"));
        if (emptyPage.getText().equals(error)) {
            return true;
        }else{
            return false;
        }
    }
}
