package com.x7.kotiin_firebase_register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.x7.kotiin_firebase_register.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent=intent
        var email=intent.getStringExtra("email")
        title=email
        supportActionBar?.hide()

        val view=binding.navigationview1.getHeaderView(0)
        val textView:TextView=view.findViewById(R.id.textviewfromheader)
        textView.setOnClickListener {
            Toast.makeText(this@MainActivity3,"AppNameeee",Toast.LENGTH_SHORT).show()
        }

        binding.apply {
            textviewappname.text=email
            imageviewopennavigation.setOnClickListener {
             drawerlayout.openDrawer(Gravity.LEFT)
                textView.text=email
            }
        }

    }
}