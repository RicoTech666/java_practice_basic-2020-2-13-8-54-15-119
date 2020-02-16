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
        StringBuilder promotionResult = new StringBuilder("-----------------------------------\n使用优惠:\n指定菜品半价(");
        promotionResult.append(orderInfo.getHalfPromoName()).append(")，省").append(getPromotionPrice()).append("元");
        return promotionResult.toString();
    }
}
