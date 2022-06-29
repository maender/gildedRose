package com.gildedrose

class GildedRose(var items: Array<Item>) {
    private val MAX_QUANTITY = 50
    private val MEDIUM_QUANTITY = 11
    private val MIN_QUANTITY = 6
    fun updateQuality() {
        for (item in items) {
            if (item.name == "Sulfuras, Hand of Ragnaros") continue
            if (item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
                if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
            } else {
                if (item.quality < MAX_QUANTITY) {
                    item.quality = item.quality + 1

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert" && item.quality < 50) {
                        if (item.sellIn < MIN_QUANTITY) {
                            item.quality = item.quality + 2
                        }
                        else if (item.sellIn < MEDIUM_QUANTITY) {
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
                } else {
                    if (item.quality < MAX_QUANTITY) {
                        item.quality = item.quality + 1
                    }
                }
            }
        }
    }
}

