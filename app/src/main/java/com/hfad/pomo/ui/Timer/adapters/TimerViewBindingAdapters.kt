package com.hfad.pomo.ui.Timer.adapters

import androidx.databinding.BindingAdapter
import com.hfad.pomo.ui.Timer.TimerView


object TimerViewBindingAdapters {

    @JvmStatic
    @BindingAdapter("timerSecondsPassed")
    fun updateTimeBindingAdapter(timerView: TimerView, timerSecondsPassed: Long) {
        timerView.updateTime(timerSecondsPassed)
    }

    @JvmStatic
    @BindingAdapter("stopTimer")
    fun stopTimeBindingAdapter(timerView: TimerView, isTimerStopped: Boolean) {
        if (isTimerStopped) {
            timerView.stopTimer()
        }
    }

    @JvmStatic
    @BindingAdapter("pauseTimer")
    fun pauseTimeBindingAdapter(timerView: TimerView, isTimerPaused: Boolean) {
        timerView.pauseTimer(isTimerPaused)
    }
}