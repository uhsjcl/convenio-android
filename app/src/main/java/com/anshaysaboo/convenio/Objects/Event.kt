package com.anshaysaboo.convenio.Objects

import java.sql.Time
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

// Represents a scheduled convention Event
open class Event {
    var title: String? = null
    var location: String? = null
    var startTime: Date? = null
    var endTime: Date? = null
    var description: String? = null
    var type: String? = null

    constructor(title: String, startTime: Date, endTime: Date) {
        this.title = title
        this.startTime = startTime
        this.endTime = endTime
    }

    fun getTimeText(): String {
        val formatter = SimpleDateFormat("h:mm a")
        val startTimeString = formatter.format(startTime)
        val endTimeString = formatter.format(endTime)
        return startTimeString + " - " + endTimeString
    }
}