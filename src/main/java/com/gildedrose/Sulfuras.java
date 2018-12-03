package com.gildedrose;

public class Sulfuras extends ItemUpdateManager {
    Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateSellInDate() {}

    @Override
    public void updateQuality() {}
}
