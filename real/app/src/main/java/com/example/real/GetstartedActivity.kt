package com.example.real

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_getstarted.*

class GetstartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getstarted)


        btn_login.setOnClickListener {
            val fungua=Intent(this,LoginActivity::class.java)
            startActivity(fungua)
        }

        btn_register.setOnClickListener {
            val reg=Intent(this,RegisterActivity::class.java)
            startActivity(reg)

        }
    }
}