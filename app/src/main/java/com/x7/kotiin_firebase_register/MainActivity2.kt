package com.x7.kotiin_firebase_register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.x7.kotiin_firebase_register.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        title="Register"
        firebaseAuth= FirebaseAuth.getInstance()

        binding.apply {
         buttonregister.setOnClickListener {
             progressbarregister.visibility= View.VISIBLE
             firebaseAuth.createUserWithEmailAndPassword(edittexregtemail.text.toString(),edittextregpassword.text.toString()).addOnCompleteListener {
                 if (it.isSuccessful){
                     progressbarregister.visibility=View.GONE
                     textviewregisterchek.text="User has register succesfully"

                 }else{
                     progressbarregister.visibility=View.GONE
                     textviewregisterchek.text="Error"
                 }
             }
         }

        }



    }
}