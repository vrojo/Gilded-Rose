package com.gildedrose;

public class AgedBrie extends ItemUpdateManager {
    AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < MAXIMUM_QUALITY_LEVEL) {
            this.quality += 1;
            if (this.sellIn < 0 && quality < MAXIMUM_QUALITY_LEVEL) {
                this.quality += 1;
            }
        }
    }
}
