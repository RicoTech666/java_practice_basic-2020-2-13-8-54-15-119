package com.thoughtworks;

import com.thoughtworks.interfaces.Promotions;

public class HalfPricePromo implements Promotions {
    private OrderInfo orderInfo;
    private final int fixedPromoPrice = 6;
    private final int promoThreshold = 30;

    public HalfPricePromo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public boolean isCurrentPromoType() {
        int originalTotalPrice = orderInfo.getTotalPrice();
        int halfPromoAmount = orderInfo.getHalfPromoAmount();
        return (halfPromoAmount > fixedPromoPrice && originalTotalPrice > promoThreshold)
                || (halfPromoAmount > 0 && originalTotalPrice < promoThreshold);
    }

    @Override
    public int getPromotionPrice() {
        return orderInfo.getHalfPromoAmount();
    }

    @Override
    public String getPromotionResult() {
        return null;
    }
}
