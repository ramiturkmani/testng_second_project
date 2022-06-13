package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class UnitedHomePage {
    public UnitedHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[role='tablist']>a")
    public List<WebElement> mainMenu;

    @FindBy(xpath = "(//ul[@role='tablist'])[2]/li")
    public List<WebElement> bookTravelMenu;

    @FindBy(css = "fieldset[name] label input")
    public List<WebElement> travelTypeRadioButtons;

    @FindBy(css = "fieldset[name] label")
    public List<WebElement> travelTypeText;

    @FindBy(id = "award")
    public WebElement bookWithMiles;

    @FindBy(css = "label[for='award']")
    public WebElement bookWithMilesText;

    @FindBy(id = "flexibleDates")
    public WebElement flexibleDates;

    @FindBy(id = "flexDatesLabel")
    public WebElement flexibleDatesText;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInput;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInput;

    @FindBy(className = "SingleDatePicker")
    public WebElement dateInput;

    @FindBy(css = ".DayPickerNavigation__horizontal>button:nth-child(2)")
    public WebElement nextButton;

    @FindBy(xpath = "//td[@aria-label='Monday, January 30, 2023']")
    public WebElement jan30;

    @FindBy(css = "#passengerSelector>button")
    public WebElement travelersInput;

    @FindBy(xpath = "(//button[text()='+'])[1]")
    public WebElement plusButton;

    @FindBy(id = "cabinType")
    public WebElement typeDropDown;

    @FindBy(id = "cabinType_item-2")
    public WebElement businessOrFirst;

    @FindBy(xpath = "//button[@aria-label='Find flights']")
    public WebElement submitButton;

    @FindBy(xpath = "//h2/div")
    public WebElement departHeader;

}
