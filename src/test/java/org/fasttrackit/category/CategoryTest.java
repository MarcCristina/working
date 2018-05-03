package org.fasttrackit.category;

import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.CategoryPage;
import org.fasttrackit.webviews.ProductDetailsPage;
import org.fasttrackit.webviews.ShoppingCartPage;
import org.junit.Test;
import org.openqa.selenium.By;

import javax.swing.text.html.ListView;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;

public class CategoryTest extends TestBase {


    @Test
    public void categoryTitleTest() {
        By womenMenu = By.linkText("WOMEN");
        By newArrivals = By.linkText("New Arrivals");
        List<By> meniu = Arrays.asList(womenMenu, newArrivals);

        mouseOverAndClickLast(meniu);

        CategoryPage categorypage = initElements(CategoryPage.class);

        String title = categorypage.getTitle().getText();

        assertThat("Page title isn't correct", title, is("NEW ARRIVALS"));
    }


    @Test
    public void bannerDispayedTest() {
        By womenMenu = By.linkText("WOMEN");
        By newArrivals = By.linkText("New Arrivals");
        List<By> meniu = Arrays.asList(womenMenu, newArrivals);

        mouseOverAndClickLast(meniu);

        CategoryPage categoryPage = initElements(CategoryPage.class);

        assertThat("Banner wasn't displayed", categoryPage.getBanner().isDisplayed());


    }

    @Test
    public void shoesSubcategoryPresentsTest() {
        By accessoriesMenu = By.linkText("ACCESSORIES");
        List<By> meniu = Arrays.asList(accessoriesMenu);

        mouseOver(meniu);

        assertThat("Shoes subcategory not presents", driver.findElement(By.linkText("Shoes")).isDisplayed());

    }

    @Test
    public void resultsPerPageTest() {
        By womenMenu = By.linkText("WOMEN");
        By newArrivals = By.linkText("New Arrivals");
        List<By> meniu = Arrays.asList(womenMenu, newArrivals);

        mouseOverAndClickLast(meniu);

        CategoryPage categoryPage = initElements(CategoryPage.class);

        categoryPage.getResultsperpageSelectPage().selectByVisibleText("12");
        int productscount = categoryPage.getProductnames().size();

        assertThat("Results number isn't real", productscount, is(lessThanOrEqualTo(12)));

    }

    @Test
    public void itemsPageTest() {
        By womenMenu = By.linkText("WOMEN");
        By newArrivals = By.linkText("New Arrivals");
        List<By> meniu = Arrays.asList(womenMenu, newArrivals);

        mouseOverAndClickLast(meniu);

        CategoryPage categoryPage = initElements(CategoryPage.class);
        String itemscountastext = categoryPage.getItemsPageTest().getText();
        String counts = itemscountastext.split(" ")[0];
        int itemsnumber = Integer.parseInt(counts);
        int productnames = categoryPage.getProductnames().size();
        assertThat("Numbers are not equals", productnames, is(itemsnumber));

    }

    @Test
    public void contentDisplayingasListTest() {
        By womenMenu = By.linkText("WOMEN");
        By newArrivals = By.linkText("New Arrivals");
        List<By> meniu = Arrays.asList(womenMenu, newArrivals);

        mouseOverAndClickLast(meniu);

        CategoryPage categoryPage = initElements(CategoryPage.class);
        categoryPage.getListview().click();
        assertThat("Products not display in list", categoryPage.getProductslist().isDisplayed());
    }

    @Test
    public void addProductsWithSpecificSizesAndColorsToCart() {

        By womenCategoryLocator = By.xpath("//a[text() = 'Women']");
        By newArrivalsSubCategoryLocator = By.xpath("//a[text() = 'New Arrivals']");

        mouseOverAndClickLast(Arrays.asList(womenCategoryLocator, newArrivalsSubCategoryLocator));

        CategoryPage categoryPage = initElements(CategoryPage.class);

        categoryPage.getViewdetailsbutton().click();

        ProductDetailsPage productDetailsPage = initElements(ProductDetailsPage.class);

        productDetailsPage.getPinkcolorbutton().click();

        productDetailsPage.getSmallsizebutton().click();

        productDetailsPage.getGetAddtoocart().click();

        ShoppingCartPage shoppingCartPage = initElements(ShoppingCartPage.class);
        String productColor = shoppingCartPage.getProductcolor().getText();
        String productSize = shoppingCartPage.getProductsize().getText();

        assertThat("Product color is different than the one added to cart", productColor.trim(), is("Pink"));
        assertThat("Product size is different than the one added to cart", productSize.trim(), is("S"));
    }


    @Test
    public void addProductsWithLimitedQuantityAndPrice(){



    }
}




