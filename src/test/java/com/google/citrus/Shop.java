package com.google.citrus;

import com.google.citrus.catalogue.CatalogueStory;
import com.google.citrus.login.LoginStory;
import com.google.citrus.search.SearchStory;
import com.google.citrus.wrapperPopup.WrapperStory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Shop extends WebSettings {

    String testURL = "https://www.citrus.ua/uk/"; // simply paste any URL you would like to test
    String category = "Смартфони";
    String brand = "Xiaomi";
    CatalogueStory catalogue;

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
    public void purchaseGoodsWithHighestPricesAfterSorting() {

        catalogue = new CatalogueStory(driverD);
        // through Catalogue navigate to a specific Brand Category page
        catalogue.navigate(category, brand);
        // sort items by price
        catalogue.sortByHighestPrice(catalogue.getCatalogue());
        // adding goods to basket
        catalogue.addingNumberOfItemsToCart(2);
        // complete purchase
        catalogue.completePurchase();
    }

    @Test
    public void purchaseGoodsWithHighestPricesWithoutSorting() {

        catalogue = new CatalogueStory(driverD);
        catalogue.navigate(category, brand);
        catalogue.findItemsWithHighestPrices(2, brand);
        // complete purchase
        catalogue.completePurchase();
    }

}
