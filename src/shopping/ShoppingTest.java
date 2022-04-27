package shopping;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Random;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
//    1.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
//    1.2 Mouse hover on the “Bestsellers”  link and click
        mouseHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul/li[2]/a"));
//    1.3 Verify the text “Bestsellers”
        Thread.sleep(2000);
        verifyText("text is verified", "Bestsellers", By.xpath("//h1[@id='page-title']"));
//    1.4 Mouse hover on “Sort By”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        //and select “Name A-Z”
        mouseHoverAndClick(By.xpath("//ul[@class='display-sort sort-crit grid-list']/li[4]/a"));
//    1.5 Click on “Add to cart” button of the product “Ollie - The App Controlled Robot”
        Thread.sleep(2000);
        mouseHoverAndClick(By.xpath("//ul[@class='products-grid grid-list']/li[5]/div/div[2]/div[4]/div/button"));
//    1.6 Verify the message “Product has been added to your cart” display in  green bar
        verifyText("text is verified", "Product has been added to your cart", By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
//    1.7 Click on X sign to close the message
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='page']/div[1]/div/div/a"));
//    1.8 Click on “Your cart” icon and Click on “View cart” button
        mouseHoverAndClick(By.xpath("//div[@class='header-right-bar']/div[4]"));
        clickOnElement(By.xpath("//div[@class='internal-popup items-list full-cart']/div/a[1]"));
//    1.9 Verify the text “Your shopping cart - 1 item”
        //verifyTextWithAssert("Your shopping cart - 1 item",By.linkText("Your shopping cart - 1 item"),"text is verified");
//    1.10 Verify the Subtotal $99.00
        Thread.sleep(3000);
        verifyText("price is verified", "Subtotal: $9.99", By.xpath("//ul[@class='sums']/li"));
//    1.11 Verify the total $106.23
        Thread.sleep(2000);
        verifyText("price is verified", "$12.59", By.xpath("//ul[@class='totals']/li[4]/span"));
//    1.12 Click on “Go to checkout” button
        clickOnElement(By.xpath("//ul[@class='totals']/li[5]"));
//    1.13 Verify the text “Log in to your account”
        Thread.sleep(1000);
        verifyText("text is verified", "Log in to your account", By.xpath("//div[@class='signin-wrapper']/div[1]/div[1]/h3"));
//    1.14 Enter Email address
        sendTextToElement(By.xpath("//input[@id='email']"), "npatel@gmail.com");

//    1.15 Click on “Continue” Button
        clickOnElement(By.xpath("//tbody/tr[2]/td[1]/button[1]"));
//    1.16 Verify the text “Secure Checkout”
        verifyText("text is verified", "Secure Checkout", By.xpath("//div[@class='checkout-block']/h1"));
//    1.17 Fill all the mandatory fields
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "nnnn");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "patel");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "lapata street");
        //sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"),"Los Angeles");
        clickOnElement(By.xpath("//input[@id='shippingaddress-city']"));
        selectByValueFromDropdown(By.xpath("//select[@id='shippingaddress-country-code']"), "US");
        clickOnElement(By.xpath("//div[@class='table-value shippingaddress-state-id-value table-value-required']"));
        //selectByValueFromDropdown(By.xpath("//div[@class='table-value shippingaddress-state-id-value table-value-required']"),"562");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "90001");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-phone']"), "+15550000000");
        clickOnElement(By.xpath("//input[@id='email']"));
//    1.18 Check the check box “Create an account for later use”
        clickOnElement(By.xpath("//input[@id='create_profile']"));
//    1.19 Enter the password
        sendTextToElement(By.xpath("//input[@id='password']"), "np1234567");
//    1.20 Select the Delivery Method to “Local Shipping”
        clickOnElement(By.xpath("//ul[@class=\"shipping-rates\"]/li[2]/div/label/input"));
//    1.21 Select Payment Method “COD”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//ul[@class=\"payments\"]/li[6]/div/label/input"));
//    1.22 Verify the total $99.00
        verifyText("text is verified", "$13.61", By.xpath("//div[@class='total clearfix']/span/span"));
//    1.23 Click on “Place Order” Button
        clickOnElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/button[1]"));
//    1.24 Verify the text “Thank you for your order”
        verifyText("text is verified", "Thank you for your order", By.xpath("//h1[@id='page-title']"));
    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
//    1.1 Mouse hover on the “Hot deals” link
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]"));
//    1.2 Mouse hover on the “Bestseller”  link and click
        mouseHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul/li[2]/a"));
//    1.3 Verify the text “Bestsellers”
        Thread.sleep(2000);
        verifyText("text is verified", "Bestsellers", By.xpath("//h1[@id='page-title']"));
//    1.4 Mouse hover on “Sort By” and ”
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        //select “Name A-Z
        mouseHoverAndClick(By.xpath("//ul[@class='display-sort sort-crit grid-list']/li[4]/a"));
//    1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//div[@class='product productid-13 ']"));
        mouseHoverAndClick(By.xpath("//ul[@class='products-grid grid-list']/li[8]/div/div[2]/div[4]/div/button"));
        Thread.sleep(2000);
//    1.6 Verify the message “Product has been added to your cart” display in  green bar
        Thread.sleep(2000);
        verifyText("text is verified", "Product has been added to your cart", By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
//    1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//div[@id='page']/div[1]/div/div/a"));
//    1.8 Click on “Your cart” icon and Click on “View cart” button
        mouseHoverAndClick(By.xpath("//div[@class='header-right-bar']/div[4]"));
        clickOnElement(By.xpath("//div[@class='internal-popup items-list full-cart']/div/a[1]"));
//    1.9 Verify the text “Your shopping cart - 1 item”
        //verifyTextWithAssert("Your shopping cart - 1 item",By.linkText("Your shopping cart - 1 item"),"text is verified");
//    1.10 Click on “Empty your cart” link
        clickOnElement(By.xpath("//div[@class='cart-buttons']/form/a"));
//    1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        Alert alert = driver.switchTo().alert();//---->creating alert object refrence and switch to alert
        String actualTextMsg = alert.getText();
        Assert.assertEquals("Are you sure you want to clear your cart?", actualTextMsg);
//    1.12 Click “Ok” on alert
        acceptAlert();
//    1.13 Verify the message “Item(s) deleted from your cart”
        //verifyTextWithAssert("Item(s) deleted from your cart",By.xpath("//div[@id='status-messages']/a"),"text is verified");
//    1.15 Verify the text “Your cart is empty”
//verifyTextWithAssert("Your cart is empty",By.xpath("//h1[@id='page-title']"),"text is verified");
    }

    @After
    public void closeBrowserShopping() {
        closeBrowser();
    }
}
