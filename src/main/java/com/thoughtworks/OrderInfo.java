package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderInfo {
    private Map<Dish, Integer> orderedDishes;

    public OrderInfo() {
    }

    OrderInfo(Map<Dish, Integer> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    private List<Integer> getEachTotalPrice() {
        List<Integer> eachTotalPriceList = new ArrayList<>();
        for (Dish dish : orderedDishes.keySet()) {
            eachTotalPriceList.add((int) dish.getPrice() * orderedDishes.get(dish));
        }
        return eachTotalPriceList;
    }

    public int getTotalPrice() {
        return getEachTotalPrice().stream().reduce(Integer::sum).orElse(0);
    }

    public String getBasicInfo() {
        StringBuilder basicInfo = new StringBuilder();

        for (Dish dish : orderedDishes.keySet()) {
            basicInfo.append(dish.getName()).append(" x ").append(orderedDishes.get(dish)).append(" = ")
                    .append((int) dish.getPrice() * orderedDishes.get(dish)).append("\n");
        }
        return basicInfo.toString();
    }
}
