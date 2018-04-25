package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage {
    @FindBy (css = ".category-title h1")
    private WebElement title;

    @FindBy (css = ".category-image img")
    private WebElement banner;

    public WebElement getBanner() {
        return banner;
    }

    public WebElement getTitle() {
        return title;
    }
}

