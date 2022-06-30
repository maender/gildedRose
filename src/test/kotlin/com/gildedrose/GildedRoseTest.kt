package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun fooIsPrintedCorrectly() {
        val items = arrayOf<Item>(Item("foo", 1, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo, 0, 0", app.items[0].toString())
    }

    @Test
    fun fooSellInGoesFrom0ToMinus1AndQualityStaysTo0() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBrieAndQualityLessThanFiftyAndSellingEquals0() {
        val items = arrayOf<Item>(Item("Aged Brie", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun agedBrieAndQualityLessThanFiftyAndSellingGreaterThan0() {
        val items = arrayOf<Item>(Item("Aged Brie", 3, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].sellIn)
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun agedBrieAndQualityGreaterThanFiftyAndSellingGreaterThan0() {
        val items = arrayOf<Item>(Item("Aged Brie", 3, 55))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].sellIn)
        assertEquals(55, app.items[0].quality)
    }

    @Test
    fun backstageAndQualityGreaterThanFiftyAndSellingGreaterThan0() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 5, 55))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, app.items[0].sellIn)
        assertEquals(55, app.items[0].quality)
    }
    @Test
    fun backstageAndQualityLessThanFiftySellingGreaterThanEleven() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 15, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(14, app.items[0].sellIn)
        assertEquals(16, app.items[0].quality)
    }

    @Test
    fun backstageAndQualityLessThanFiftySellingLessThanEleven() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 10, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(17, app.items[0].quality)
    }

    @Test
    fun backstageAndQualityLessThanFiftySellingLessThanSix() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 5, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, app.items[0].sellIn)
        assertEquals(18, app.items[0].quality)
    }

    @Test
    fun backstageAndQualityLessThanFiftySellingToEqual0() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 0, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun fooQualityLessThanFiftySellingToEqual0() {
        val items = arrayOf<Item>(Item("foo", 0, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun ifSulfurasThanNothingHappend() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }
}


