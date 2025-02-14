package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFunctions.GithubPageFunctions;

public class GithubRepoCreationSteps {
    WebDriver driver;
    GithubPageFunctions pageFunctions;

    public GithubRepoCreationSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prakhar.agarwal\\Documents\\Developers\\UI Testing\\Generated-Tests\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe"); // <-- Update this path!
        // Add Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");  
        options.addArguments("--disable-dev-shm-usage");  
        options.addArguments("--no-sandbox");  
        options.addArguments("--headless");  
        options.addArguments("--disable-gpu");  
        options.addArguments("--disable-software-rasterizer");  
        options.addArguments("--disable-blink-features=AutomationControlled");  
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");  
        options.addArguments("--disable-infobars");  
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver();
        pageFunctions = new GithubPageFunctions(driver);
    }

    @Given("the user navigates to {string}")
    public void the_user_navigates_to(String url) {
        driver.navigate().to(url);
    }

    @When("the user enters {string} into the login field")
    public void the_user_enters_into_the_login_field(String username) {
        pageFunctions.enterLogin(username);
    }

    @And("the user enters {string} into the password field")
    public void the_user_enters_into_the_password_field(String password) {
        pageFunctions.enterPassword(password);
    }

    @And("the user clicks the sign in button")
    public void the_user_clicks_the_sign_in_button() {
        pageFunctions.clickSignInButton();
    }

    @And("the user clicks the {string} button to create a new repository")
    public void the_user_clicks_the_button_to_create_a_new_repository(String buttonText) {
        if(buttonText.equals("New")){
            pageFunctions.clickNewButton();
        }
    }

    @And("the user enters {string} into the repository name field")
    public void the_user_enters_into_the_repository_name_field(String repoName) {
        pageFunctions.enterRepositoryName(repoName);
    }

    @And("the user selects {string} for repository visibility")
    public void the_user_selects_for_repository_visibility(String visibility) {
        if(visibility.equals("private")) {
            pageFunctions.selectRepositoryVisibility();
        }
    }

    @And("the user checks the {string} checkbox")
    public void the_user_checks_the_checkbox(String checkboxText) {
        if(checkboxText.equals("Initialize this repository with a README")) {
            pageFunctions.checkReadMeCheckbox();
        }
    }

    @And("the user selects {string} as the .gitignore template")
    public void the_user_selects_as_the_gitignore_template(String template) {
        pageFunctions.enterGitignoreTemplate(template);
        pageFunctions.selectGitignoreTemplateOption();
    }

    @And("the user selects {string} as the license")
    public void the_user_selects_as_the_license(String license) {
        if(license.equals("Apache License 2.0")) {
            pageFunctions.selectLicenseOption();
        }
    }

    @Then("the user clicks the {string} button")
    public void the_user_clicks_the_button(String buttonText) {
        if(buttonText.equals("Create repository")) {
            pageFunctions.clickCreateRepositoryButton();
        }
    }
}