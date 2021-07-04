package io.rotlabs.nurturebomber

import java.io.Serializable

data class CardInfo(
    val header: String,
    val cardType: String,
    val CTA: String,
    val childCard: CardInfo? = null
) :Serializable