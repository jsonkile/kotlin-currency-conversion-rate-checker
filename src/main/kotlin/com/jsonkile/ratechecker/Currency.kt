package com.jsonkile.ratechecker

sealed class Currency(private val code: String) {
    /**
     * euro
     */
    object EUR : Currency("EUR")

    /**
     * Nigerian naira
     */
    object NGN : Currency("NGN")

    /**
     * U.S. dollar
     */
    object USD : Currency("USD")

    /**
     * Australian dollar
     */
    object AUD : Currency("AUD")

    /**
     * Japanese yen
     */
    object JPY : Currency("JPY")

    /**
     * Great Britain pound
     */
    object GBP : Currency("GBP")

    /**
     * Swiss franc
     */
    object CHF : Currency("CHF")

    /**
     * Canadian dollar
     */
    object CAD : Currency("CAD")

    /**
     * China yuan renminbi
     */
    object CNY : Currency("CNY")

    /**
     * New Zealand dollar
     */
    object NZD : Currency("NZD")

    /**
     * Indian rupee
     */
    object INR : Currency("INR")

    /**
     * Brazilian real
     */
    object BZR : Currency("BZR")

    /**
     * Swedish krona
     */
    object SEK : Currency("SEK")

    /**
     * South African rand
     */
    object ZAR : Currency("ZAR")

    /**
     * Hong Kong dollar
     */
    object HKD : Currency("HKD")

    class Custom(code: String) : Currency(code)


    override fun toString(): String {
        return code.toLowerCase()
    }
}