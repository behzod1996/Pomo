package com.hfad.pomo.ui.Timer.adapter

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton

object MaterialButtonBindingAdapter {

    @JvmStatic
    @BindingAdapter("backgroundTint")
    fun backgorundTintBindingAdapter(materialButton: MaterialButton, @ColorRes backgroundTint: Int){
        materialButton.backgroundTintList =
            ResourcesCompat.getColorStateList(materialButton.resources, backgroundTint, materialButton.context.theme)
    }

    @JvmStatic
    @BindingAdapter("icon")
    fun buttonIconBindingAdapter(materialButton: MaterialButton, icon: Drawable) {
        materialButton.icon = icon
    }
}