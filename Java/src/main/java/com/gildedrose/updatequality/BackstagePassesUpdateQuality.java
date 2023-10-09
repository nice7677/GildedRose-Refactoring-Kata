package com.gildedrose.updatequality;

import com.gildedrose.Item;

public class BackstagePassesUpdateQuality implements SpecialItemUpdateQuality {

    private static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    @Override
    public boolean supportTarget(String itemName) {
        return ITEM_NAME.equals(itemName);
    }

    @Override
    public void run(Item item) {

        if (isQualityLessThan50(item.quality)) {
            commonUpdateQuality(item);
            updateBackstagePassesQuality(item);
        }

        sulfurasUpdateQuality(item);

        if (item.sellIn < 0) {
            updateQuality(item, item.quality);
        }

    }

    private void updateBackstagePassesQuality(Item item) {
        if (item.sellIn < 11 && isQualityLessThan50(item.quality)) {
            updateQuality(item, 1);
        }
        if (item.sellIn < 6 && isQualityLessThan50(item.quality)) {
            updateQuality(item, 1);
        }
    }

    private void updateQuality(Item item, int value) {
        item.quality = item.quality + value;
    }

}
