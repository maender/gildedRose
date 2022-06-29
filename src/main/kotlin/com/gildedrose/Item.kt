package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int, var special: Boolean = false) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}