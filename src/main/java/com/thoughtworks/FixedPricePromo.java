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
        StringBuilder promotionResult = new StringBuilder("-----------------------------------\n使用优惠:\n满");
        promotionResult.append(promoThreshold).append("减").append(fixedPromoPrice).append("元，省").append(fixedPromoPrice).append("元");
        return promotionResult.toString();
    }
}

