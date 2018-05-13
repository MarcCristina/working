package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css = ".add-to-cart .btn-cart")
    private WebElement getAddtoocart;

    public WebElement getGetAddtoocart() {
        return getAddtoocart;
    }

    @FindBy(className = "qty")
    private List<WebElement> quantityfield;

    public List<WebElement> getQuantityfield() {
        return quantityfield;
    }



}



