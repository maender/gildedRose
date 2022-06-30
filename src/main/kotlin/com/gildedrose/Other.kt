package com.gildedrose

class Other(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    private fun decreaseQuality() {
        quality = if (name.startsWith(CONJURED, true)) {
            quality - (if (quality > 1) 2 else 1)
        } else {
            quality - 1
        }
    }

    override fun updateQuality() {
        if (quality > 0) {
            decreaseQuality()
        }

        sellIn -= 1

        if (sellIn < 0 && quality > 0) {
            decreaseQuality()
        }
    }
}