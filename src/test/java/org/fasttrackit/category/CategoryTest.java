package org.fasttrackit.category;

import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.CategoryPage;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CategoryTest extends TestBase {


    @Test
    public void categoryTitleTest(){
        By womenMenu = By.linkText("WOMEN");
        By newArrivals = By.linkText("New Arrivals");
        List <By> meniu = Arrays.asList(womenMenu,newArrivals);

        mouseOverAndClickLast(meniu);

        CategoryPage categorypage = initElements(CategoryPage.class);

        String title = categorypage.getTitle().getText();

        assertThat("Page title isn't correct", title, is("NEW ARRIVALS"));


    }

}

