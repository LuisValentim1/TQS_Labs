import com.toptal.webpages.DeveloperApplyPage;
import com.toptal.webpages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperApplyPageTest {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){
        driver.close();
    }

    @Test
    void applyAsDeveloperTest(){

        HomePage home = new HomePage(driver);
        home.clickOnDeveloperApplyButton();

        DeveloperApplyPage page = new DeveloperApplyPage(driver);
        assertTrue(page.isPageOpened());

        page.setDeveloper_talent();
        page.setDeveloper_email("l.v.g.v.72@gmail.com");
        page.setDeveloper_password("password123");
        page.setDeveloper_full_name("Luís Valen");
        page.setDeveloper_password_confirmation("password123");


        page.clickOnJoin();
    }
}