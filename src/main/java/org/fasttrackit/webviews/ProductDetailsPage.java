package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage {

    @FindBy(name = "pink")
    private WebElement pinkcolorbutton;

    public WebElement getPinkcolorbutton() {
        return pinkcolorbutton;
    }

    @FindBy(name = "s")
    private WebElement smallsizebutton;

    public WebElement getSmallsizebutton() {
        return smallsizebutton;
    }

    @FindBy(css = ".product-options-bottom .btn-cart")
    private WebElement getAddtoocart;

    public WebElement getGetAddtoocart() {
        return getAddtoocart;
    }


}


