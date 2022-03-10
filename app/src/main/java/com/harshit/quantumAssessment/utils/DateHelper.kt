package com.harshit.quantumAssessment.utils

import android.util.Log
import org.ocpsoft.prettytime.PrettyTime
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {
    private val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)

    fun formatDate(dateStr: String): String {
        return try {
            val date = inputFormat.parse(dateStr)
            val prettyTime = PrettyTime(Locale.ENGLISH)
            prettyTime.format(date)
        } catch (e: ParseException) {
            Log.e("PARSE", "ERROR", e)
            ""
        }

    }
}