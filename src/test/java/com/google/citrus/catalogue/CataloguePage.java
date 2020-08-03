package com.google.citrus.catalogue;

import com.google.citrus.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class CataloguePage {
    private WebDriver driverD;

    private final String CATALOGUELINK = "//div[@class='menu--desktop__title']";
    private final String GOODCATEGORYLINK = "//a[@title='%s']";
    private final String GOODCATEGORYPAGESORTING = "//p[text()='Сортування:']";
    private final String BRAND = "//span/a[text()='%s']";
    private final String BRANDFILTERINGRESULTS = "//b[text()='Бренд:']";
    private final String HIGHESTPRICESORTINGLINK = "//ul[@class='sort__items']/li[3]";
    private final String WEBATTRIBUTE = "class";
    private final String SORTINGEXPECTEDVALUE = "item active";
    private final String CARTBUTTON = "//div[@class='product-card product-card--mini'][%s]/div/div[3]/div/button[1]";
    private final String ORDERCONFIRMATIONBUTTON = "//a[@class='btn orange full ctrs-basket-footer__order-purchase']";
    private final String ORDERCLOSEBUTTON = "//button[@aria-label='Close'][2]";
    private final String CART = "//i[@class = 'icon-new-citrus-cart']";
    private final String COMPLETEORDER = "//a/span[text()='Оформити замовлення']";
    private final String NUMBEROFITEMSINCATEGORYBRANDFILTER = "//span[contains(@class, 'el-checkbox__label') and a[text()='%s']]/span";
    private final String ITEMCARTXPATH = "//div[@class='product-card product-card--mini'][%s]/div/div[3]/div/button[1]";
    private final String ITEMPRICEXPATH = "//div[@class='product-card product-card--mini'][%s]/div/div[2]/div[3]/div[@class='prices__price']/span[1]";
    private final String PRODUCTCARDCARTTITLEXPATH = "//div[@class='product-card product-card--mini'][%s]/div/div[3]/div/button[1]/span[2]";

    public CataloguePage(WebDriver driverD) {
        this.driverD = driverD;
    }

    public int numberOfItemsInCategoryBrandFilter(String brand) {
        int numberOfItems;
        String brandXpath = String.format(NUMBEROFITEMSINCATEGORYBRANDFILTER, brand);
        String number;
        number = driverD.getText(brandXpath);
        numberOfItems = Integer.parseInt(number.substring(1, number.length() - 1));

        return numberOfItems;
    }

    public CataloguePage openGoodCategoryPage(String goodCategory) {
        driverD.click(CATALOGUELINK);
        driverD.waitUntil(20, String.format(GOODCATEGORYLINK, goodCategory));
        driverD.click(String.format(GOODCATEGORYLINK, goodCategory));

        return  this;
    }

    public CataloguePage filterGoodCategoryPageByBrand(String brand) {
        driverD.waitUntil(20, GOODCATEGORYPAGESORTING);
        driverD.click(String.format(BRAND, brand));
        driverD.waitUntil(20, BRANDFILTERINGRESULTS);

        return this;
    }

    public CataloguePage sortItemsByHighestPrice() {
        driverD.click(HIGHESTPRICESORTINGLINK);
        driverD.waitUntilAttributeContains(HIGHESTPRICESORTINGLINK, WEBATTRIBUTE, SORTINGEXPECTEDVALUE);

        return this;
    }

    public CataloguePage addNumberOfItemsToCart(int numberOfGoods) {
        for(int i = 1; i <= numberOfGoods; i++) {
            driverD.click(String.format(CARTBUTTON, i));
            driverD.waitUntil(40, ORDERCONFIRMATIONBUTTON);
            driverD.click(ORDERCLOSEBUTTON);
            driverD.waitUntil(20, String.format(CARTBUTTON, i));
        }

        return this;
    }

    public CataloguePage purchase() {
        driverD.waitUntil(25, CART);
        driverD.click(CART);

        driverD.waitUntil(25, COMPLETEORDER);
        driverD.click(COMPLETEORDER);

        return this;
    }

    public List<Good> goodsWithHighestPricesByBrand(int numberOfGoods, String brand) {
        List<Good> goods = new ArrayList<>();

        int generalNumberOfGoods = numberOfItemsInCategoryBrandFilter(brand);

        System.out.println(generalNumberOfGoods);
        String price;

        for (int i = 1; i <= generalNumberOfGoods; i++) {
            driverD.waitUntil(25, String.format(ITEMPRICEXPATH, i));

            if (driverD.find(String.format(PRODUCTCARDCARTTITLEXPATH, i)) != 0) {
                price = driverD.getText(String.format(ITEMPRICEXPATH, i));
                price = price.replaceAll("\\s+", "");
                Good good = new Good(Integer.toString(i), Integer.parseInt(price));
                goods.add(good);
            } else {
                System.out.println("No Cart");
            }
        }
        goods = Good.goodsWithHighestPrices(goods, numberOfGoods);
        for (Good g : goods) {
            System.out.println(g.name + "; " + g.price);
        }
        return goods;
    }

    public CataloguePage addItemsToCart(List<Good> goods) {
        goods.toArray();
        for (int i = 0; i < goods.size(); i++) {
            driverD.click(String.format(ITEMCARTXPATH, goods.get(i).name));
            driverD.waitUntil(40, ORDERCONFIRMATIONBUTTON);

            driverD.click(ORDERCLOSEBUTTON);
            driverD.waitUntil(20, String.format(ITEMCARTXPATH, goods.get(i).name));
        }

        return this;
    }
}
