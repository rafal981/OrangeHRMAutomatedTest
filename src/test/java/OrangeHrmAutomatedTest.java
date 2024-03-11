import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testTools.DataGenerator;
import testTools.RepeatedActions;
import java.time.Duration;


public class OrangeHrmAutomatedTest {
        private WebDriver driver;

        @BeforeMethod
        public void beforeMethod() {
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

        @Test
        public void asAdminAddNewAdministratorAccountTest() throws InterruptedException {
            WebElement usernameLabel = driver.findElement(By.name("username"));
            usernameLabel.sendKeys("Admin");

            WebElement passwordLabel = driver.findElement(By.name("password"));
            passwordLabel.sendKeys("admin123");

            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
            loginButton.click();

            WebElement adminRadioButton = driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']"));
            adminRadioButton.click();

            WebElement addButton = driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button"));
            addButton.click();

            WebElement userRoleDropdown = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
            userRoleDropdown.click();

            WebElement selectAdminDropdown = driver.findElement(By.xpath("(//span[text()='Admin'])[2]"));
            selectAdminDropdown.click();

            WebElement statusDropdown = driver.findElement(By.xpath(("(//div[@class='oxd-select-text-input'])[2]")));
            statusDropdown.click();

            WebElement selectEnabledDropdown = driver.findElement(By.xpath("//span[text()='Enabled']"));
            selectEnabledDropdown.click();

            WebElement randomUserPassword = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]"));
            String generatedPassword = DataGenerator.generatePassword(10);
            randomUserPassword.sendKeys(generatedPassword);
            System.out.println(randomUserPassword);

            WebElement loggedUser = driver.findElement(By.cssSelector("p[class='oxd-userdropdown-name']"));
            String user = loggedUser.getText();

            WebElement employeeNameLabel = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-wrapper']//input[1]"));
            RepeatedActions.deletingAndAddingContentToLabel(driver, employeeNameLabel, user);

            WebElement employeeNameDropdownSelect = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']//span"));
            employeeNameDropdownSelect.click();

            WebElement addUsernameLabel = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
            addUsernameLabel.click();

            WebElement randomUsernameLogin = driver.findElement(By.xpath("(//div[@class='oxd-grid-item oxd-grid-item--gutters']//input)[2]"));
            String generatedLogin = DataGenerator.generateLogin();
            randomUsernameLogin.sendKeys(generatedLogin);
            System.out.println(randomUsernameLogin);

            WebElement confirmUserPassword = driver.findElement(By.xpath("(//div[@class='oxd-input-group oxd-input-field-bottom-space']//input)[4]"));
            confirmUserPassword.sendKeys(generatedPassword);

            WebElement element = driver.findElement(By.xpath("//form[@class='oxd-form']//button[2]"));
            Thread.sleep(5000);
            element.click();

            Actions actions = new Actions(driver);
            WebElement save = driver.findElement(By.xpath("//form[@class='oxd-form']//button[2]"));
            actions.doubleClick(save).perform();

            WebElement positiveAlert = driver.findElement(By.cssSelector("div[class='oxd-toast-icon-container']"));
            Assert.assertTrue(positiveAlert.isDisplayed());
        }

        @AfterMethod
        public void afterMethod() {
            driver.close();
            driver.quit();
        }
    }
