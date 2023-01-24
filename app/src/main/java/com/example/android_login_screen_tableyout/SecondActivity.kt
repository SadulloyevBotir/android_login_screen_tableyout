package com.example.android_login_screen_tableyout

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
    }

    private fun initViews() {
        var tv_second = findViewById<TextView>(R.id.tv_second)
        var result = intent.getSerializableExtra("user")
        tv_second.setText(result.toString())
    }
}