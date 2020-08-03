package com.google.citrus;

import com.google.citrus.catalogue.CatalogueStory;
import com.google.citrus.login.LoginStory;
import com.google.citrus.search.SearchStory;
import com.google.citrus.wrapperPopup.WrapperStory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Shop extends WebSettings {

    String testURL = "https://www.citrus.ua/uk/"; // simply paste any URL you would like to test

    @BeforeMethod
    public void start() {

        driverD.get(testURL);

        WrapperStory wrapper = new WrapperStory(driverD);
        wrapper.wrapperClose();
    }

    @Test
    public void login() {
        // login
        LoginStory loginStory = new LoginStory(driverD);
        loginStory.login("456799");
    }

    @Test
    public void search() {
        //search and filter search results
        String category = "Смартфоны";
        String searchRequest = "Xiaomi";

        SearchStory searchStory = new SearchStory(driverD);

        searchStory.search(searchRequest, category);
    }

    @Test
    public void catalogue() {
        String category = "Смартфони";
        String brand = "Xiaomi";

        /*
        CatalogueStory catalogue = new CatalogueStory(driverD);
        // through Catalogue navigate to a specific Brand Category page
        catalogue.navigate(category, brand);
        // sort items by price
        catalogue.sortByHighestPrice(catalogue.getCatalogue());
        // adding goods to basket
        catalogue.addingNumberOfItemsToCart(2);
        // complete purchase
        catalogue.completePurchase();
        */

        CatalogueStory cata = new CatalogueStory(driverD);
        cata.navigate(category, brand);
        cata.findItemsWithHighestPrices(2, brand);

    }
    /*
        // sort items by price
        WebElement priceSorting = driver.click("//ul[@class = 'sort__items']/li[3]");
        priceSorting.click();
        wait.until(ExpectedConditions.attributeContains(priceSorting, "class", "item active"));

        // pick 2 most expensive
        WebElement firstGood = driver.click("//ul[@class = 'sort__items']/li[2]");
        wait.until(ExpectedConditions.elementToBeClickable(firstGood));

        driver.click("//div[@class= 'product-card product-card--mini'][1]/div/div[3]/div/button[1]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class= 'btn orange full ctrs-basket-footer__order-purchase']")));
        driver.click("//div[@class= 'el-dialog el-dialog--medium']/div/button[2]").click();

        driver.click("//div[@class= 'product-card product-card--mini'][2]/div/div[3]/div/button[1]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class= 'btn orange full ctrs-basket-footer__order-purchase']")));
        driver.click("//a[@class= 'btn orange full ctrs-basket-footer__order-purchase']").click();
        System.out.println("Purchases are done");

    }

*/

}
