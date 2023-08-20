package com.jsonkile.ratechecker

import org.jsoup.Connection
import org.jsoup.Jsoup

class Checker(val fromCurrency: Currency, val toCurrency: Currency) {

    private val endpoint =
        "https://www.forbes.com/advisor/money-transfer/currency-converter/${fromCurrency}-${toCurrency}/?amount=1"

    private val jsoup: Connection =
        Jsoup.connect(endpoint)
            .userAgent("Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko; compatible; Googlebot/2.1; +http://www.google.com/bot.html) Chrome/116.0.0.0 Safari/537.36")
            .timeout(10000)

    /**
     * @throws IllegalArgumentException if the conversion rate could not be found
     */
    operator

    fun invoke(): Double {
        val document = jsoup.get()
        val elementWithRateInfo = requireNotNull(
            document.getElementsByClass("amount").firstOrNull()
        ) { "The conversion rate could not be found. Please try another currency combination." }

        return requireNotNull(elementWithRateInfo.text().toDoubleOrNull()) {
            "The conversion rate could not be found. Please try another currency combination."
        }
    }

}

fun main() {
    val checker = Checker(toCurrency = Currency.NGN, fromCurrency = Currency.USD)
    println("${checker.fromCurrency} to ${checker.toCurrency} => ${checker()}")
}