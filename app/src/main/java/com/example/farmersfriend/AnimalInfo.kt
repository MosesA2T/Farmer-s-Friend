package com.example.farmersfriend

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class AnimalInfo : AppCompatActivity() {
    lateinit var ivAnimalImage: ImageView
    lateinit var tvName: TextView
    lateinit var tvDes: TextView
    lateinit var btnFood:Button
    lateinit var btnDiseases:Button
    lateinit var btnFacts:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        btnFood = findViewById(R.id.mBtnFood)
        btnDiseases = findViewById(R.id.mBtnDiseases)
        btnFacts = findViewById(R.id.mBtnFacts)
        ivAnimalImage = findViewById(R.id.mIvViewInfo)
        tvName = findViewById(R.id.mTvNameInfo)
        tvDes = findViewById(R.id.mTvDescriptionInfo)

        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("name")
        val des = bundle?.getString("des")
        val image = bundle?.getInt("image")

        image?.let {
            ivAnimalImage.setImageResource(it)
        }
        tvName.text = name
        tvDes.text = des

        btnFood.setOnClickListener{
            val i = Intent(this, FoodActivity::class.java)
            startActivity(i)
        }
        btnDiseases.setOnClickListener{
            val i = Intent(this, DiseasesActivity::class.java)
            startActivity(i)
        }
        btnFacts.setOnClickListener{
            val i = Intent(this, FactsActivity::class.java)
            startActivity(i)
        }
    }
}
