package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFunctions.YourPageFunctions;


public class StepDefinitions {
    WebDriver driver;
    YourPageFunctions pageFunctions;

    public StepDefinitions() {
        // Set ChromeDriver path (Ensure ChromeDriver is installed)
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
        pageFunctions = new YourPageFunctions(driver);
    }

    // WebDriver driver = new ChromeDriver();
    // YourPageFunctions pageFunctions = new YourPageFunctions(driver);
    // C:\Users\paritosh.sharma\Downloads\chromedriver-win64\chromedriver-win64

    @Given("the user is on the AssetMark homepage")
    public void theUserIsOnTheAssetMarkHomepage() {
        System.out.println("This is the user on the AssetMark homepage - iiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        driver.get("https://www.assetmark.com/");
        
        System.out.println("This is the user on the AssetMark homepage - jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
    }

    @When("the user clicks on the 'Get Started' button")
    public void theUserClicksOnTheGetStartedButton() {
        pageFunctions.clickGetStartedButton();
    }

    @Then("the user should be navigated to the consultation request page")
    public void theUserShouldBeNavigatedToTheConsultationRequestPage() {
        System.out.println("User navigated to consultation request page");
    }

    @When("the user clicks in the 'First Name' input field")
    public void theUserClicksInFirstNameInputField() {
        pageFunctions.enterFirstName("");
    }

    @And("the user types 'pra' into the 'First Name' input field")
    public void theUserTypesPraIntoFirstNameInputField() {
        pageFunctions.enterFirstName("pra");
    }

    @When("the user clicks in the 'Last Name' input field")
    public void theUserClicksInLastNameInputField() {
        pageFunctions.enterLastName("");
    }

    @And("the user types 'a' into the 'Last Name' input field")
    public void theUserTypesAIntoLastNameInputField() {
        pageFunctions.enterLastName("a");
    }

    @When("the user clicks in the 'Email' input field")
    public void theUserClicksInEmailInputField() {
        pageFunctions.enterEmail("");
    }

    @And("the user types 'r' into the 'Email' input field")
    public void theUserTypesRIntoEmailInputField() {
        pageFunctions.enterEmail("r");
    }
}
