package com.thoughtworks;

import com.thoughtworks.interfaces.Promotions;

public class PromoInfo {
    private OrderInfo orderInfo;

    public PromoInfo() {
    }

    public PromoInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Promotions getPromotionTypeFromPromoInfo() {
        Promotions fixedPricePromo = new FixedPricePromo(orderInfo);
        return fixedPricePromo;
    }

}
