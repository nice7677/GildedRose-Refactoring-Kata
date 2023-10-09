package com.gildedrose.updatequality;

import com.gildedrose.Item;

public class BackstagePassesUpdateQuality implements UpdateQuality {

    private static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

    @Override
    public boolean supportTarget(String itemName) {
        return ITEM_NAME.equals(itemName);
    }

    @Override
    public void run(Item item) {

    }

}
