package com.google.citrus.catalogue;

import java.util.Comparator;

public class GoodPriceComparator implements Comparator<Good> {

    public int compare(Good a, Good b) {

        if (a.price > b.price) {
            return -1;
        } else if (a.price < b.price) {
            return 1;
        } else {
            return  0;
        }
    }
}
