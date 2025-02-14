package pageFunctions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourPageFunctions {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public YourPageFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickGetStartedButton() {
        WebElement getStartedButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@title='Get Started' and text()='Get Started']")
        ));
        getStartedButton.click();
    }

    private boolean switchToIframe() {
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        for (WebElement iframe : iframes) {
            try {
                driver.switchTo().frame(iframe);
                // Verify if the expected input field is present in this iframe
                if (driver.findElements(By.xpath("//input[@name='firstname']")).size() > 0) {
                    return true; // Found correct iframe
                }
                driver.switchTo().defaultContent(); // Reset if not the correct iframe
            } catch (Exception e) {
                driver.switchTo().defaultContent();
            }
        }
        return false; // No valid iframe found
    }

    public void enterFirstName(String firstName) {
        if (switchToIframe()) {
            WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='firstname' and @autocomplete='given-name']")
            ));
            firstNameInput.click();
            firstNameInput.clear();
            firstNameInput.sendKeys(firstName);
            driver.switchTo().defaultContent();
        } else {
            throw new RuntimeException("Could not locate iframe containing first name field.");
        }
    }

    public void enterLastName(String lastName) {
        if (switchToIframe()) {
            WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='lastname' and @autocomplete='family-name']")
            ));
            lastNameInput.click();
            lastNameInput.clear();
            lastNameInput.sendKeys(lastName);
            driver.switchTo().defaultContent();
        } else {
            throw new RuntimeException("Could not locate iframe containing last name field.");
        }
    }

    public void enterEmail(String email) {
        if (switchToIframe()) {
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@name='email' and @autocomplete='email']")
            ));
            emailInput.click();
            emailInput.clear();
            emailInput.sendKeys(email);
            driver.switchTo().defaultContent();
        } else {
            throw new RuntimeException("Could not locate iframe containing email field.");
        }
    }
}
