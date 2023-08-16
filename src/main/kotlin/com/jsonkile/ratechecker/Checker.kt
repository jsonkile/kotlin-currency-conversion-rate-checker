package com.jsonkile.ratechecker

import org.jsoup.Connection
import org.jsoup.Jsoup

class Checker(val fromCurrency: Currency, val toCurrency: Currency) {

    private val jsoup: Connection = Jsoup.connect("https://www.google.com/search?q=${fromCurrency}+to+${toCurrency}")
        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36").timeout(7000)

            /**
             * @throws IllegalArgumentException if the conversion rate could not be found
             */
        operator

    fun invoke(): Double {
        val document =
            jsoup.get()
        val elementWithRateInfo = requireNotNull(document.getElementsByAttribute("data-exchange-rate").first()) {
            "The conversion rate could not be found. Please try another currency combination."
        }
        return requireNotNull(elementWithRateInfo.attr("data-exchange-rate").toDoubleOrNull()) {
            "The conversion rate could not be found. Please try another currency combination."
        }
    }

}