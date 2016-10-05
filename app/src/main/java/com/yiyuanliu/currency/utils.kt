package com.yiyuanliu.currency

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

/**
 * Created by yiyuan on 2016/10/3.
 */
fun Float.toDisplayStr(): String {
    return String.format("%.2f", this)
}

fun ImageView.setCountry(country: String) {
    this.setImageResource(IconMap.getIcon(this.context, country))
}

fun Context.getAppTheme(): Int {
    val preference = this.getSharedPreferences("com.yiyuanliu.currency.theme", Context.MODE_PRIVATE)
    return preference.getInt("theme", 0)
}

fun AppCompatActivity.setAppTheme(theme: Int) {
    val preference = this.getSharedPreferences("com.yiyuanliu.currency.theme", Context.MODE_PRIVATE)
    preference.edit().putInt("theme", theme).apply()
    val intent = Intent(this, MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK))
    startActivity(intent)
}

fun AppCompatActivity.applyTheme() {
    val theme = this.getAppTheme()
    when(theme) {
        0 -> setTheme(R.style.AppTheme_Blue)
        1 -> setTheme(R.style.AppTheme_Red)
        2 -> setTheme(R.style.AppTheme_Teal)
        3 -> setTheme(R.style.AppTheme_Green)
    }
}