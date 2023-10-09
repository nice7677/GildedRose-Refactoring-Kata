package com.gildedrose.updatequality;

import com.gildedrose.Item;

public interface UpdateQuality {

    boolean supportTarget(String itemName);

    void run(Item item);

}
