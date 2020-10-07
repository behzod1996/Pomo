package com.hfad.pomo.ui.Timer.adapter

import android.text.format.DateFormat.*
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.google.android.material.textfield.TextInputEditText
import java.util.*


/*
-https://codechacha.com/ko/kotlin-annotations/#:~:text=%40JvmStatic%20%EC%9D%80%20static%20%EB%B3%80%EC%88%98%EC%9D%98,%EC%9C%BC%EB%A1%9C%20%EB%A7%8C%EB%93%A4%EB%9D%BC%EB%8A%94%20%EC%9D%98%EB%AF%B8%EC%9E%85%EB%8B%88%EB%8B%A4.
 */
object TextViewBindingAdapter {

    //@JvmStatic 은 static 변수의 get/set 함수를 자동으로 만들라는 의미입니다
    //'BindingAdapter'는 'xml'에서 view 의 attribute 를 정의하고 로직을 작성하는데 쓰입니다. Android 의 기본 UI 들은 대부분 이미 정의된 BindingAdapter 가 있습니다
    @JvmStatic
    @BindingAdapter("timerSecondsPassed")
    fun updateTimerBindingAdapter(textView : TextView,date : Date?){
        if(date==null){
            return
        }

        val dateFormat = getDateFormat(textView.context.applicationContext)
        textView.text = dateFormat.format(date)

    }
    @JvmStatic
    @BindingAdapter(value = ["android:text", "android:textAttrChanged"], requireAll = false)
    fun updateIntValueBindingAdapter(textView: TextInputEditText, value : Int,attrChanged: InverseBindingListener){
        if(value!=0 && value.toString() != textView.text.toString()){
            textView.setText(value.toString())
        }
        textView.doAfterTextChanged {attrChanged.onChange()}
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "android:text")
    fun updateIntValueBindingAdapter(view: TextInputEditText) : Int {
        return if(view.text.isNullOrEmpty()) {
            0
        } else{
            view.text.toString().toInt()
        }
    }

    @JvmStatic
    @BindingAdapter(value=["android:text", "android:textAttrChanged"],requireAll = false)
    fun updateLongValueBindingAdapter(textView: TextInputEditText, value: Long, attrChanged: InverseBindingListener) {
        if(value != 0L && value.toString() != textView.text.toString()){
            textView.setText(value.toString())
        }
        textView.doAfterTextChanged { attrChanged.onChange() }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "android:text")
    fun updateLongValueBindingAdapter(view: TextInputEditText): Long {
        return if (view.text.isNullOrEmpty()) {
            0
        } else {
            view.text.toString().toLong()
        }
    }
}