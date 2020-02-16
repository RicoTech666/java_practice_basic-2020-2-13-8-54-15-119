package com.thoughtworks;

import com.thoughtworks.Informations.OrderInfo;
import com.thoughtworks.Informations.PromoInfo;
import com.thoughtworks.interfaces.Promotions;

public class RenderReceipt {
    private String selectedItems;

    public RenderReceipt() {
    }

    RenderReceipt(String selectedItems) {
        this.selectedItems = selectedItems;
    }

    String getReceipt() {
        ParseInput parseInput = new ParseInput(selectedItems);
        OrderInfo orderInfo = parseInput.parseInputIntoOrderInfo();
        PromoInfo promoInfo = parseInput.passOrderInfoToPromoInfo();
        Promotions promotionType = promoInfo.getPromotionTypeFromPromoInfo();
        return "============= 订餐明细 =============\n" + orderInfo.getBasicInfo() +
                promotionType.getPromotionResult();
    }
}
