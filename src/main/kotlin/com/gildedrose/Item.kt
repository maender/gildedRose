package com.gildedrose

abstract class Item(var name: String, var sellIn: Int, var quality: Int) {
    companion object {
        const val MAX_QUALITY: Int = 50
        const val MEDIUM_SELLIN: Int = 11
        const val LOW_SELLIN: Int = 6
        const val CONJURED: String = "conjured"
    }

    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    abstract fun updateQuality()
}