package com.gildedrose

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayOf(
        Other("+5 Dexterity Vest", 10, 20), //
        AgedBrie(2, 0), //
        Other("Elixir of the Mongoose", 5, 7), //
        Sulfuras(0, 80), //
        Sulfuras(-1, 80), //
        Backstage(15, 20),
        Backstage(10, 49),
        Backstage(5, 49),
        Backstage(3, 6),
        Other("Conjured Mana Cake", 3, 6)
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
