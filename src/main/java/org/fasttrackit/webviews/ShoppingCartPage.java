package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}

