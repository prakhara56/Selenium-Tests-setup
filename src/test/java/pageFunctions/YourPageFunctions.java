package pageFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourPageFunctions {

    WebDriver driver;
    WebDriverWait wait;

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

    public void enterFirstName(String firstName) {
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@name='firstname' and @autocomplete='given-name']")
        ));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@name='lastname' and @autocomplete='family-name']")
        ));
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@name='email' and @autocomplete='email']")
        ));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
}
