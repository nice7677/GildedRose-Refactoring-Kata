package com.gildedrose.updatequality;

import com.gildedrose.Item;

public interface UpdateQuality {

    boolean supportTarget(String itemName);

    void run(Item item);

    default void sulfurasUpdateQuality(Item item) {

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }

    }

    default boolean isQualityLessThan50(int quality) {
        return quality < 50;
    }

}
