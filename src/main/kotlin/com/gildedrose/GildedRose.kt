package com.gildedrose

class GildedRose(var items: Array<Item>) {
    private val MAX_QUALITY: Int = 50
    private val MEDIUM_QUALITY: Int = 11
    private val MIN_QUALITY: Int = 6
    fun updateQuality() {
        for (item in items) {
            if (item.name == "Sulfuras, Hand of Ragnaros") continue
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert" && item.quality < 50) {
                        if (item.sellIn < MIN_QUALITY) {
                            item.quality = item.quality + 2
                        }
                        else if (item.sellIn < MEDIUM_QUALITY) {
                            item.quality = item.quality + 1
                        }
                    }
                }
            }

            item.sellIn = item.sellIn - 1

            if (item.sellIn < 0) {
                if (item.name != "Aged Brie") {
                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.quality > 0) {
                            item.quality = item.quality - 1
                        }
                    } else {
                        item.quality = 0
                    }
                } else if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1
                }
            }
        }
    }
}
