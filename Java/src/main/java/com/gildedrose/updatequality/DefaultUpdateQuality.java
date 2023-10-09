package com.gildedrose.updatequality;

import com.gildedrose.Item;

public class DefaultUpdateQuality implements UpdateQuality {

    @Override
    public boolean supportTarget(String itemName) {
        return false;
    }

    @Override
    public void run(Item item) {

    }

}
