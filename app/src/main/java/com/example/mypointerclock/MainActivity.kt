package com.example.mypointerclock


import android.os.Bundle
import android.view.animation.Animation
import by.kirich1409.viewbindingdelegate.viewBinding
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.mypointerclock.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)


    private val clockManager = ClockManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.hourView.rotation = clockManager.getHourRotation()
        binding.minuteView.rotation = clockManager.getMinuteRotation()
        binding.secondView.rotation = clockManager.getSecondRotation()

        val rotateAnimation = RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        clockManager.startSecondHandAnimation(rotateAnimation)
        binding.secondView.startAnimation(rotateAnimation)

        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    clockManager.updateCalendar()
//                    timeView.text = clockManager.getCurrentTimeString()
                }
            }
        }, 0, 1000)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            binding.hourView.rotation = clockManager.getHourRotation()
            binding.minuteView.rotation = clockManager.getMinuteRotation()
            binding.secondView.rotation = clockManager.getSecondRotation()
        }
    }
}




