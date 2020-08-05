package com.google.citrus.catalogue;

import java.util.*;
import java.util.stream.Collectors;

public class Good {
    public String name;
    public int price;

    public Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static List<Good> goodsWithHighestPrices(List<Good> incomingGoods, long numberOfGoods) {

        Comparator<Good> goodPriceComparator = new GoodPriceComparator();

        return incomingGoods.stream()
                            .sorted(goodPriceComparator)
                            .limit(numberOfGoods)
                            .collect(Collectors.toList());

    }
}
