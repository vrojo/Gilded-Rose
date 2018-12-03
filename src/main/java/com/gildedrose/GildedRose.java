package com.gildedrose;

class GildedRose {
    ItemUpdateManager[] items;

    GildedRose(ItemUpdateManager[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (ItemUpdateManager item : items) {
            item.updateSellInDate();
            item.updateQuality();
        }
    }
}