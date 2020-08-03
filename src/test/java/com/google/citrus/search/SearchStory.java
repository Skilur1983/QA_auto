package com.google.citrus.search;

import com.google.citrus.WebDriver;

public class SearchStory {
    private WebDriver driver;

    public SearchStory(WebDriver driver) {
            this.driver = driver;
    }

    public SearchStory search(String searchRequest, String category) {
        SearchPage search = new SearchPage(driver);
        search.search(searchRequest)
              .filterByCategory(category);

        return this;
    }

}