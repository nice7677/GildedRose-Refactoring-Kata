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

    @Test
    @DisplayName("Quality 값은 50을 넘을 수 없다.")
    void quality50() {

        Item[] items = new Item[]{new Item("Aged Brie", 0, 50)};

        assertEquals(items[0].sellIn, 0);
        assertEquals(items[0].quality, 50);

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, -1);
        assertEquals(items[0].quality, 50);

        app.updateQuality();

        assertEquals(items[0].sellIn, -2);
        assertEquals(items[0].quality, 50);

    }

    @Test
    @DisplayName("Sulfuras의 Quality 값은 변하지 않는다.")
    void sulfurasQuality() {

        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 50)};

        assertEquals(items[0].sellIn, 0);
        assertEquals(items[0].quality, 50);

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, 0);
        assertEquals(items[0].quality, 50);

        app.updateQuality();

        assertEquals(items[0].sellIn, 0);
        assertEquals(items[0].quality, 50);

    }

    @Test
    @DisplayName("Backstage Passes의 Quality 값은 SellIn 값이 10이하면 2씩 증가한다. 5 이하면 3씩 증가한다.")
    void backstagePassesQuality() {

        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0)};

        assertEquals(items[0].sellIn, 6);
        assertEquals(items[0].quality, 0);

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(items[0].sellIn, 5);
        assertEquals(items[0].quality, 2);

        app.updateQuality();

        assertEquals(items[0].sellIn, 4);
        assertEquals(items[0].quality, 5);

    }

}
