package com.gildedrose

class AgedBrie(sellIn: Int, quality: Int) : Item("Aged Brie", sellIn, quality) {
    override fun updateQuality() {
        if (quality < MAX_QUALITY) quality += 1
        sellIn -= 1
        if (sellIn < 0 && quality < MAX_QUALITY) quality += 1
    }
}