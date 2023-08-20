package com.jsonkile.ratechecker

fun main() {
    val checker = Checker(toCurrency = Currency.NGN, fromCurrency = Currency.USD)
    println("${checker.fromCurrency} to ${checker.toCurrency} => ${checker()}")
}