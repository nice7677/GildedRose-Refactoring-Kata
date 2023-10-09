package com.gildedrose.updatequality;

import java.util.HashSet;
import java.util.Set;

public class UpdateQualityManger {

    private static final Set<UpdateQuality> updateQualities = new HashSet<>();

    static {
        updateQualities.add(new AgedBireUpdateQuality());
        updateQualities.add(new BackstagePassesUpdateQuality());
    }

    public Set<UpdateQuality> getUpdateQualities() {
        return updateQualities;
    }

}
