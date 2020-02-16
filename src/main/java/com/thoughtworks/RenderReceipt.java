package com.thoughtworks;

import com.thoughtworks.interfaces.Promotions;

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
        PromoInfo promoInfo = parseInput.passOrderInfoToPromoInfo();
        Promotions promotionType = promoInfo.getPromotionTypeFromPromoInfo();
        StringBuilder receipt = new StringBuilder("============= 订餐明细 =============\n");
        receipt.append(orderInfo.getBasicInfo());
        receipt.append(promotionType.getPromotionResult());
        return receipt.toString();
    }
}
