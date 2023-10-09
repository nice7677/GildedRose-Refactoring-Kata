package com.gildedrose.updatequality;

import com.gildedrose.Item;

public class AgedBireUpdateQuality implements SpecialItemUpdateQuality {

    private static final String ITEM_NAME = "Aged Brie";

    @Override
    public boolean supportTarget(String itemName) {
        return ITEM_NAME.equals(itemName);
    }

    @Override
    public void run(Item item) {

        commonUpdateQuality(item);
        sulfurasUpdateQuality(item);

        if (item.sellIn < 0 && isQualityLessThan50(item.quality)) {
            item.quality = item.quality + 1;
        }

    }

}
