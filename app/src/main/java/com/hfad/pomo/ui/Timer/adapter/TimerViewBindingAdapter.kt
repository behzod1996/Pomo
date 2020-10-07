package com.hfad.pomo.ui.Timer.adapter

import androidx.databinding.BindingAdapter
import com.hfad.pomo.ui.Timer.TimerView
import kotlin.concurrent.timer

object TimerViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("timerSecondPassed")
    fun updateTimeBindingAdapter(timerView: TimerView, timerSecondPassed: Long) {
        timerView.updateTime(timerSecondPassed)
    }

    @JvmStatic
    @BindingAdapter("stopTimer")
    fun stopTimerBindingAdapter(timerView: TimerView, isTimerStopped: Boolean) {
        if(isTimerStopped){
            timerView.stopTimer()
        }
    }

    @JvmStatic
    @BindingAdapter("pauseTimer")
    fun pauseTimerBindingAdapter(timerView: TimerView,isTimerPaused: Boolean) {
            timerView.pauseTimer(isTimerPaused)
    }
}