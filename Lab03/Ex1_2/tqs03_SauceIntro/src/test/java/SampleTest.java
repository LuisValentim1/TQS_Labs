import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    WebDriver browser;

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        browser = new ChromeDriver();
    }

    @Test
    void headerTest(){
        browser.get("https://saucelabs.com/");
        WebElement href = browser.findElement(By.id("headerMainNav"));
        assertTrue(href.isDisplayed());
    }

    @AfterEach
    void tearDown(){
        browser.close();
    }

}