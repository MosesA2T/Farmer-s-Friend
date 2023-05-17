package com.example.farmersfriend

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    var listOfAnimals = ArrayList<Animal>()
    var adapter: AnimalsAdapter? = null
    lateinit var listAnimal: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAnimal = findViewById(R.id.mListAnimal)
        // load animals
        listOfAnimals.add(Animal("Chicken", "Feathered assets that work the land, providing sustenance and livelihood. Chickens, with their efficient foraging, egg-laying prowess, and pest-controlling talents, are the reliable farm companions that bring productivity, self-sufficiency, and a touch of rural charm to the agricultural landscape.", R.drawable.chicken))
        listOfAnimals.add(Animal("Goats", "Agile grazers with mischievous charm, goats bring joy and sustenance to the farm. From their milk, fiber, and meat to their knack for clearing brush and their lively personalities, these spirited creatures are valuable contributors to the agricultural tapestry.", R.drawable.goat))
        listOfAnimals.add(Animal("Cows", "Majestic bovines that define the pastoral scene, cows are the epitome of farm life. Their milk, meat, and labor make them indispensable, while their gentle demeanor and rumbling moos create a serene ambiance. From dairy farms to cattle ranches, cows symbolize abundance and the essence of traditional agriculture.", R.drawable.cow))
        listOfAnimals.add(Animal("Sheep", "Woolly wonders that roam the pastures, sheep embody natural grace and valuable resources. With their wool for clothing, milk for nourishment, and meat for sustenance, these gentle grazers symbolize resilience and provide a sustainable livelihood for farmers.", R.drawable.sheepbackground))

        adapter = AnimalsAdapter(this, listOfAnimals)
        listAnimal.adapter = adapter
    }

    class AnimalsAdapter(private val context: Context, private val listOfAnimals: ArrayList<Animal>) : BaseAdapter() {

        override fun getCount(): Int {
            return listOfAnimals.size
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val myView = inflater.inflate(R.layout.view, null)

            val tvName = myView.findViewById<TextView>(R.id.mTvName)
            val tvDescription = myView.findViewById<TextView>(R.id.mTvDescription)
            val ivAnimal = myView.findViewById<ImageView>(R.id.mIvAnimal)

            tvName.text = animal.name
            tvDescription.text = animal.des
            animal.image?.let { ivAnimal.setImageResource(it) }
            ivAnimal.setOnClickListener {
                val intent = Intent(context,AnimalInfo::class.java )
                intent.putExtra("name",animal.name!!)
                intent.putExtra("des",animal.des!!)
                intent.putExtra("image",animal.image!!)
                context!!.startActivity(intent)
            }

            return myView
        }
    }
}
