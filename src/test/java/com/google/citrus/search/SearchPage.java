package com.google.citrus.search;

import com.google.citrus.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driverD;

    private final String FORMLINK = "//div/a[@class='link-to']";
    private final String SEARCHFIELD = "search";
    private final String SEARCHBUTTON = "//button[contains(@class,'global-search__submit')]";
    private final String SEARCHRESULTS = "//p[@class='result__total-found']";

    private final String SEARCHCATEGORYNAME = "//a[text()='%s']";
    private final String SEARCHCATEGORYNUMBER = "//span[contains(@class, 'el-checkbox__label') and a[text()='Смартфоны']]/span/span";
    private final String SEACHCATEGORYRESULTSNUMBER = "//p[contains(text(), ' Знайдено товарів: ')]";

    public SearchPage(WebDriver driverD) {
        this.driverD = driverD;
    }

    public SearchPage search(String request) {
        driverD.waitUntil(50, FORMLINK);
        driverD.sendKeysByName(SEARCHFIELD, request);
        driverD.click(SEARCHBUTTON);

        return this;
    }

    public SearchPage filterByCategory(String category) {
        driverD.waitUntil(50, SEARCHRESULTS);

        driverD.click(String.format(SEARCHCATEGORYNAME, category));

        String numberOfGoods = driverD.getText(SEARCHCATEGORYNUMBER);
        String itemsFound = "Знайдено товарів: ";

        driverD.waitUntilElementToTextEquivalent(SEACHCATEGORYRESULTSNUMBER, itemsFound+numberOfGoods);

        return this;
    }
}
