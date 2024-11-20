package testsuite;

import browserfactory.BaseTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginTest extends BaseTest {
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter "standard_user" for the username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Enter "secret_sauce" for the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Click on the 'Login' button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify the text "Products"
        String actualMessage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String expectedMessage = "Products";
        Assert.assertEquals("Login was not successful" , expectedMessage,actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter "standard_user" for the username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Enter "secret_sauce" for the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Click on the 'Login' button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify that six products are displayed on the page

        List<WebElement> products = driver.findElements(By.className("inventory_item"));

        // Verify that six products are displayed
        int expectedNumberOfProducts = 6;
        Assert.assertEquals("Incorrect number of products displayed", expectedNumberOfProducts, products.size());
    }
    @After
    public void closeBrowser(){
        closeBrowser();

    }
}
