package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {

    public final By acceptCookies = By.cssSelector("div[class^=zyro-cookies]>button");
    public final By joinZyro = By.cssSelector("[class^='button auth-links__button']");
    public final By pageHeader = By.cssSelector("[class^='auth__title ']");
    public final By optionToJoin = By.xpath("//button[starts-with(@class, 'button alternate')]");
    public final By emailInput = By.id("email");
    public final By passwordInput = By.id("password");
    public final By error = By.id("auth-error");
    public final By signUp = By.cssSelector("[class^='button signup__button']");
    public final By loginInError = By.cssSelector("[class^='slot']");
    public final By checkboxContainer = By.className("signup__checkbox-container");
    public final By checkbox = By.id("checkbox");

}
