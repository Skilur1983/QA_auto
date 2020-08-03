package com.google.citrus.catalogue;

import com.google.citrus.WebDriver;

public class CatalogueStory {

    private WebDriver driver;
    CataloguePage catalogue;

    public CatalogueStory(WebDriver driver) {
        this.driver = driver;
        catalogue = new CataloguePage(driver);
    }

    public CataloguePage getCatalogue() {
        return catalogue;
    }

    public CatalogueStory navigate(String goodCategory, String brand) {
        catalogue.openGoodCategoryPage(goodCategory)
                 .filterGoodCategoryPageByBrand(brand);

        return this;
    }

    public CatalogueStory sortByHighestPrice(CataloguePage catalogue) {
        catalogue.sortItemsByHighestPrice();

        return this;
    }

    public CatalogueStory addingNumberOfItemsToCart(int numberOfGoods) {
        catalogue.addNumberOfItemsToCart(numberOfGoods);

        return this;
    }

    public CatalogueStory completePurchase() {
        catalogue.purchase();

        return this;
    }

    public CatalogueStory findItemsWithHighestPrices(int numberOfGoods, String brand) {
        catalogue.addItemsToCart(catalogue.goodsWithHighestPricesByBrand(numberOfGoods, brand));

        return this;
    }
}
