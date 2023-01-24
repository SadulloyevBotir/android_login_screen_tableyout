package com.example.android_login_screen_tableyout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var et_user_id: EditText? = null
    private var et_user_pw: EditText? = null
    private var bn_login: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initViews() {
        et_user_id = findViewById(R.id.et_user_id)
        et_user_pw = findViewById(R.id.et_user_pw)
        bn_login = findViewById(R.id.bn_login)

        et_user_id!!.requestFocus()

        et_user_pw!!.addTextChangedListener(loginTextWatcher)
        et_user_id!!.addTextChangedListener(loginTextWatcher)

        bn_login!!.setOnClickListener {
            //This part for task 3
            var userId = et_user_id!!.text.toString().trim()
            var userPassword = et_user_pw!!.text.toString().trim()
            var user = User(userId, userPassword)

            callSecondActivity(user)


        }


    }

    private var loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            var userId = et_user_id!!.text.toString().trim()
            var userPassword = et_user_pw!!.text.toString().trim()

            bn_login!!.isEnabled = userId.isNotEmpty() && userPassword.isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {

        }

    }

    //This part for task 3
    private fun callSecondActivity(user: User) {
        var intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

}