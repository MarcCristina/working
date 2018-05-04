package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(id = "search")
    private WebElement searchField;

    public WebElement getSearchField() {
        return searchField;
    }

    @FindBy (css = ".header-minicart .skip-cart")
    private WebElement miniCartButton;

    public WebElement getMiniCartButton() {
        return miniCartButton;
    }

    @FindBy (className = "empty")
    private WebElement emptyMiniCartMessage;

    public WebElement getEmptyMiniCartMessage() {
        return emptyMiniCartMessage;
    }

    @FindBy (css = ".minicart-wrapper .product-name")
    private WebElement productNameMiniCart;

    public WebElement getProductNameMiniCart() {
        return productNameMiniCart;
    }
}
