package com.thoughtworks;

public class RenderReceipt {
    private String selectedItems;

    public RenderReceipt() {
    }

    public RenderReceipt(String selectedItems) {
        this.selectedItems = selectedItems;
    }

    public String getReceipt() {
        ParseInput parseInput = new ParseInput(selectedItems);
        OrderInfo orderInfo = parseInput.parseInputIntoOrderInfo();
        StringBuilder receipt = new StringBuilder("============= 订餐明细 =============");
        return receipt.toString();
    }
}
