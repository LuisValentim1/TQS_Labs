import java.util.HashMap;
import java.util.NoSuchElementException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeSearchSteps {

    private WebDriver driver;

    @Given("I have an open Chrome browser")
    public void i_have_an_open_chrome_browser() {
        driver = new ChromeDriver();
    }
    @When("I navigate to {string}")
    public void i_navigate_to(String string) {
        driver.get(string);
        driver.manage().window().setSize(new Dimension(1536, 824));
    }
    @When("Select {string} as Departure City")
    public void select(String string) {
        driver.findElement(By.name("fromPort")).click();
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = '" + string + "']")).click();
        }
        driver.findElement(By.name("fromPort")).click();
    }
    @When("I press Find Flights")
    public void i_press_find_flights() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
    @Then("I should a page with the title {string}")
    public void i_should_a_page_with_the_title(String string) {
        driver.findElement(By.cssSelector("body")).click();
        assertEquals(string, driver.findElement(By.cssSelector("h3")).getText());
    }
}
