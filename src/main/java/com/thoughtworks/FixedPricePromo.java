package com.thoughtworks;

import com.thoughtworks.interfaces.Promotions;

public class FixedPricePromo implements Promotions {
    private OrderInfo orderInfo;
    private final int fixedPromoPrice = 6;
    private final int promoThreshold = 30;

    public FixedPricePromo() {
    }

    FixedPricePromo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public boolean isCurrentPromoType() {
        int originalTotalPrice = orderInfo.getTotalPrice();
        int halfPromoAmount = orderInfo.getHalfPromoAmount();
        return (originalTotalPrice > promoThreshold && fixedPromoPrice > halfPromoAmount);
    }

    @Override
    public int getPromotionPrice() {
        return fixedPromoPrice;
    }

    @Override
    public String getPromotionResult() {
        int finalPrice = orderInfo.getTotalPrice() - this.getPromotionPrice();
        return "-----------------------------------\n使用优惠:\n满" + promoThreshold + "减" + fixedPromoPrice + "元，省" +
                fixedPromoPrice + "元\n" +
                "-----------------------------------\n" + "总计：" +
                finalPrice + "元\n" +
                "===================================";
    }
}
