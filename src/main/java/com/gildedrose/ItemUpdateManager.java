package com.gildedrose;

public class ItemUpdateManager extends Item {
    final int MAXIMUM_QUALITY_LEVEL = 50;

    ItemUpdateManager(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateSellInDate() {
        sellIn -= 1;
    }

    public void updateQuality() {
        if (quality > 0) {
            if (sellIn < 0)
                quality--;
            quality--;
        }
    }
}
