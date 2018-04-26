package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CategoryPage {
    @FindBy(css = ".category-title h1")
    private WebElement title;

    @FindBy(css = ".category-image img")
    private WebElement banner;

    @FindBy(css = "select[title= 'Results per page']")
    private WebElement resultsperpageSelectPage;

    @FindBy(css = ".product-name")
    private List<WebElement> productnames;

    @FindBy(css = ".amount strong")
    private WebElement itemsPageTest;

    public WebElement getItemsPageTest() {
        return itemsPageTest;

    }

    public List<WebElement> getProductnames() {
        return productnames;
    }

    public Select getResultsperpageSelectPage() {
        return new Select(resultsperpageSelectPage);
    }


    public WebElement getBanner() {
        return banner;
    }

    public WebElement getTitle() {
        return title;
    }

}


