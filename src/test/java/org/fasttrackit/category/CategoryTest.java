package org.fasttrackit.category;

import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
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
    public void addProduct() {
        Header header = initElements(Header.class);
        header.getSearchField().sendKeys("vase" + Keys.ENTER);

        CategoryPage categoryPage = initElements(CategoryPage.class);
        categoryPage.getViewdetailsbutton().click();

        ProductDetailsPage productDetailsPage = initElements(ProductDetailsPage.class);
        for (WebElement quantityfield : productDetailsPage.getQuantityfield()) {
            quantityfield.sendKeys("1");
        }
        productDetailsPage.getGetAddtoocart().click();


        assertThat("Products are not in cart", getSuccesedmessageContainer().isDisplayed());
        assertThat("Unespected success message", getSuccesedmessageContainer().getText(), containsString("was added to your shopping cart"));

    }

    @Test
    public void emptyMiniCart() {
        Header header = initElements(Header.class);
        header.getMiniCartButton().click();

        assertThat("Not products into the cart", header.getEmptyMiniCartMessage().isDisplayed());
        assertThat("Unespected message displayed", header.getEmptyMiniCartMessage().getText(), is("You have no items in your shopping cart."));

    }

    @Test
    public void productDisplayedinMiniCartTest() throws InterruptedException {
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

        Header header = initElements(Header.class);
        header.getMiniCartButton().click();
        Thread.sleep(1000);

        assertThat("Empty cart", header.getProductNameMiniCart().isDisplayed());

        assertThat("Unespected product name are displayed", header.getProductNameMiniCart().getText(), is("ELIZABETH KNIT TOP"));

    }

    @Test
    public void succesufullyBuyProduct() throws InterruptedException {


        By accessoriesCategoryLocator = By.xpath("//a[text()='Accessories']");
        By jewelryCategoryLocator = By.cssSelector(" ul > li.level1.nav-3-2 > a");

        mouseOverAndClickLast(Arrays.asList(accessoriesCategoryLocator, jewelryCategoryLocator));
        CategoryPage categoryPage = initElements(CategoryPage.class);

        categoryPage.getGetAddtoocart().click();
        waitForPageToLoad(3000);

        assertThat("Products are not in cart", getSuccesedmessageContainer().isDisplayed());
        assertThat("Unespected success message", getSuccesedmessageContainer().getText(), containsString("was added to your shopping cart"));

        ShoppingCartPage shoppingCartPage = initElements(ShoppingCartPage.class);
        shoppingCartPage.getCountrySelectList().selectByVisibleText("România");

        shoppingCartPage.getRegionSelectList().selectByVisibleText("Cluj");
        shoppingCartPage.getCityField().sendKeys("Cluj-Napoca");
        shoppingCartPage.getCityCode().sendKeys("400290");
        shoppingCartPage.getProceedCheckout().click();
        shoppingCartPage.getCheckoutMethodContinuingButton().click();

        BillingInformationPage billingInformationPage = fillInBillingInformation();
        billingInformationPage.getExpeditedShippingMethod().click();
        Thread.sleep(1000);
        billingInformationPage.getContinueButtonfromShippingMethod().click();
        Thread.sleep(1000);
        billingInformationPage.getContinueButtonfromPaymentInformation().click();
        billingInformationPage.getPlaceOrderButton().click();
        Thread.sleep(5000);
        assertThat("Confirmation message was not displayed", getpageTitleContainer().getText(), is("YOUR ORDER HAS BEEN RECEIVED."));
    }

    private BillingInformationPage fillInBillingInformation() {
        BillingInformationPage billingInformationPage = initElements(BillingInformationPage.class);
        billingInformationPage.getFirstNameField().sendKeys("Cristina");
        billingInformationPage.getMiddleNameField().sendKeys("Ramona");
        billingInformationPage.getLastNameField().sendKeys("Marc");
        billingInformationPage.getCompanyField().sendKeys("AmbitTech");
        billingInformationPage.getEmailField().sendKeys("crys_20062006@yahoo.com");
        billingInformationPage.getStreetField().sendKeys("Donath 23");
        billingInformationPage.getGetStreetField2().sendKeys("Donath 23");
        billingInformationPage.getCountryField().sendKeys("România");
        billingInformationPage.getStateSelectList().selectByVisibleText("Cluj");
        billingInformationPage.getCityField().sendKeys("Cluj-Napoca");
        billingInformationPage.getPostCodeField().sendKeys("400290");
        billingInformationPage.getTelephoneField().sendKeys("0754622407");
        billingInformationPage.getFaxField().sendKeys("0364622407");
        billingInformationPage.getContinueButton().click();
        return billingInformationPage;


    }
}





