package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage {
    @FindBy (css = ".category-title h1")
    private WebElement title;

    public WebElement getTitle() {
        return title;
    }
}
