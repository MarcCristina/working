package org.fasttrackit.category;

import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.CategoryPage;
import org.junit.Test;

public class CategoryTest extends TestBase {

    private CategoryPage categorypage = initElements(CategoryPage.class);

    @Test
    public void categoryTitleTest(){
        // am deschis new aeeivals category page
        categorypage.getTitle().getText()

    }

}

