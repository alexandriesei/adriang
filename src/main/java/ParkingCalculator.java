import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParkingCalculator {
    public WebDriver driver;
    By lotLocator = By.id("Lot");
    By entryTime = By.id("EntryTime");
    By entryDate = By.id("EntryDate");
    By exitTime = By.id("ExitTime");
    By exitDate = By.id("ExitDate");
    By pressSubmitButton = By.xpath("//input[@name='Submit']");


    public ParkingCalculator(WebDriver driver) {
        this.driver = driver;
    }

    public void lotLocatorPopulate(String value) {
        Select element = new Select(driver.findElement(lotLocator));
        element.selectByValue(value);
    }

    public void populateEntryTime(String timestart) {
        driver.findElement(entryTime).clear();
        driver.findElement(entryTime).sendKeys(timestart);
    }

    public void populateEntryDate(String datestart) {
        driver.findElement(entryDate).clear();
        driver.findElement(entryDate).sendKeys(datestart);
    }

    public void populateExitTime(String exittime) {
        driver.findElement(exitTime).clear();
        driver.findElement(exitTime).sendKeys(exittime);
    }

    public void populateExitDate(String exitdate) {
        driver.findElement(exitDate).clear();
        driver.findElement(exitDate).sendKeys(exitdate);
    }

    public void clickPressCalculateButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pressSubmitButton));
        driver.findElement(pressSubmitButton).click();
    }


    public void testTest(String lotvalue, String timestart, String datestart, String exittime, String exitdate) {
        lotLocatorPopulate(lotvalue);
        populateEntryTime(timestart);
        populateEntryDate(datestart);
        populateExitTime(exittime);
        populateExitDate(exitdate);
    }
}
