package com.gildedrose;

public class Backstage_Pass extends ItemUpdateManager {
    Backstage_Pass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        if (sellIn >= 0 && quality < MAXIMUM_QUALITY_LEVEL) {
            quality += 1;
            if (sellIn <= 10) {
                quality += 1;
                if (sellIn <= 5) {
                    quality += 1;
                }
            }
        } else if (sellIn < 0) {
            quality = 0;
        }
    }
}
