package com.gildedrose

class GildedRose(var items: Array<Item>) {
    companion object {
        const val MAX_QUALITY: Int = 50
        const val MEDIUM_SELLIN: Int = 11
        const val MIN_SELLIN: Int = 6
        const val AGED_BRIE: String = "Aged Brie"
        const val BACKSTAGE: String = "Backstage passes to a TAFKAL80ETC concert"
        const val CONJURED: String = "conjured"
    }

    private fun updateSpecialItem(item: Item) {
        when (item.name) {
            AGED_BRIE -> {
                if (item.quality < MAX_QUALITY) item.quality += 1
                item.sellIn -= 1
                if (item.sellIn < 0 && item.quality < MAX_QUALITY)
                    item.quality += 1
            }
            BACKSTAGE -> {
                item.sellIn -= 1
                if (item.sellIn < 0) item.quality = 0
                else if (item.quality < MAX_QUALITY) {
                    item.quality = if (item.sellIn < MIN_SELLIN) {
                        item.quality + 3
                    } else if (item.sellIn < MEDIUM_SELLIN) {
                        item.quality + 2
                    } else {
                        item.quality + 1
                    }
                }
                if (item.quality > MAX_QUALITY) item.quality = MAX_QUALITY
            }
        }
    }

    private fun decreaseQuality(item: Item) {
        item.quality = if(item.name.startsWith(CONJURED, true)) {
            item.quality - (if (item.quality > 1) 2 else 1)
        }
        else {
            item.quality - 1
        }
    }

    fun updateQuality() {
        for (item in items) {
            if (item.special) {
                updateSpecialItem(item)
            } else {
                if (item.quality > 0) {
                    decreaseQuality(item)
                }

                item.sellIn -= 1
                
                if (item.sellIn < 0 && item.quality > 0) {
                    decreaseQuality(item)
                }
            }
        }
    }

    fun updateQualityLegacy() {
        for (i in items.indices) {
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }
}
