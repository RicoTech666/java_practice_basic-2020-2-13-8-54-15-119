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

    int getTotalPrice() {
        return getEachTotalPrice().stream().reduce(Integer::sum).orElse(0);
    }

    int getHalfPromoAmount() {
        List<String> halfPriceIds = DataProvider.getHalfDishIds();
        int halfPricePromoAmount = 0;
        for (Dish dish : orderedDishes.keySet()) {
            String dishId = dish.getId();
            for (String halfPriceId : halfPriceIds) {
                if (dishId.equals(halfPriceId)) {
                    halfPricePromoAmount += (int) dish.getPrice() / 2 * orderedDishes.get(dish);
                }
            }
        }
        return halfPricePromoAmount;
    }

    String getHalfPromoName() {
        List<String> halfPriceIds = DataProvider.getHalfDishIds();
        StringBuilder halfPromoName = new StringBuilder();
        for (Dish dish : orderedDishes.keySet()) {
            String dishId = dish.getId();
            for (String halfPriceId : halfPriceIds) {
                if (dishId.equals(halfPriceId)) {
                    halfPromoName.append(dish.getName()).append("，");
                }
            }
        }
        return halfPromoName.deleteCharAt(halfPromoName.length() - 1).toString();
    }

    String getBasicInfo() {
        StringBuilder basicInfo = new StringBuilder();

        for (Dish dish : orderedDishes.keySet()) {
            basicInfo.append(dish.getName()).append(" x ").append(orderedDishes.get(dish)).append(" = ")
                    .append((int) dish.getPrice() * orderedDishes.get(dish)).append("元").append("\n");
        }
        return basicInfo.toString();
    }
}
