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
        /**
         * You need to add The path of your own Chromedrive to be able to run the tests
         * You can uncomment and add your own path
         */

        //System.setProperty("webdriver.chrome.driver", "D:\\Ucll 2020-2021\\Webontwikkeling 2\\Chromedriver + Selenium + jstl\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(path);
    }

    @After
    public void clean() {
        driver.quit();
    }


    @Given("all meals are on the menu")
    public void all_meals_are_on_the_menu() {
        driver.get(path + "Controller?command=Overview");

        meals.add(new Meals("Niet-veggie Lasagne", "Pasta", "4.50", "Met vlees en extra kaas", "nee"));
        meals.add(new Meals("Veggie lasagne", "Pasta", "4.00", "Vegetarisch zonder kaas", "ja"));
        meals.add(new Meals("Tonijn Wrap", "Wrap", "2.90", "Met tonijn en glutenvrij", "nee"));
        meals.add(new Meals("Broodje groenten", "Broodje", "2.50", "Met alleen groenten", "ja"));
        meals.add(new Meals("Broodje boulet", "Broodje", "3.00", "Met boulet en gluten", "nee"));
        meals.add(new Meals("Kip Wrap", "Wrap", "3.10", "Met kip en gluten", "nee"));
        meals.add(new Meals("Spagheti bolongaise", "Pasta", "5.00", "Met vlees en gluten", "nee"));
        meals.add(new Meals("Tomatensoep", "Soep", "3.75", "Vegetarisch", "ja"));
        meals.add(new Meals("Broodje hesp", "Broodje", "3.00", "Met vlees en gluten", "nee"));
        meals.add(new Meals("Kippensoep", "Soep", "4.00", "Met vleesballetjes", "nee"));
        meals.add(new Meals("Broodje kaas", "Broodje", "2", "Vegetarisch, bevat lactose en gluten", "ja"));
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

    @Given("there are no meals on the menu")
    public void there_are_no_meals_on_the_menu() {
        driver.get(path + "?command=Overview&leeg=ja");
    }

    @When("Yarne looks at the emtpy menu")
    public void Yarne_looks_at_the_empty_menu() {
        currentPage = PageFactory.initElements(driver, EmptyOverviewPage.class);
    }

    @Then("Yarne should gets a message to warn him there are no meals on the me")
    public void Yarne_should_gets_a_message_to_warn_him_there_are_no_meals_on_the_menu() {
        assertEquals("Meal overview - Gerechten app", driver.getTitle());
        assertTrue(((EmptyOverviewPage) currentPage).isPageEmpty("Er zijn geen maaltijden op het menu"));
    }

    @Given("there are meals on the menu all the information")
    public void there_are_meals_on_the_menu_all_the_information() {
        driver.get(path + "?command=Overview");
    }

    //     Yarne should see each "<Meal>" with its respective "<Price>"
    @Then("Yarne should see each {string} with its respective {string}")
    public void Yarne_should_see_each_meal_with_its_respective_price(String Meal, String Price) {
        assertEquals("Meal overview - Gerechten app", driver.getTitle());
        assertTrue(((OverviewPage) currentPage).containsPrice(Meal, Price));
    }

    @Then("Yarne should see all the Meals grouped by their Type")
    public void Yarne_should_see_all_the_Meals_grouped_by_their_Type() {
        assertEquals("Meal overview - Gerechten app", driver.getTitle());
        assertTrue(((OverviewPage) currentPage).isSortedByType());
    }
    //     Yarne should see each "<Meal>" with information over the "<Description>" and if it is "<Vegetarian>"
    @Then("Yarne should see each {string} with information over the {string} and if it is {string}")
    public void Yarne_should_see_all_the_meal_with_information_over_description_and_vegetarian(String Meal, String Description, String Vegetarian) {
        assertEquals("Meal overview - Gerechten app", driver.getTitle());
        assertTrue(((OverviewPage) currentPage).containsDescription(Meal, Description, Vegetarian));
    }
}
