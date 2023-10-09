package com.gildedrose.updatequality;

import com.gildedrose.Item;

public class DefaultUpdateQuality implements UpdateQuality {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Override
    public boolean supportTarget(String itemName) {
        return false;
    }

    @Override
    public void run(Item item) {

        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
            item.quality = item.quality - 1;
        }

        sulfurasUpdateQuality(item);

        if (item.sellIn < 0 && item.quality > 0 && !item.name.equals(SULFURAS)) {

            item.quality = item.quality - 1;

        }

    }

}
