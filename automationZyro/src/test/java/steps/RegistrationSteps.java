package steps;

import elements.Elements;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegistrationSteps extends Elements {

    public static WebDriver driver = null;


    @Before
    public void setUpBrowser() {
        System.out.println("Browser setup");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\automationZyro\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    @Given("that user open Zyro website")
    public void thatUserOpenZyroWebsite() {
        driver.get("https://zyro.com/uk");
        assertEquals("Website was different", "Website Builder - Holiday Sale | Up to 69% Off | Zyro", driver.getTitle());
    }

    @And("user accepts cookie banner")
    public void userAcceptsCookieBanner() {
        driver.findElement(acceptCookies).click();
    }

    @When("user clicks on Join Zyro button")
    public void userClicksOnJoinZyroButton() {
        WebElement button = driver.findElement(joinZyro);
        button.click();
    }

    @Then("user is on {string} page")
    public void userIsOnPage(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));

        boolean isOnRegistration = driver.getCurrentUrl().contains(pageTitle);
        assertTrue("Different page was opened", isOnRegistration);
    }

    @When("user clicks on {string} button on Registration page")
    public void userClicksOnButtonOnRegistrationPage(String buttonToClick) {
        List<WebElement> buttons = driver.findElements(optionToJoin);
        for (WebElement button : buttons){
            if (button.getText().equals(buttonToClick)){
                button.click();
            }
        }
    }

    @And("user enters email address {string} and password {string}")
    public void userEntersEmailAddressAndPassword(String email, String password) {
        WebElement emailInputField = driver.findElement(emailInput);
        emailInputField.click();
        emailInputField.clear();
        emailInputField.sendKeys(email);

        WebElement passwordInputField = driver.findElement(passwordInput);
        passwordInputField.click();
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    @And("user clicks on SignUp button")
    public void userClicksOnSignUpButton() {
        WebElement button = driver.findElement(signUp);
        button.click();
    }

    @Then("error message that email is already used is displayed")
    public void errorMessageThatEmailIsAlreadyUsedIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class^='loader']")));

        boolean isErrorDisplayed = driver.findElement(error).isDisplayed();
        assertTrue("Error is not displayed", isErrorDisplayed);
    }

    @When("user clicks Login in error message on Registration page")
    public void userClicksLoginInErrorMessageOnRegistrationPage() {
        WebElement loginButton = driver.findElement(loginInError);
        loginButton.click();
    }

    @Then("user is on SigIn page")
    public void userIsOnSigInPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkboxContainer));
        boolean isOnSigin = driver.getCurrentUrl().contains("signin");
        assertTrue("Different page was opened", isOnSigin);
    }
}
