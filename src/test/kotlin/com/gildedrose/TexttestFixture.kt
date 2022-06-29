package com.gildedrose

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayOf(
        Item("+5 Dexterity Vest", 10, 20), //
        Item("Aged Brie", 2, 0, true), //
        Item("Elixir of the Mongoose", 5, 7), //
        Item("Sulfuras, Hand of Ragnaros", 0, 80, true), //
        Item("Sulfuras, Hand of Ragnaros", -1, 80, true),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20, true),
        Item("Backstage passes to a TAFKAL80ETC concert", 10, 49, true),
        Item("Backstage passes to a TAFKAL80ETC concert", 5, 49, true),
        Item("Conjured Mana Cake", 3, 6)
    )

    val app = GildedRose(items)

    var days = 0
    if (args.isNotEmpty()) {
        days = try {
            Integer.parseInt(args[0]) + 1
        } catch (e: Exception) {
            2
        }
    }

    for (i in 0 until days) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQuality()
    }
}
