package com.gildedrose;

public class ConjuredItem extends ItemUpdateManager {
    ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality > 0) {
            if (sellIn < 0)
                quality -= 2;
            quality -= 2;
        }
    }
}
