package com.gildedrose.updatequality;

import com.gildedrose.Item;

public interface SpecialItemUpdateQuality extends UpdateQuality {

    default void commonUpdateQuality(Item item) {

        if (isQualityLessThan50(item.quality)) {
            item.quality = item.quality + 1;
        }

    }

}
