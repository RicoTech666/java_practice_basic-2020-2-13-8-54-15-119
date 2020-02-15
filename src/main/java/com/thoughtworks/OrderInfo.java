package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderInfo {
    private Map<Dish, Integer> orderedDishes;

    public OrderInfo() {
    }

    public OrderInfo(Map<Dish, Integer> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public List<Integer> getEachTotalPrice() {
        List<Integer> eachTotalPriceList = new ArrayList<>();
        for (Dish dish : orderedDishes.keySet()) {
            eachTotalPriceList.add((int) dish.getPrice() * orderedDishes.get(dish));
        }
        return eachTotalPriceList;
    }

    public int getTotalPrice() {
        return (int) getEachTotalPrice().stream().reduce(Integer::sum).orElse(0);
    }
}
