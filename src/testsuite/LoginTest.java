package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement userLogIn = driver.findElement(By.id("login-button"));
        userLogIn.click();
        //verify the text products
        WebElement textMessage = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        String expectedMessage = "Products";
        String actualMessage = textMessage.getText();
        Assert.assertEquals( expectedMessage, actualMessage);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement userLogIn = driver.findElement(By.id("login-button"));
        userLogIn.click();
        //verify the six products

        List<WebElement> count = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int totalcount = count.size();
        System.out.println("Total Products are : " + totalcount);
        Assert.assertEquals(6, count.size());
        //Thread.sleep(3000);


    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
