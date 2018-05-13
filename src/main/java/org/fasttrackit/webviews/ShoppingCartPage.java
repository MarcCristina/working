package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {

    @FindBy(xpath = "//table [@id='shopping-cart-table']//dl[@class='item-options']//dd[preceding-sibling::dt[text()='Color']]")
    private WebElement productcolor;

    public WebElement getProductcolor() {
        return productcolor;
    }

    @FindBy(xpath = "//table [@id='shopping-cart-table']//dl[@class='item-options']//dd[preceding-sibling::dt[text()='Size']]")
    private WebElement productsize;

    public WebElement getProductsize() {
        return productsize;
    }

    @FindBy(id = "country")
    private WebElement countrySelectList;

    public Select getCountrySelectList() {
        return new Select(countrySelectList);
    }

    @FindBy(id = "region_id")
    private WebElement regionSelectList;

    public Select getRegionSelectList() {
        return new Select(regionSelectList);
    }

    @FindBy(id = "city")
    private WebElement cityField;

    public WebElement getCityField() {
        return cityField;
    }

    @FindBy(id = "postcode")
    private WebElement cityCode;

    public WebElement getCityCode() {
        return cityCode;
    }

    @FindBy(className = "btn-proceed-checkout")
    private WebElement proceedCheckout;

    public WebElement getProceedCheckout() {
        return proceedCheckout;
    }

    @FindBy(id = "onepage-guest-register-button")
    private WebElement checkoutMethodContinuingButton;

    public WebElement getCheckoutMethodContinuingButton() {
        return checkoutMethodContinuingButton;
    }
}






