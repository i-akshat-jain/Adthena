package com.Adthena

import org.scalatest.funsuite.AnyFunSuite


class BasketPricingTest extends AnyFunSuite {

  test("calculatePrice should correctly calculate the total price") {
    val items = List(Item("Soup", 0.65), Item("Bread", 0.80), Item("Milk", 1.30))
    val expectedTotalPrice = 2.75 // Replace with the expected total price

    val totalPrice = BasketPricing.calculatePrice(items)

    assert(totalPrice == expectedTotalPrice)
  }

  test("calculatePrice should handle an empty basket") {
    val items = List.empty[Item]
    val expectedTotalPrice = 0.0 // The basket is empty, so the total price should be 0.0

    val totalPrice = BasketPricing.calculatePrice(items)

    assert(totalPrice == expectedTotalPrice)
  }

  test("applesDiscount should calculate 10% off for multiple Apple items") {
    val items = List(Item("Apples", 2.0), Item("Apples", 1.5))
    val expectedDiscount = 0.35 // 10% off on the total price of Apples

    val discount = BasketPricing.applesDiscount(items)

    assert(discount == expectedDiscount)
  }

  test("applesDiscount should return 0 discount when there are no Apples in the basket") {
    val items = List(Item("Soup", 1.0), Item("Bread", 2.0))
    val expectedDiscount = 0.0 // No Apples in the basket, so no discount

    val discount = BasketPricing.applesDiscount(items)

    assert(discount == expectedDiscount)
  }

  test("soupBreadDiscount should calculate half price for Bread when buying 2 tins of Soup") {
    val items = List(Item("Soup", 2.0), Item("Soup", 2.0), Item("Bread", 1.0))
    val expectedDiscount = 0.5 // Half price discount on Bread due to Soup

    val discount = BasketPricing.soupBreadDiscount(items)

    assert(discount == expectedDiscount)
    println("Soup and Bread discount test succeeded!")
  }

  test("soupBreadDiscount should return 0 discount when there is no eligible Bread in the basket") {
    val items = List(Item("Soup", 2.0), Item("Bread", 1.0))
    val expectedDiscount = 0.0 // Not enough Soup to get the discount on Bread

    val discount = BasketPricing.soupBreadDiscount(items)

    assert(discount == expectedDiscount)
  }
}
