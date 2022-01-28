package com.example.real

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_accesproperty.*

class AccespropertyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accesproperty)


        btn_STK.setOnClickListener {
            val simToolkitLaunchIntent=this@AccespropertyActivity.packageManager.getLaunchIntentForPackage("com.android STK.")
            startActivity(simToolkitLaunchIntent)
        }

        btn_call.setOnClickListener {
            val int=Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"+254791787331"))
            if (ContextCompat.checkSelfPermission(
                    this@AccespropertyActivity,
                    android.Manifest.permission.CALL_PHONE
                )!=PackageManager.PERMISSION_GRANTED
            ) {
              ActivityCompat.requestPermissions(
                  this@AccespropertyActivity,
                  arrayOf(android.Manifest.permission.CALL_PHONE),
                  1

              )
            } else{
                startActivity(int)
            }

        }
    }
}