package com.gildedrose.updatequality;

import com.gildedrose.Item;

public class DefaultUpdateQuality implements UpdateQuality {

    private static final String CONJURED = "Conjured";

    @Override
    public boolean supportTarget(String itemName) {
        return false;
    }

    @Override
    public void run(Item item) {

        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
            updateQuality(item);
        }

        sulfurasUpdateQuality(item);

        if (item.sellIn < 0 && item.quality > 0 && !item.name.equals(SULFURAS)) {
            updateQuality(item);
        }

    }

    private void updateQuality(Item item) {
        item.quality = item.quality - getMinusQualityValue(item.name);
    }

    private int getMinusQualityValue(String itemName) {
        int defaultQualityValue = 1;
        if (itemName.equals(CONJURED)) {
            return defaultQualityValue * 2;
        }
        return defaultQualityValue;
    }

}
