package pageFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GithubPageFunctions {
    
    private final WebDriver driver;
    private final WebDriverWait wait;

    public GithubPageFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Navigate to URL
    public void navigateToGitHubLogin() {
        driver.navigate().to("https://github.com/login");
    }

    // Enter text into the login field
    public void enterLogin(String username) {
        WebElement loginField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='login_field' and @name='login']")));
        loginField.clear();
        loginField.sendKeys(username);
    }

    // Enter text into the password field
    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password' and @name='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // Click the sign in button
    public void clickSignInButton() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='commit' and @value='Sign in']")));
        signInButton.click();
    }

    // Click the New button
    public void clickNewButton() {
        WebElement newButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='New']")));
        newButton.click();
    }

    // Enter text into the repository name field
    public void enterRepositoryName(String repoName) {
        WebElement repoNameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=':r5:' and @data-component='input']")));
        repoNameField.clear();
        repoNameField.sendKeys(repoName);
    }

    // Select repository visibility
    public void selectRepositoryVisibility() {
        WebElement visibilityRadioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=':rg:' and @name='visibilityGroup']")));
        if (!visibilityRadioButton.isSelected()) {
            visibilityRadioButton.click();
        }
    }

    // Check the Initialize repository with README checkbox
    public void checkReadMeCheckbox() {
        WebElement readMeCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=':ri:' and @type='checkbox']")));
        if (!readMeCheckbox.isSelected()) {
            readMeCheckbox.click();
        }
    }

    // Enter text into the .gitignore template input field
    public void enterGitignoreTemplate(String template) {
        WebElement gitignoreField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='UnstyledTextInput__ToggledUnstyledTextInput-sc-14ypya-0 jkNcAv' and @placeholder='Filter…']")));
        gitignoreField.clear();
        gitignoreField.sendKeys(template);
    }

    // Select the .gitignore template option
    public void selectGitignoreTemplateOption() {
        WebElement gitignoreOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='Item__TextContainer-sc-y6iv6t-3 bvbgsO' and text()='Python']")));
        gitignoreOption.click();
    }

    // Select the license option
    public void selectLicenseOption() {
        WebElement licenseOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='Item__TextContainer-sc-y6iv6t-3 bvbgsO' and text()='Apache License 2.0']")));
        licenseOption.click();
    }

    // Click the Create repository button
    public void clickCreateRepositoryButton() {
        WebElement createRepoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create repository']")));
        createRepoButton.click();
        System.out.println("Repository created successfully.");
    }
}
