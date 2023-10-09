package com.gildedrose;

import com.gildedrose.updatequality.UpdateQualityManger;
import com.gildedrose.updatequality.UpdateQualityProcessor;

class GildedRose {

    private static final UpdateQualityManger updateQualityManger = new UpdateQualityManger();

    private final UpdateQualityProcessor updateQualityProcessor;

    Item[] items;

    public GildedRose(Item[] items) {
        updateQualityProcessor = new UpdateQualityProcessor(updateQualityManger.getUpdateQualities());
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityProcessor.run(item);
        }
    }
}
