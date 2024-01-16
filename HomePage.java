package Demoblaze.com;

import io.qameta.allure.Step;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage {

    //Elements
    //Logo Button
    @FindBy(id = "nava")
    private WebElement logoBtnEle;

    //Header Buttons
    @FindBy(xpath = "//*[@id='navbarExample']/ul/*")
    private List<WebElement> headerItemsListEle;

    //Carousel Of Pictures
    @FindBy(xpath = "//*[@id=\"carouselExampleIndicators\"]/ol/li")
    private List<WebElement> carouselIndicatorEle;
    @FindBy(xpath = "//*[contains (@class,'carousel-control-prev-icon')]")
    private WebElement carouselPrevBtnEle;
    @FindBy(xpath = "//*[contains (@class,'carousel-control-next-icon')]")
    private WebElement carouselNextBtnEle;

    //Contact
    //Title
    @FindBy(xpath = "//h5 [text()=\"New message\"]")
    private WebElement newMessageTitleEle;
    //Form Boxes
    @FindBy(id = "recipient-email")
    private WebElement recipientEmailEle;
    @FindBy(id = "recipient-name")
    private WebElement recipientNameEle;
    @FindBy(id = "message-text")
    private WebElement messageTextEle;
    //Buttons
    @FindBy(xpath = "//button[text()=\"Send message\"]")
    private WebElement sendMessageBtnEle;
    @FindBy(xpath = "//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]")
    private WebElement closeContactUsBtnEle;
    @FindBy(xpath = "//*[@id=\"exampleModal\"]/div/div/div[1]/button")
    private WebElement closeContactUsXBtnEle;

    //About us
    //Title
    @FindBy(xpath = "//h5 [text()=\"About us\"]")
    private WebElement aboutUsTitleEle;
    //Buttons
    @FindBy(xpath = "//*[@id=\"videoModal\"]/div/div/div[3]/button")
    private WebElement closeAboutUsBtnEle;
    @FindBy(xpath = "//*[@id=\"videoModal\"]/div/div/div[1]/button/span")
    private WebElement closeAboutUsXBtnEle;

    //Log in
    //Title
    @FindBy(xpath = "//h5 [text()=\"Log in\"]")
    private WebElement logInTitleEle;
    //Buttons
    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[1]")
    private WebElement closeLogInBtnEle;

    //Sign up
    //Title
    @FindBy(xpath = "//h5 [text()=\"Sign up\"]")
    private WebElement signUpTitleEle;
    //Buttons
    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")
    private WebElement closeSignUpBtnEle;

    //Categories List
    @FindBy(xpath = "//*[@id=\"contcont\"]/div/div[1]/div/*")
    private List<WebElement> categoriesListEle;

    //Products List
    @FindBy(xpath = "//*[@id=\"tbodyid\"]//h4")
    private List<WebElement> productsListEle;

    //Clickable images of products
    @FindBy(xpath = "//*[@id=\"tbodyid\"]//a/img")
    private List<WebElement> productsListImageLinksEle;

    //Clickable names of products
    @FindBy(xpath = "//*[@id=\"tbodyid\"]//a/img")
    private List<WebElement> productsListNamesLinksEle;

    //Add to cart
    @FindBy(xpath = "//a[text()=\"Add to cart\"]")
    private WebElement addToCartBtnEle;


    //Methods
    //Logo Button
    @Step("Click on logo button")
    public void clickOnLogoButton() {
        logoBtnEle.click();
    }

    //Header Buttons
    @Step("Choose header option for clicking")
    public int chooseHeaderOpt(String headerItem) {
        switch (headerItem) {
            case "Home":
                return 0;

            case "Contact":
                return 1;

            case "About us":
                return 2;

            case "Cart":
                return 3;

            case "Log in":
                return 4;

            case "Log out":
                return 5;

            case "User name":
                return 6;

            case "Sign up":
                return 7;
        }
        return 0;
    }

    @Step("Click on header option")
    public void clickOnHeaderOpt(int opt) {
        headerItemsListEle.get(opt).click();
    }

    //Carousel of Pictures
    @Step("Click on picture indicator")
    public void chooseIndicator(int pictureNum) {
        carouselIndicatorEle.get(pictureNum).click();
    }

    @Step("Move carousel to next picture")
    public void chooseControlNextPicture() {
        carouselNextBtnEle.click();
    }

    @Step("Move carousel to previous picture")
    public void chooseControlPrevPicture() {
        carouselPrevBtnEle.click();
    }

    //Contact
    //Title
    @Step("Get Contact title text")
    public String getContactTitleText() {
        return newMessageTitleEle.getText();
    }

    //Enter information to form boxes:
    @Step("Enter contact email address")
    public void enterEmail(String emailName) {
        recipientEmailEle.sendKeys(emailName);
    }

    @Step("Enter contact name")
    public void enterContactName(String contactName) {
        recipientNameEle.sendKeys(contactName);
    }

    @Step("Enter message")
    public void enterMessage(String message) {
        messageTextEle.sendKeys(message);
    }

    //Buttons
    @Step("Send message")
    public void sendMessage() {
        sendMessageBtnEle.click();
    }

    @Step("Click close button")
    public void closeContactUs() {
        closeContactUsBtnEle.click();
    }

    @Step("Click X button")
    public void closeContactXBtnUs() {
        closeContactUsXBtnEle.click();
    }

    //Alert presence verification
    @Step("Verify alert presented")
    public boolean isAlertPresented(WebDriver driver) {
        try {
            driver.switchTo().alert().accept();
            return true;

        } catch (NoAlertPresentException e) {
            System.out.println("No alert present." + e.getMessage());
            throw e;
        }

    }

    //About us
    //Title
    @Step("Get About us title text")
    public String getAboutUsTitleText() {
        return aboutUsTitleEle.getText();
    }

    //Buttons
    @Step("Click close button")
    public void closeAboutUs() {
        closeAboutUsBtnEle.click();
    }

    //Log in
    //Title
    @Step("Get Log in title text")
    public String getLogInTitleText() {
        return logInTitleEle.getText();
    }

    //Buttons
    @Step("Click close button")
    public void closeLogIn() {
        closeLogInBtnEle.click();
    }

    //Sign up
    //Title
    @Step("Get Sign up title text")
    public String getSignUpTitleText() {
        return signUpTitleEle.getText();
    }

    //Buttons
    @Step("Click close button")
    public void closeSignUp() {
        closeSignUpBtnEle.click();
    }

    //Categories List
    @Step("Choose category option")
    public int chooseCategoryItem(String categoryItem) {

        switch (categoryItem) {
            case "Categories":
                return 0;

            case "Phones":
                return 1;

            case "Laptops":
                return 2;

            case "Monitors":
                return 3;
        }
        return 0;
    }

    @Step("Click on category option")
    public void clickOnCategoryOpt(int opt) {
        categoriesListEle.get(opt).click();
    }

    //Products List
    @Step("Retrieve products names from category")
    public List<String> productsNamesListByCategory() {
        List<String> productsNames = new ArrayList<>();
        for (WebElement element : productsListEle) {
            productsNames.add(element.getText());
        }
        return productsNames;
    }

    //Checking the specific products are presented after category was chosen
    @Step("Check the product list filtered valid")
    public void areProductsFilteredValid(String[] expectedList) {
        List<String> actualPhonesList = productsNamesListByCategory();
        int i = 0;
        for (String phone : actualPhonesList) {
            Assert.assertEquals(expectedList[i++].trim(), phone.trim());
        }

    }

    //Retrieve list of all presented products on home page
    @Step("Presented products on visible page")
    public List<WebElement> presentedProductsEleList(String clickingMethod) {
        List<WebElement> listOfProducts = new ArrayList<>();
        if (clickingMethod.equals("image")) {
            listOfProducts.addAll(productsListImageLinksEle);
        } else if (clickingMethod.equals("productNames")) {
            listOfProducts.addAll(productsListNamesLinksEle);
        }
        return listOfProducts;
    }

    //Select number randomly up to maximum number of possible products
    @Step("Randomly selected number")
    public int randomlySelectedNumber(int numBoundaries) {
        Random random = new Random();
        return random.nextInt(numBoundaries - 1);
    }

    //Choose product by clicking differently (by product picture or by product name)
    @Step("Choose product randomly")
    public void chooseRandomProduct(String clickingMethod) {
        presentedProductsEleList(clickingMethod).get(randomlySelectedNumber(presentedProductsEleList(clickingMethod).size())).click();
    }

    //Add to cart
    @Step("Add to cart")
    public void clickOnAddToCart() {
        addToCartBtnEle.click();
    }

    //Close alert
    @Step("Close alert")
    public void closeAlert(WebDriver driver) {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present." + e.getMessage());
            throw e;
        }
    }
}
