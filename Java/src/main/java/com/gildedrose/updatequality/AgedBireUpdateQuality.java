package com.gildedrose.updatequality;

import com.gildedrose.Item;

public class AgedBireUpdateQuality implements UpdateQuality {

    private static final String ITEM_NAME = "Aged Brie";

    @Override
    public boolean supportTarget(String itemName) {
        return ITEM_NAME.equals(itemName);
    }

    @Override
    public void run(Item item) {

    }

}
