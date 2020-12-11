package ui.steps;

import domain.model.Meals;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ui.EmptyOverviewPage;
import ui.OverviewPage;
import ui.Page;
import java.util.*;
import static org.junit.Assert.*;

public class ViewAllMealsSteps {

    private WebDriver driver;
    private String path = "http://localhost:8080/";

    private Page currentPage;
    private org.openqa.selenium.support.PageFactory PageFactory;
    public ArrayList<Meals> meals = new ArrayList<>();

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/Users/.../web3pers/chromedriver");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 ...

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Zeno\\Desktop\\geckodriver-v0.28.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();

        meals.add(new Meals("Niet-veggie Lasagne","Pasta",4.50,"Met vlees en extra kaas"));
        meals.add(new Meals("Veggie lasagne","Pasta",4.00,"Vegetarisch zonder kaas"));
        meals.add(new Meals("Broodje kaas","Broodje", 2.50, "Met kaas en glutenvrij"));
        meals.add(new Meals("Tonijn Wrap","Wrap", 2.90, "Met tonijn en glutenvrij"));
        meals.add(new Meals("Broodje groenten","Broodje", 2.50, "Met alleen groenten"));
        meals.add(new Meals("Broodje boulet","Broodje", 3.0,"Met boulet en gluten"));
        meals.add(new Meals("Kip Wrap","Wrap", 3.10, "Met kip en gluten"));
        meals.add(new Meals("Spagheti bolongaise","Pasta", 5.00, "Met vlees en gluten"));
        meals.add(new Meals("Tomatensoep", "Soep", 3.75, "Vegetarisch"));
        meals.add(new Meals("Broodje hesp", "Broodje", 3.00, "Met vlees en gluten"));
        meals.add(new Meals("Kippensoep", "Soep", 4.00, "Met vleesballetjes"));
        meals.add(new Meals("Broodje kaas", "Broodje", 2.50, "Vegetarisch, bevat lactose en gluten"));
    }

    @After
    public void clean() {
        driver.quit();
    }


    @Given ("all meals are on the menu")
    public void all_meals_are_on_the_menu(){
        driver.get(path+"Controller?command=Overview" );
        meals.add(new Meals("Niet-veggie Lasagne","Pasta","4.50","Met vlees en extra kaas"));
        meals.add(new Meals("Veggie lasagne","Pasta","4.00","Vegetarisch zonder kaas"));
        meals.add(new Meals("Broodje kaas","Broodje", "2.50", "Met kaas en glutenvrij"));
        meals.add(new Meals("Tonijn Wrap","Wrap", "2.90", "Met tonijn en glutenvrij"));
        meals.add(new Meals("Broodje groenten","Broodje", "2.50", "Met alleen groenten"));
        meals.add(new Meals("Broodje boulet","Broodje", "3.00","Met boulet en gluten"));
        meals.add(new Meals("Kip Wrap","Wrap", "3.10", "Met kip en gluten"));
        meals.add(new Meals("Spagheti bolongaise","Pasta", "5.00", "Met vlees en gluten"));
        meals.add(new Meals("Tomatensoep", "Soep", "3.75", "Vegetarisch"));
        meals.add(new Meals("Broodje hesp", "Broodje", "3.00", "Met vlees en gluten"));
        meals.add(new Meals("Kippensoep", "Soep", "4.00", "Met vleesballetjes"));
        meals.add(new Meals("Broodje kaas", "Broodje", "2.50", "Vegetarisch, bevat lactose en gluten"));
    }

    @When("Yarne looks at the menu")
    public void Yarne_looks_at_the_menu() {
        currentPage = PageFactory.initElements(driver, OverviewPage.class);
    }

    @Then("Yarne should see an overview of all meals")
    public void yarne_should_see_an_overview_of_all_meals() {
        assertEquals("Meal overview - Gerechten app", driver.getTitle());
        assertTrue(((OverviewPage) currentPage).containsMeals(meals));
    }

    @Given ("there are no meals on the menu")
    public void there_are_no_meals_on_the_menu(){
        driver.get(path+"?command=Overview&leeg=ja");
    }

    @When("Yarne looks at the emtpy menu")
    public void Yarne_looks_at_the_empty_menu() {
        currentPage = PageFactory.initElements(driver, EmptyOverviewPage.class);
    }

    @Then("Yarne should gets a message to warn him there are no meals on the me")
    public void Yarne_should_gets_a_message_to_warn_him_there_are_no_meals_on_the_menu() {
        assertEquals("Meal overview - Gerechten app", driver.getTitle());
        assertTrue(((EmptyOverviewPage)currentPage).isPageEmpty("Er zijn geen maaltijden op het menu"));
    }

    @Given ("there are meals on the menu with given price")
    public void there_are_meals_on_the_menu_with_given_price(){
        driver.get(path+"?command=Overview");
    }

    @Then("Yarne should see each {string} with its respective {string}")
    public void Yarne_should_see_each_meal_with_its_respective_price(String Meal, String Price) {
        assertEquals("Meal overview - Gerechten app", driver.getTitle());
        assertTrue(((OverviewPage)currentPage).containsPrice(Meal, Price));
    }


}
