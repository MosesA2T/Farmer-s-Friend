package com.example.farmersfriend

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    lateinit var tvSignIn:TextView
    lateinit var registerText:TextView
    lateinit var edtFirstName: EditText
    lateinit var edtSecondName: EditText
    lateinit var edtEmail: EditText
    lateinit var edtPhone: EditText
    lateinit var edtPassword: EditText
    lateinit var btnRegister: Button
    lateinit var progress: ProgressDialog
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        tvSignIn = findViewById(R.id.mTvSignInLink)
        registerText = findViewById(R.id.mTvRegisterText)
        edtFirstName = findViewById(R.id.mEdtFirstName)
        edtSecondName = findViewById(R.id.mEdtSecondName)
        edtEmail = findViewById(R.id.mEdtEmail)
        edtPhone = findViewById(R.id.mEdtPhone)
        edtPassword = findViewById(R.id.mEdtPassword)
        btnRegister = findViewById(R.id.mBtnRegister)
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(this)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")

        tvSignIn.setOnClickListener{
            val i = Intent(this,LoginActivity::class.java)
            startActivity(i)
        }
        btnRegister.setOnClickListener {
            var fName = edtFirstName.text.toString().trim()
            var sName = edtSecondName.text.toString().trim()
            var phone = edtPhone.text.toString().trim()
            var email = edtEmail.text.toString().trim()
            var password = edtPassword.text.toString().trim()

            if (fName.isEmpty() || sName.isEmpty()|| phone.isEmpty()  || email.isEmpty() || password.isEmpty()){
                // message displayed for empty fields
                Toast.makeText(this, "Fill all inputs", Toast.LENGTH_SHORT).show()
            }else{
                //proceed to save data
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        var userData = User(fName,sName,email,phone,password,mAuth.currentUser!!.uid)
                        var ref = FirebaseDatabase.getInstance().getReference().child("Users/"+mAuth.currentUser!!.uid)
                        ref.setValue(userData)
                        Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show()
                        mAuth.signOut()
                        startActivity(Intent(this,LoginActivity::class.java))
                        finish()
                    }
                }
            }


        }

        tvSignIn.setOnClickListener{
            val i = Intent(this,LoginActivity::class.java)
            startActivity(i)
        }
    }
}