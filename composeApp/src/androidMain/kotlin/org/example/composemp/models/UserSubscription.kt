package org.example.composemp.models




import com.android.billingclient.api.ProductDetails
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.LocalDateTime

data class UserSubscription(
    val userId: String = "",
    val subscriptionStatus: SubscriptionStatus = SubscriptionStatus.TRIAL,
    val subscriptionType: SubscriptionType = SubscriptionType.FREE,
    val startDate: Long = 0L,
    val endDate: Long = 0L,
    val autoRenew: Boolean = false,
    val lastUpdated: Long = System.currentTimeMillis()
) {
    // Add no-argument constructor for Firestore
    constructor() : this(
        userId = "",
        subscriptionStatus = SubscriptionStatus.TRIAL,
        subscriptionType = SubscriptionType.FREE,
        startDate = 0L,
        endDate = 0L,
        autoRenew = false
    )

    // Format dates in "dd MMM yyyy" format using kotlinx-datetime
    fun getFormattedStartDate(): String = formatDate(startDate)
    fun getFormattedEndDate(): String = formatDate(endDate)
    fun getFormattedLastUpdated(): String = formatDate(lastUpdated)

    private fun formatDate(timestamp: Long): String {
        return if (timestamp > 0) {
            val instant = Instant.fromEpochMilliseconds(timestamp)
            val localDateTime: LocalDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
            "${localDateTime.dayOfMonth} ${localDateTime.month.name.lowercase().replaceFirstChar { it.uppercase() }} ${localDateTime.year}"
        } else {
            "N/A"
        }
    }
}

enum class SubscriptionStatus {
    ACTIVE,
    EXPIRED,
    CANCELLED,
    TRIAL;

    companion object {
        fun fromString(value: String): SubscriptionStatus {
            return try {
                valueOf(value)
            } catch (e: Exception) {
                TRIAL // Default value if parsing fails
            }
        }
    }
}

enum class SubscriptionType {
    FREE,
    MONTHLY,
    YEARLY;

    companion object {
        fun fromString(value: String): SubscriptionType {
            return try {
                valueOf(value)
            } catch (e: Exception) {
                FREE // Default value if parsing fails
            }
        }
    }
}

data class SubscriptionPricing(
    val basePrice: String,
    val offerPrice: String?,
    val billingPeriod: String,
    val savePercentage: Int?
)

fun ProductDetails.getSubscriptionPricing(): SubscriptionPricing {
    val offerDetails = subscriptionOfferDetails?.firstOrNull()
    val pricingPhases = offerDetails?.pricingPhases?.pricingPhaseList

    // Directly get the first phase price
    val price = pricingPhases?.firstOrNull()?.formattedPrice ?: "Price unavailable"

    val billingPeriod = when {
        offerDetails?.basePlanId?.contains("monthly") == true -> "month"
        offerDetails?.basePlanId?.contains("annual") == true -> "year"
        else -> "month"
    }

    return SubscriptionPricing(
        basePrice = price,
        offerPrice = price,  // Use the same price as both base and offer price
        billingPeriod = billingPeriod,
        savePercentage = null
    )
}