package com.gildedrose;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

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
}
