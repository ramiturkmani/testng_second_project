package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import javax.swing.*;

public class UnitedAirlinesTest extends Base{

    @Test(priority = 1, description = "Validate Main Menu")
    public void testMainMenu(){
        driver.get("https://www.united.com/en/us");

        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(unitedHomePage.mainMenu.get(i).isDisplayed());
            switch (i){
                case 0:
                    Assert.assertEquals(unitedHomePage.mainMenu.get(i).getText(), "BOOK");
                    break;
                case 1:
                    Assert.assertEquals(unitedHomePage.mainMenu.get(i).getText(), "MY TRIPS");
                    break;
                case 2:
                    Assert.assertEquals(unitedHomePage.mainMenu.get(i).getText(), "TRAVEL INFO");
                    break;
                case 3:
                    Assert.assertEquals(unitedHomePage.mainMenu.get(i).getText(), "MILEAGEPLUS® PROGRAM");
                    break;
                case 4:
                    Assert.assertEquals(unitedHomePage.mainMenu.get(i).getText(), "DEALS");
                    break;
                case 5:
                    Assert.assertEquals(unitedHomePage.mainMenu.get(i).getText(), "HELP");
                    break;
                default:
                    throw new NotFoundException("Unexpected element found!!!");
            }
        }
    }

    @Test(priority = 2, description = "Validate Book Travel Menu")
    public void testBookTravelMenu(){
        driver.get("https://www.united.com/en/us");

        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(unitedHomePage.bookTravelMenu.get(i).isDisplayed());
            switch (i){
                case 0:
                    Assert.assertEquals(unitedHomePage.bookTravelMenu.get(i).getText(), "Book");
                    break;
                case 1:
                    Assert.assertEquals(unitedHomePage.bookTravelMenu.get(i).getText(), "Flight status");
                    break;
                case 2:
                    Assert.assertEquals(unitedHomePage.bookTravelMenu.get(i).getText(), "Check-in");
                    break;
                case 3:
                    Assert.assertEquals(unitedHomePage.bookTravelMenu.get(i).getText(), "My trips");
                    break;
                default:
                    throw new NotFoundException("Unexpected element found!!!");
            }
        }
    }

    @Test(priority = 3, description = "Validate Round-trip and One-way")
    public void testRadioButtons(){
        driver.get("https://www.united.com/en/us");
        for (int i = 0; i < 2; i++) {
            Assert.assertTrue(unitedHomePage.travelTypeText.get(i).isDisplayed());
            Assert.assertTrue(unitedHomePage.travelTypeRadioButtons.get(i).isEnabled());
            switch(i){
                case 0:
                    Assert.assertTrue(unitedHomePage.travelTypeRadioButtons.get(i).isSelected());
                    Assert.assertEquals(unitedHomePage.travelTypeText.get(i).getText(), "Roundtrip");
                    break;
                case 1:
                    Assert.assertFalse(unitedHomePage.travelTypeRadioButtons.get(i).isSelected());
                    Assert.assertEquals(unitedHomePage.travelTypeText.get(i).getText(), "One-way");
                    break;
            }
        }
        actions.click(unitedHomePage.travelTypeRadioButtons.get(1)).perform();

        Assert.assertFalse(unitedHomePage.travelTypeRadioButtons.get(0).isSelected());
        Assert.assertTrue(unitedHomePage.travelTypeRadioButtons.get(1).isSelected());
    }

    @Test(priority = 4, description = "Validate Book with miles and flexible dates")
    public void testCheckboxes(){
        driver.get("https://www.united.com/en/us");
        Assert.assertTrue(unitedHomePage.bookWithMilesText.isDisplayed());
        Assert.assertTrue(unitedHomePage.bookWithMiles.isEnabled());
        Assert.assertFalse(unitedHomePage.bookWithMiles.isSelected());

        Assert.assertTrue(unitedHomePage.flexibleDatesText.isDisplayed());
        Assert.assertTrue(unitedHomePage.flexibleDates.isEnabled());
        Assert.assertFalse(unitedHomePage.flexibleDates.isSelected());

        actions.click(unitedHomePage.bookWithMilesText).perform();
        actions.click(unitedHomePage.flexibleDatesText).perform();
        Assert.assertTrue(unitedHomePage.bookWithMiles.isSelected());
        Assert.assertTrue(unitedHomePage.flexibleDates.isSelected());

        actions.click(unitedHomePage.bookWithMilesText).perform();
        actions.click(unitedHomePage.flexibleDatesText).perform();
        Assert.assertFalse(unitedHomePage.bookWithMiles.isSelected());
        Assert.assertFalse(unitedHomePage.flexibleDates.isSelected());
    }

    @Test(priority = 5, description = "Validate one way ticket search")
    public void testTicketBuyingProcess(){
        driver.get("https://www.united.com/en/us");

        actions.click(unitedHomePage.travelTypeRadioButtons.get(1)).perform();
        actions.click(unitedHomePage.fromInput).keyDown(Keys.COMMAND).sendKeys("a").perform();
        actions.keyUp(Keys.COMMAND).perform();
        actions.sendKeys("Chicago, IL, US (ORD)").perform();
        actions.sendKeys(unitedHomePage.toInput,"Miami, FL, US (MIA)").perform();
        actions.click(unitedHomePage.dateInput).perform();

        for (int i = 0; i < 4; i++) {
            actions.click(unitedHomePage.nextButton).perform();
            Waiter.pause(2);
        }
        actions.click(unitedHomePage.jan30).perform();
        actions.click(unitedHomePage.travelersInput).perform();
        actions.click(unitedHomePage.plusButton).perform();
        actions.click(unitedHomePage.typeDropDown).perform();
        actions.click(unitedHomePage.businessOrFirst).perform();
        actions.click(unitedHomePage.submitButton).perform();

        Assert.assertEquals(unitedHomePage.departHeader.getText(), "Depart: Chicago, IL, US to Miami, FL, US");
    }
}
