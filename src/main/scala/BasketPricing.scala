package com.Adthena

import scala.io.StdIn
import java.text.NumberFormat
import java.util.Locale
import scala.math.BigDecimal.RoundingMode

case class Item(name: String, price: Double)

object BasketPricing {
    // Define a map of items and their prices
    val items = Map(
        "Soup" -> Item("Soup", 0.65),
        "Bread" -> Item("Bread", 0.80),
        "Milk" -> Item("Milk", 1.30),
        "Apples" -> Item("Apples", 1.00)
    )

    // Calculate the discount amount for Apples (10% off)
    def applesDiscount(items: List[Item]): Double = {
    val apples = items.filter(_.name == "Apples")
    val totalApplesPrice = apples.map(_.price).sum
    val discount = BigDecimal(totalApplesPrice * 0.1).setScale(2, RoundingMode.HALF_UP).toDouble
    discount
  }

    // Calculate the discount amount for Bread (half price when buying 2 tins of Soup)
    
  def soupBreadDiscount(items: List[Item]): Double = {
    val soupCount = items.count(_.name == "Soup")
    val breadCount = items.count(_.name == "Bread")
    val eligibleBreadCount = 
      if (soupCount >= 2) {
        if (soupCount % 2 == 0) soupCount / 2 
        else (soupCount - 1) / 2
          }
      else {
              0
          }
    val breadPrice = items.find(_.name == "Bread").map(_.price).getOrElse(0.0)
    val discount = eligibleBreadCount * breadPrice * 0.5
    discount
    }

    // Calculate the subtotal, discounts, and total price
    def calculatePrice(items: List[Item]): Double = {
        val subtotal = items.map(_.price).sum
        val applesDiscountAmount = applesDiscount(items)
        val soupBreadDiscountAmount = soupBreadDiscount(items)
        val totalDiscount = applesDiscountAmount + soupBreadDiscountAmount
        val totalPrice = subtotal - totalDiscount
        val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK)

        println("Basket Items:")
        items.groupBy(_.name).foreach { case (name, itemList) =>
            val quantity = itemList.size
            val price = itemList.head.price
            println(s"$name - Quantity: $quantity, Price: ${currencyFormatter.format(price)}")
        }

        // Print the subtotal, discounts, and total price
        println(s"Subtotal: ${currencyFormatter.format(subtotal)}")
        if (totalDiscount > 0) {
            println(s"Apples 10% off: ${currencyFormatter.format(applesDiscountAmount)}")
            println(s"Total price: ${currencyFormatter.format(totalPrice)}")
        } else {
            println("(No offers available)")
            println(s"Total price: ${currencyFormatter.format(totalPrice)}")
        }

        // Return the total price
        totalPrice
    }

    def main(args: Array[String]): Unit = {
        // Get the basket items from command-line arguments and calculate the price
        val basketItems = args.flatMap(items.get)
        calculatePrice(basketItems.toList)
    }
}
