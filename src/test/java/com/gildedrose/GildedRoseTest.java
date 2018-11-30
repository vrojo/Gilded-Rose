package com.gildedrose;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void should_decrease_the_quality_value_of_a_normal_object_by_one_for_one_day() {
        String itemName = "+5 Dexterity Vest";
        int itemSellIn = 10;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(itemQuality - 1);
    }

    @Test
    public void should_decrease_the_sellIn_value_of_a_normal_object_by_one_for_one_day() {
        String itemName = "+5 Dexterity Vest";
        int itemSellIn = 10;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(itemSellIn - 1);
    }

    @Test
    public void should_decrease_twice_faster_the_quality_value_of_a_normal_object_when_sellIn_date_is_negative() {
        String itemName = "+5 Dexterity Vest";
        int itemSellIn = 0;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(itemQuality - 2);
    }

    @Test
    public void should_increase_the_quality_value_of_an_Aged_Brie_when_a_day_passes() {
        String itemName = "Aged Brie";
        int itemSellIn = 5;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(itemQuality + 1);
    }
}
