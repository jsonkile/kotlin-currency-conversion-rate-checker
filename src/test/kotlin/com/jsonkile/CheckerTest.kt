package com.jsonkile

import com.jsonkile.ratechecker.Checker
import com.jsonkile.ratechecker.Currency
import org.jsoup.HttpStatusException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CheckerTest {

    @Test
    fun checkerReturnsDouble() {
        Assertions.assertDoesNotThrow {
            val checker = Checker(fromCurrency = Currency.USD, toCurrency = Currency.NGN)
            checker()
        }
    }

    @Test
    fun checkerThrowsException() {
        Assertions.assertThrows(HttpStatusException::class.java) {
            val checker = Checker(fromCurrency = Currency.USD, toCurrency = Currency.Custom("dskdbskjdbsk"))
            checker()
        }
    }

}