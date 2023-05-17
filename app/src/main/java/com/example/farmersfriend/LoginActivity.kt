package com.example.farmersfriend

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    lateinit var tvContinue:TextView
    @SuppressLint("MissingInflatedId")
    lateinit var tvRegister:TextView
    lateinit var progress: ProgressDialog
    lateinit var btnLogin:Button
    lateinit var mAuth: FirebaseAuth
    lateinit var edtEmail:EditText
    lateinit var edtPassword:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tvContinue = findViewById(R.id.mTvContinue)
        tvRegister = findViewById(R.id.mTvRegisterText)
        btnLogin = findViewById(R.id.mBtnLogin)
        edtEmail = findViewById(R.id.mEdtEmail)
        edtPassword = findViewById(R.id.mEdtPassword)
        mAuth = FirebaseAuth.getInstance()


        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")

        tvContinue.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        tvRegister.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
        btnLogin.setOnClickListener {
            var email = edtEmail.text.toString().trim()
            var password = edtPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()){
                // message displayed for empty fields
                Toast.makeText(this, "Fill all inputs", Toast.LENGTH_SHORT).show()
            }else{
                //proceed to save data
                progress.show()
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    progress.dismiss()
                    if (it.isSuccessful){
                        Toast.makeText(this, "User logged in successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                }
            }
        }

    }
}


