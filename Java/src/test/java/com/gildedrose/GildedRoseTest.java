package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("GildedRose 테스트")
class GildedRoseTest {

    /**
     * TODO
     * 새로운 기능을 추가하여 새로운 카테고리의 상품을 판매할 수 있도록 하는 것.
     */
    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("판매하는 나머지 일수가 없어지면, Quality 값이 2배로 감소한다.")
    void sellIn() {

        Item[] items = new Item[]{new Item("Once the sell by date has passed, Quality degrades twice as fast", 0, 10)};

        assertEquals(items[0].sellIn, 0);

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, -1);
        assertEquals(items[0].quality, 8);

        app.updateQuality();

        assertEquals(items[0].sellIn, -2);
        assertEquals(items[0].quality, 6);

    }

    @Test
    @DisplayName("Quality 값은 0보다 작아질 수 없다.")
    void quality() {

        Item[] items = new Item[]{new Item("Quality 값은 0보다 작아질 수 없다.", 0, 0)};

        assertEquals(items[0].sellIn, 0);
        assertEquals(items[0].quality, 0);

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, -1);
        assertEquals(items[0].quality, 0);

        app.updateQuality();

        assertEquals(items[0].sellIn, -2);
        assertEquals(items[0].quality, 0);

    }

    @Test
    @DisplayName("Aged Brie의 Quality 값은 SellIn 값이 떨어질수록 증가한다. (SellIn 값이 < 0 되면 Quality 값은 2배로 증가한다.)")
    void agedBrie() {

        Item[] items = new Item[]{new Item("Aged Brie", 0, 0), new Item("Aged Brie", 2, 0)};

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, -1);
        assertEquals(items[0].quality, 2);

        assertEquals(items[1].sellIn, 1);
        assertEquals(items[1].quality, 1);

        app.updateQuality();

        assertEquals(items[0].sellIn, -2);
        assertEquals(items[0].quality, 4);

        assertEquals(items[1].sellIn, 0);
        assertEquals(items[1].quality, 2);

    }

}
