package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.UnitedHomePage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    Actions actions;
    UnitedHomePage unitedHomePage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        actions = new Actions(driver);
        unitedHomePage = new UnitedHomePage(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}
