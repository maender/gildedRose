package com.gildedrose

class Backstage(sellIn: Int, quality: Int) : Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {
    override fun updateQuality() {
        sellIn -= 1
        quality = if (sellIn < 0) 0
        else {
            when {
                sellIn < LOW_SELLIN -> quality + 3
                sellIn < MEDIUM_SELLIN -> quality + 2
                else -> quality + 1
            }
        }
        if (quality > MAX_QUALITY) quality = MAX_QUALITY
    }
}
