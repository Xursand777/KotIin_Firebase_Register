package com.x7.kotiin_firebase_register

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.x7.kotiin_firebase_register.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var firebaseAuth:FirebaseAuth
    var savedtext:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title="Login"
        var text=""
        firebaseAuth= FirebaseAuth.getInstance()
        //load
        load()

       binding.apply {

           textviewforregister.setOnClickListener{
            startActivity(Intent(this@MainActivity,MainActivity2::class.java))
           }
           buttonlogin.setOnClickListener {
               progressbarlogin.visibility= View.VISIBLE
               firebaseAuth.signInWithEmailAndPassword(edittextemail.text.toString(),edittextpassword.text.toString()).addOnCompleteListener {
                   if (it.isSuccessful){
                       progressbarlogin.visibility=View.GONE
                       //save
                       save(edittextemail.text.toString())
                      val intent= Intent(this@MainActivity,MainActivity3::class.java)
                       intent.putExtra("email",edittextemail.text.toString())
                       startActivity(intent)

                   }else{
                       if (text <"8"){
                           edittextpassword.setError("8 ta dan kam")
                       }else{
                           edittextemail.setError("Error")
                           edittextpassword.setError("Error")
                       }
                       progressbarlogin.visibility=View.GONE


                   }
               }
           }


       }

    }


    fun save(text: String?) {
        val editor = getSharedPreferences("Xursand", MODE_PRIVATE).edit() as SharedPreferences.Editor
        editor.putString("X7", text)
        editor.commit()
    }

    fun load() {
        val sharedPreferences = getSharedPreferences("Xursand", MODE_PRIVATE)
        savedtext = sharedPreferences.getString("X7", null)
        if (savedtext!=null){
            val intent=Intent(this@MainActivity,MainActivity3::class.java)
            intent.putExtra("email",savedtext)
            startActivity(intent)
        }


    }
}