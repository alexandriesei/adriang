import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static util.Constants.BASE_URI;
import static util.Constants.VALUECORRECTLY_FROM_LOT_DROPDOWN;

public class ParkingTest {

    private ParkingCalculator parking;

    WebDriver driver;

    @BeforeSuite
    public void bef() {
        String pathToDriver = ".\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void init() {
        driver.get(BASE_URI);
        parking = new ParkingCalculator(driver);
    }

    @DataProvider(name = "correctinfo")
    public Object[][] createData1() {
        return new Object[][]{
                {VALUECORRECTLY_FROM_LOT_DROPDOWN, "10:00", "2/22/2019", "11:00", "2/22/2019"},
                {VALUECORRECTLY_FROM_LOT_DROPDOWN, "05:00", "5/11/2019", "06:00", "5/11/2019"},
                {VALUECORRECTLY_FROM_LOT_DROPDOWN, "03:45", "5/12/2019", "04:00", "5/12/2019"},
                {VALUECORRECTLY_FROM_LOT_DROPDOWN, "07:15", "7/07/2020", "08:05", "7/07/2020"},
                {VALUECORRECTLY_FROM_LOT_DROPDOWN, "07:15", "7/07/2020", "07:16", "7/07/2020"}

        };
    }

    @Test(dataProvider = "correctinfo")
    public void validatePriceWithOnlyInfoCorrectly(String lotvalue, String timestart, String datestart, String exittime, String exitdate) {
        parking = new ParkingCalculator(driver);
        parking.testTest(lotvalue, timestart, datestart, exittime, exitdate);

    }

    @AfterMethod
    public void calculatePriceForSelectedValue() {
        parking.clickPressCalculateButton();
    }

    @AfterSuite
    public void closeBrowser() {
        driver.close();
    }
}

