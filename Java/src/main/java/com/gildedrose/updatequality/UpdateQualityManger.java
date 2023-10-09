package com.gildedrose.updatequality;

import java.util.HashSet;
import java.util.Set;

public class UpdateQualityManger {

    private static final Set<UpdateQuality> updateQualities = new HashSet<>();

    public void addUpdateQuality(UpdateQuality updateQuality) {
        updateQualities.add(updateQuality);
    }

    public Set<UpdateQuality> getUpdateQualities() {
        return updateQualities;
    }

}
