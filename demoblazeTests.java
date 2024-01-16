package Demoblaze.com;

import Lesson08.TestListeners;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import static Demoblaze.com.CartPage.generateRandomString;

public class demoblazeTests {
    WebDriver driver;
    HomePage homePage;
    CartPage cartPage;
    String[] expectedPhonesList = {
            "Samsung galaxy s6",
            "Nokia lumia 1520",
            "Nexus 6",
            "Samsung galaxy s7",
            "Iphone 6 32gb",
            "Sony xperia z5",
            "HTC One M9"};
    String[] expectedLaptopsList = {
            "Sony vaio i5",
            "Sony vaio i7",
            "MacBook air",
            "Dell i7 8gb",
            "2017 Dell 15.6 Inch",
            "MacBook Pro"};
    String[] expectedMonitorsList = {
            "Apple monitor 24",
            "ASUS Full HD"};
    String expectedHomePageUrl = "https://www.demoblaze.com/index.html";
    String expectedCartPageUrl = "https://www.demoblaze.com/cart.html";
    String expectedContactTitle = "New message";
    String expectedAboutUsTitle = "About us";
    String expectedLogInTitle = "Log in";
    String expectedSignUpTitle = "Sign up";
    String expectedConfirmOrderTitle = "Thank you for your purchase!";

    //Contact - New Message 01
    String email01 = "sd.Lon@gm.com";
    String contactName01 = "Dima Yantsen";
    String message01 = "Hello! Where is my order?";

    //Place Order Details - Random
    //If you want to click on product names choose "productNames"
    String clickingMethod = "image"; //"productNames"
    int nameLength = 10;
    int countryLength = 10;
    int cityLength = 10;
    int creditCardLength = 10;
    int monthLength = 10;
    int yearLength = 10;
    String nameRandom = generateRandomString(nameLength);
    String countryRandom = generateRandomString(countryLength);
    String cityRandom = generateRandomString(cityLength);
    String creditCardRandom = generateRandomString(creditCardLength);
    String monthRandom = generateRandomString(monthLength);
    String yearRandom = generateRandomString(yearLength);


    @BeforeClass
    public void startSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com");
        homePage = PageFactory.initElements(driver, HomePage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
    }

    @AfterClass
    public void closeSession() {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test(description = "Verify the list of phones")
    @Description("Verifying the list of phones")
    public void test01VerifyPhonesList() {

        homePage.clickOnCategoryOpt(homePage.chooseCategoryItem("Phones"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        homePage.areProductsFilteredValid(expectedPhonesList);
    }

    @Test(description = "Verify the list of laptops")
    @Description("Checking the list of laptops")
    public void test02VerifyLaptopsList() {

        homePage.clickOnCategoryOpt(homePage.chooseCategoryItem("Laptops"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        homePage.areProductsFilteredValid(expectedLaptopsList);
    }

    @Test(description = "Verify the list of monitors")
    @Description("Checking the list of monitors")
    public void test03VerifyMonitorsList() {

        homePage.clickOnCategoryOpt(homePage.chooseCategoryItem("Monitors"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        homePage.areProductsFilteredValid(expectedMonitorsList);
    }

    @Test(description = "Click on Home button")
    @Description("Verify clicking on Home button reaches home page")
    public void test04VerifyHomeBtn() {
        homePage.clickOnHeaderOpt(homePage.chooseHeaderOpt("Home"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertEquals(expectedHomePageUrl, driver.getCurrentUrl());
    }

    @Test(description = "Click on Contact button")
    @Description("Verify clicking on Contact button reaches contact page")
    public void test05VerifyContactBtn() {
        homePage.clickOnHeaderOpt(homePage.chooseHeaderOpt("Contact"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertEquals(expectedContactTitle, homePage.getContactTitleText());
        homePage.closeContactUs();
    }

    @Test(description = "Click on About us button")
    @Description("Verify clicking on About us button reaches About us page")
    public void test06VerifyAboutUsBtn() {
        homePage.clickOnHeaderOpt(homePage.chooseHeaderOpt("About us"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertEquals(expectedAboutUsTitle, homePage.getAboutUsTitleText());
        homePage.closeAboutUs();
    }

    @Test(description = "Click on Cart button")
    @Description("Verify clicking on Cart button reaches Cart page")
    public void test07VerifyCartBtn() {
        homePage.clickOnHeaderOpt(homePage.chooseHeaderOpt("Cart"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertEquals(expectedCartPageUrl, driver.getCurrentUrl());

    }

    @Test(description = "Click on Log in button")
    @Description("Verify clicking on Log in button reaches Log in page")
    public void test08VerifyLogInBtn() {
        homePage.clickOnHeaderOpt(homePage.chooseHeaderOpt("Log in"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertEquals(expectedLogInTitle, homePage.getLogInTitleText());
        homePage.closeLogIn();
    }

    @Test(description = "Click on Sign up button")
    @Description("Verify clicking on Sign up button reaches Sign up page")
    public void test09VerifySignUpBtn() {
        homePage.clickOnHeaderOpt(homePage.chooseHeaderOpt("Sign up"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertEquals(expectedSignUpTitle, homePage.getSignUpTitleText());
        homePage.closeSignUp();
    }

    @Test(description = "Fill in Contact Us new message")
    @Description("Verify filling Contact Us new message throw an alert")
    public void test10FillInContactUs() {

        homePage.clickOnHeaderOpt(homePage.chooseHeaderOpt("Contact"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertEquals(expectedContactTitle, homePage.getContactTitleText());
        homePage.enterEmail(email01);
        homePage.enterContactName(contactName01);
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        homePage.enterMessage(message01);
        homePage.sendMessage();
        Assert.assertTrue(homePage.isAlertPresented(driver));
    }

    @Test(description = "Purchasing products")
    @Description("E2E test of adding randomly selected products and purchasing")
    public void test11PurchaseRandomProduct() {
        homePage.clickOnHeaderOpt(homePage.chooseHeaderOpt("Home"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        homePage.chooseRandomProduct(clickingMethod);
        homePage.clickOnAddToCart();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        homePage.closeAlert(driver);
        homePage.clickOnHeaderOpt(homePage.chooseHeaderOpt("Cart"));
        cartPage.clickOnPlaceOrderBtn();
        cartPage.enterName(nameRandom);
        cartPage.enterCountry(countryRandom);
        cartPage.enterCity(cityRandom);
        cartPage.enterCreditCard(creditCardRandom);
        cartPage.enterMonth(monthRandom);
        cartPage.enterYear(yearRandom);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        String expectedTotalSum = cartPage.getExpectedTotalSum();
        cartPage.clickOnPurchaseBtn();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Assert.assertEquals(cartPage.actualConfirmTitleText(), expectedConfirmOrderTitle);
        Assert.assertEquals(cartPage.retrieveValuesFromOrderDetails("Amount"), expectedTotalSum);
        Assert.assertEquals(cartPage.retrieveValuesFromOrderDetails("Number"), creditCardRandom);
        Assert.assertEquals(cartPage.retrieveValuesFromOrderDetails("Name"), nameRandom);
        cartPage.clickOnOkBtn();
    }
}
