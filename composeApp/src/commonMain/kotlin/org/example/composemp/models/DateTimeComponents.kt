package com.yoda.cbt.models

//import java.time.LocalDateTime
//import java.time.format.DateTimeFormatter
//
//// Data class to hold the individual components
//data class DateTimeComponents(
//    val day: String,
//    val month: String,
//    val year: String,
//    val dayOfWeek: String,
//    val time: String // Includes hours, minutes, and seconds
//)
//
//// Function to get the date and time components
//fun getDateTimeComponents(): DateTimeComponents {
//    val now = LocalDateTime.now()
//    // Format each part of the date and time
//    val day = now.format(DateTimeFormatter.ofPattern("dd")) // E.g., "24"
//    val month = now.format(DateTimeFormatter.ofPattern("MMM")) // E.g., "Nov"
//    val year = now.format(DateTimeFormatter.ofPattern("yyyy")) // E.g., "2024"
//    val dayOfWeek = now.format(DateTimeFormatter.ofPattern("EEEE")) // E.g., "Sunday"
//    val time = now.format(DateTimeFormatter.ofPattern("hh:mm:ss a")) // Includes seconds, e.g., "03:26:45 PM"
//
//    // Return the components in a data class
//    return DateTimeComponents(
//        day = day,
//        month = month,
//        year = year,
//        dayOfWeek = dayOfWeek,
//        time = time // Updated to include seconds
//    )
//}

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class DateTimeComponents(
    val day: String,
    val month: String,
    val year: String,
    val dayOfWeek: String,
    val time: String
)

fun getDateTimeComponents(): DateTimeComponents {
    val now = Clock.System.now()
    val localDateTime = now.toLocalDateTime(TimeZone.currentSystemDefault())

    return DateTimeComponents(
        day = localDateTime.dayOfMonth.toString().padStart(2, '0'),
        month = localDateTime.month.name.take(3), // Gets first 3 letters of month name
        year = localDateTime.year.toString(),
        dayOfWeek = localDateTime.dayOfWeek.name, // Gets full day name
        time = "${localDateTime.hour.toString().padStart(2, '0')}:" +
                "${localDateTime.minute.toString().padStart(2, '0')}:" +
                "${localDateTime.second.toString().padStart(2, '0')}"
    )
}
