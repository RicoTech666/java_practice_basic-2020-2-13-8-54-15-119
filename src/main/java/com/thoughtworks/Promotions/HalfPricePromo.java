package com.thoughtworks.Promotions;

import com.thoughtworks.Informations.OrderInfo;
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
        int finalPrice = orderInfo.getTotalPrice() - this.getPromotionPrice();
        return "-----------------------------------\n使用优惠:\n指定菜品半价(" + orderInfo.getHalfPromoName() + ")，省" + getPromotionPrice() + "元\n" +
        "-----------------------------------\n" + "总计：" + finalPrice + "元\n" +
        "===================================";
    }
}
