package com.example.mypointerclock

import android.view.animation.Animation
import java.text.SimpleDateFormat
import java.util.*

class ClockManager {
    private var calendar: Calendar = Calendar.getInstance()

    fun getHourRotation(): Float {
        return ((calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE) / 60.0) * 30).toFloat()
    }

    fun getMinuteRotation(): Float {
        return (calendar.get(Calendar.MINUTE) * 6.0).toFloat()
    }

    fun getSecondRotation(): Float {
        return (calendar.get(Calendar.SECOND) * 6.0).toFloat()
    }

    fun getCurrentTimeString(): String {
        return SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
    }

    fun startSecondHandAnimation(animation: Animation) {
        animation.repeatCount = Animation.INFINITE
        animation.duration = 60000
    }

    fun updateCalendar() {
        calendar = Calendar.getInstance()
    }
}