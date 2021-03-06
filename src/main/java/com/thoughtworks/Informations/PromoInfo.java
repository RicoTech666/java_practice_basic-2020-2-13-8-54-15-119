package com.thoughtworks.Informations;

import com.thoughtworks.Informations.OrderInfo;
import com.thoughtworks.Promotions.FixedPricePromo;
import com.thoughtworks.Promotions.HalfPricePromo;
import com.thoughtworks.Promotions.ZeroPricePromo;
import com.thoughtworks.interfaces.Promotions;

import java.util.ArrayList;
import java.util.List;

public class PromoInfo {
    private OrderInfo orderInfo;

    public PromoInfo() {
    }

    public PromoInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Promotions getPromotionTypeFromPromoInfo() {
        List<Promotions> promotions = new ArrayList<>();
        promotions.add(new FixedPricePromo(orderInfo));
        promotions.add(new HalfPricePromo(orderInfo));
        promotions.add(new ZeroPricePromo(orderInfo));
        for (Promotions promoType:promotions) {
            if(promoType.isCurrentPromoType()) {
                return promoType;
            }
        }
        return null;
    }

}
