package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = arrayOf<Item>(Other("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }

    @Test
    fun fooIsPrintedCorrectly() {
        val items = arrayOf<Item>(Other("foo", 1, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo, 0, 0", app.items[0].toString())
    }

    @Test
    fun fooSellingoesfrom0ToMinus1AndQualityStaysTo0() {
        val items = arrayOf<Item>(Other("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun AgedBrieAndQualitylLessThanFiftyAndSellingEquals0() {
        val items = arrayOf<Item>(AgedBrie(0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun AgedBrieAndQualitylLessThanFiftyAndSellingGreatherThan0() {
        val items = arrayOf<Item>(AgedBrie(3, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].sellIn)
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun AgedBrieAndQualitylGreatherThanFiftyAndSellingGreatherThan0() {
        val items = arrayOf<Item>(AgedBrie(3, 55))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].sellIn)
        assertEquals(55, app.items[0].quality)
    }

    @Test
    fun BackstageAndQualitylLessThanFiftySellingGreatherthanEleven() {
        val items = arrayOf<Item>(Backstage(15, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(14, app.items[0].sellIn)
        assertEquals(16, app.items[0].quality)
    }

    @Test
    fun BackstageAndQualitylLessThanFiftySellingLessThanEleven() {
        val items = arrayOf<Item>(Backstage(10, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(17, app.items[0].quality)
    }

    @Test
    fun BackstageAndQualitylLessThanFiftySellingLessThanSix() {
        val items = arrayOf<Item>(Backstage(5, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, app.items[0].sellIn)
        assertEquals(18, app.items[0].quality)
    }

    @Test
    fun BackstageAndQualitylLessThanFiftySellingToEqual0() {
        val items = arrayOf<Item>(Backstage(0, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun FooQualitylLessThanFiftySellingToEqual0() {
        val items = arrayOf<Item>(Other("foo", 0, 15))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun IfSulfurasThanNothingHappend() {
        val items = arrayOf<Item>(Sulfuras(0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun conjuredItemDecreaseTwicePerDay() {
        val items = arrayOf<Item>(Other("Conjured Mana Cake", 3, 6))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].sellIn)
        assertEquals(4, app.items[0].quality)
    }

    @Test
    fun itemQualityIsNeverLessThan0() {
        val items = arrayOf<Item>(Other("Conjured Mana Cake", 0, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun itemQuelityIsNeverAbove50() {
        val items = arrayOf<Item>(Backstage(2, 48))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }
}


