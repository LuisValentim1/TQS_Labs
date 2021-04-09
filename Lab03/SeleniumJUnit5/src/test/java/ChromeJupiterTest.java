import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.seljup.DockerBrowser;

import io.github.bonigarcia.seljup.SeleniumJupiter;

import static io.github.bonigarcia.seljup.BrowserType.OPERA;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.seljup.Arguments;

@ExtendWith(SeleniumJupiter.class)
class ChromeJupiterTest {

    @Test
    void testWithOneChrome(ChromeDriver driver) {
        driver.get("https://blazedemo.com/");
        assertThat(driver.getTitle(),
                containsString("BlazeDemo"));
    }

    @Test
    void headlessTest(@Arguments("--headless") ChromeDriver driver) {
        driver.get("https://blazedemo.com/");
        assertThat(driver.getTitle(),
                containsString("BlazeDemo"));
    }

    @Test
    void blazeTest(ChromeDriver driver){
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(972, 708));
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("h3")).click();
        assertThat(driver.getTitle(), is("BlazeDemo - reserve"));
        driver.findElement(By.cssSelector("html")).click();
        driver.close();
    }

    @Test
    void testOpera(@DockerBrowser(type = OPERA) RemoteWebDriver driver) {
        driver.get("https://blazedemo.com/");
        assertThat(driver.getTitle(),
                containsString("BlazeDemo"));
    }

}