package com.gildedrose.updatequality;

import com.gildedrose.Item;

import java.util.Set;

public class UpdateQualityProcessor {

    private final Set<UpdateQuality> updateQualities;

    public UpdateQualityProcessor(Set<UpdateQuality> updateQualities) {
        this.updateQualities = updateQualities;
    }

    public void run(Item item) {

        updateQualities.stream()
            .filter(updateQuality -> updateQuality.supportTarget(item.name))
            .findFirst()
            .orElse(DefaultUpdateQuality.of())
            .run(item);

    }

}
