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

    public static void main(String[] args) {
        String price = "17 999";
        price = price.replaceAll("\\s+", "");
        System.out.println(price);
    }
        /*
        List<Good> goods = new LinkedList<>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            goods.add(i, new Good("Xiaomi" + i, rand.nextInt(50)));
        }
        for (Good good : goods)
            System.out.println(good.name + "; " + good.price);

        System.out.println("Results");

        goods = Good.goodsWithHighestPrices(goods, 3);
        for (Good g : goods){
            System.out.println(g.name + "; " + g.price);
        }
    }
    */
}
