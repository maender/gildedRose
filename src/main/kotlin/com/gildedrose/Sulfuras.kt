package com.gildedrose

class Sulfuras(sellIn: Int, quality: Int) : Item("Sulfuras, Hand of Ragnaros", sellIn, quality) {
    override fun updateQuality() {
        // Nothing to do, Sulfuras is legendary
    }
}