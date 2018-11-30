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

    @Test
    public void should_stop_increasing_the_quality_value_when_it_has_reached_50() {
        String itemName = "Aged Brie";
        int itemSellIn = 5;
        int itemQuality = 50;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(itemQuality);
    }

    @Test
    public void should_stop_decreasing_the_quality_value_when_it_has_reached_0() {
        String itemName = "+5 Dexterity Vest";
        int itemSellIn = 5;
        int itemQuality = 0;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(itemQuality);
    }

    @Test
    public void should_not_change_anything_on_the_sulfuras_when_a_day_passes() {
        String itemName = "Sulfuras, Hand of Ragnaros";
        int itemSellIn = 0;
        int itemQuality = 80;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(itemQuality);
        assertThat(app.items[0].sellIn).isEqualTo(itemSellIn);
    }

    @Test
    public void should_increase_quality_like_Aged_Brie_for_Backstage_passes_when_sellIn_date_bigger_than_10() {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        int itemSellIn = 15;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(itemQuality + 1);
    }

    @Test
    public void should_increase_quality_twice_faster_for_Backstage_passes_when_sellIn_date_smaller_or_equal_to_10_but_bigger_than_5() {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        int itemSellIn = 10;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(itemQuality + 2);
    }

    @Test
    public void should_increase_quality_triple_times_faster_for_Backstage_passes_when_sellIn_date_smaller_or_equal_to_5_but_bigger_than_0() {
        String itemName = "Backstage passes to a TAFKAL80ETC concert";
        int itemSellIn = 5;
        int itemQuality = 20;
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(itemQuality + 3);
    }
}
