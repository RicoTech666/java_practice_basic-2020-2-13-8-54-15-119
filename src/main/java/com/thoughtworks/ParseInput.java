package com.thoughtworks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParseInput {
    private String input;

    public ParseInput(String input) {
        this.input = input;
    }

    public OrderInfo parseInputIntoOrderInfo() {
        String[] selectedItemsArr = input.split(",");
        Map<String, Integer> inputMap = new LinkedHashMap<>();
        for (String element : selectedItemsArr) {
            inputMap.put(element.split(" x ")[0], Integer.parseInt(element.split(" x ")[1]));
        }

        List<Dish> allDishes = DataProvider.getDishes();
        Map<Dish,Integer> orderedInfo = new LinkedHashMap<>();

        for(String itemId:inputMap.keySet()) {
            for (Dish dish:allDishes) {
                if(itemId.equals(dish.getId())) {
                    orderedInfo.put(dish,inputMap.get(itemId));
                }
            }
        }
        return new OrderInfo(orderedInfo);
    }
}
