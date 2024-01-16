package Demoblaze.com;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Random;

public class CartPage {
    //Elements
    //Buttons
    @FindBy(xpath = "//button[text()=\"Place Order\"]")
    private WebElement placeOrderBtnEle;
    @FindBy(xpath = "//a[text()=\"Delete\"]")
    private WebElement deleteBtnEle;

    //Titles
    @FindBy(xpath = "//h2[text()=\"Products\"]")
    private WebElement productsTitleEle;
    @FindBy(xpath = "//h2[text()=\"Total\"]")
    private WebElement totalTitleEle;
    @FindBy(xpath = "//*[@id=\"totalm\"]")
    private static WebElement totalSumEle;

    //All visible products on the page
    @FindBy(id = "tbodyid")
    private WebElement productsTableEle;


    //Table Titles
    @FindBy(xpath = "//*[text()=\"Pic\"]")
    private WebElement picTableTitleEle;
    @FindBy(xpath = "//*[text()=\"Title\"]")
    private WebElement titleTableTitleEle;
    @FindBy(xpath = "//*[text()=\"Price\"]")
    private WebElement priceTableTitleEle;
    @FindBy(xpath = "//*[text()=\"x\"]")
    private WebElement xTableTitleEle;

    //Place Order Pop Up
    //Titles
    @FindBy(id = "orderModalLabel")
    private WebElement placeOrderTitleEle;
    @FindBy(id = "totalm")
    private WebElement totalSumTitleEle;

    //Place Order Pop Up
    //Form Boxes
    @FindBy(id = "name")
    private WebElement nameEle;
    @FindBy(id = "country")
    private WebElement countryEle;
    @FindBy(id = "city")
    private WebElement cityEle;
    @FindBy(id = "card")
    private WebElement creditCardEle;
    @FindBy(id = "month")
    private WebElement monthEle;
    @FindBy(id = "year")
    private WebElement yearEle;
    //Buttons
    @FindBy(xpath = "//*[text()=\"Purchase\"]")
    private WebElement purchaseBtnEle;
    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")
    private WebElement closePlaceOrderBtnEle;
    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[1]/button/span")
    private WebElement closePlaceOrderXBtnEle;
    //Confirmation Pop-up
    @FindBy(xpath = "//*[text()=\"Thank you for your purchase!\"]")
    private WebElement confirmOrderTitleEle;

    //Confirmation details of the order
    @FindBy(className = "lead")
    private WebElement confirmDetailsEle;

    //Buttons
    @FindBy(xpath = "//button[text()=\"OK\"]")
    private WebElement orderConfirmOkBtnEle;


    //Methods
    //Buttons
    @Step("Click on place order button")
    public void clickOnPlaceOrderBtn() {
        placeOrderBtnEle.click();
    }

    @Step("Click on delete button")
    public void clickOnDeleteBtn() {
        deleteBtnEle.click();
    }

    @Step("Click on purchase button")
    public void clickOnPurchaseBtn() {
        purchaseBtnEle.click();
    }

    //Enter information to form boxes:
    @Step("Enter name")
    public String enterName(String name) {
        nameEle.sendKeys(name);
        return name;
    }

    @Step("Enter country")
    public void enterCountry(String country) {
        countryEle.sendKeys(country);
    }

    @Step("Enter city")
    public void enterCity(String city) {
        cityEle.sendKeys(city);
    }

    @Step("Enter credit card")
    public String enterCreditCard(String creditCard) {
        creditCardEle.sendKeys(creditCard);
        return creditCard;
    }

    @Step("Enter month")
    public void enterMonth(String month) {
        monthEle.sendKeys(month);
    }

    @Step("Enter year")
    public void enterYear(String year) {
        yearEle.sendKeys(year);

    }

    //Title
    @Step("Get Confirmation Order title text")
    public String actualConfirmTitleText() {
        return confirmOrderTitleEle.getText();
    }

    @Step("Add to cart")
    public void clickOnOkBtn() {
        orderConfirmOkBtnEle.click();
    }

    //Generating random string
    @Step("Generate random string to fill into form boxes")
    public static String generateRandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder randomStringBuilder = new StringBuilder(length);

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);
            randomStringBuilder.append(randomChar);
        }

        return randomStringBuilder.toString();
    }
    //Order details retrieving from confirmation page
    @Step("Retrieve pairs of key:value from order details")
    public String retrieveValuesFromOrderDetails(String orderDetail) {

        String[] orderDetailsWords = confirmDetailsEle.getText().split("\\s+");

        HashMap<String, String> orderDetailsPairs = new HashMap<>();

        // Populate the HashMap with sample mappings
        orderDetailsPairs.put("Id:", orderDetailsWords[1]);
        orderDetailsPairs.put("Amount:", orderDetailsWords[3]);
        orderDetailsPairs.put("Number:", orderDetailsWords[7]);
        orderDetailsPairs.put("Name:", orderDetailsWords[9]);
        orderDetailsPairs.put("Date:", orderDetailsWords[11]);
        switch (orderDetail) {

            case "Id":
                return orderDetailsPairs.get("Id:");
            case "Amount":
                return orderDetailsPairs.get("Amount:");
            case "Number":
                return orderDetailsPairs.get("Number:");
            case "Name":
                return orderDetailsPairs.get("Name:");
            case "Date":
                return orderDetailsPairs.get("Date:");
            default:
                return "Error";
        }
    }
    //Expected total sum from Place order pop-up
    @Step("Get the total sum")
    public String getExpectedTotalSum() {
        String[] totalAmountWords = totalSumTitleEle.getText().split("\\s+");

        HashMap<String, String> totalSumPair = new HashMap<>();
        totalSumPair.put("Total:", totalAmountWords[1]);
        return totalSumPair.get("Total:");


    }

}


