package com.thoughtworks;

import com.thoughtworks.interfaces.Promotions;

public class ZeroPricePromo implements Promotions {
    private OrderInfo orderInfo;
    private final int promoThreshold = 30;

    ZeroPricePromo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public boolean isCurrentPromoType() {
        int originalTotalPrice = orderInfo.getTotalPrice();
        int halfPromoAmount = orderInfo.getHalfPromoAmount();
        return (halfPromoAmount == 0 && originalTotalPrice < promoThreshold);
    }

    @Override
    public int getPromotionPrice() {
        return 0;
    }

    @Override
    public String getPromotionResult() {
        return "-----------------------------------\n" + "总计：" + orderInfo.getTotalPrice() + "元\n" +
                "===================================";
    }
}
