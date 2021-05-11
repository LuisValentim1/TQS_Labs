package Project.TQS_AirQuality.Selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

class SeleniumTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void search() {
        driver.get("http://localhost:8080/");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.id("cityName")).click();
        driver.findElement(By.id("cityName")).sendKeys("Porto");
        driver.findElement(By.name("results")).click();
        driver.findElement(By.id("info_div")).click();
        {
            WebElement element = driver.findElement(By.id("info_div"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
        driver.close();
    }

    @Test
    void everythingInPlaceOnInitialization(){
        driver.get("http://localhost:8080/");
        driver.manage().window().setSize(new Dimension(1536, 824));
        driver.findElement(By.cssSelector("h2")).click();
        assertEquals("CHOOSE YOUR CITY", driver.findElement(By.cssSelector("h2")).getText());
        driver.findElement(By.id("cityName")).click();
        {
            WebElement element = driver.findElement(By.id("cityName"));
            Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
            assertTrue(isEditable);
        }
        driver.findElement(By.name("results")).click();
        {
            List<WebElement> elements = driver.findElements(By.name("results"));
            assert(elements.size() > 0);
        }
        driver.close();
    }
}
