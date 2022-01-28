package com.example.real

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_login.*
import java.util.jar.Manifest

class LoginActivity : AppCompatActivity() {
    private val REQUEST_IMAGE_GALLERY=132
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_editprofile.setOnClickListener {
            val edit=Intent(this,EditprofileActivity::class.java)
            startActivity(edit)
        }

        btn_accesproperty.setOnClickListener {
            val acces=Intent(this,AccespropertyActivity::class.java)
            startActivity(acces)
        }

        image_profile.setOnClickListener {
            val builder=AlertDialog.Builder(this)
            builder.setTitle("select image")
            builder.setMessage("choose your option")
            builder.setPositiveButton("Gallery", DialogInterface.OnClickListener { DialogInterface, i ->
                DialogInterface.dismiss()

                val intent=Intent(Intent.ACTION_PICK)
                intent.type="image/*"
                startActivityForResult(intent,REQUEST_IMAGE_GALLERY)
            })

            builder.setNegativeButton("camera", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()

                Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takepictureintent ->
                    takepictureintent.resolveActivity(packageManager)?.also {
                        val permission=ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA)

                    }



                }
            })

            val dialog:AlertDialog=builder.create()
            dialog.show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==REQUEST_IMAGE_GALLERY && resultCode==RESULT_OK && data!=null){
            image_profile.setImageURI(data.data)
        }
        else{
            Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
        }
    }
}