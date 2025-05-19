package com.example.final_assesment_bishal_s4679860.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.final_assesment_bishal_s4679860.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Getting values from my adapter
        val species = intent.getStringExtra("species")
        val scientificName = intent.getStringExtra("scientificName")
        val habitat = intent.getStringExtra("habitat")
        val diet = intent.getStringExtra("diet")
        val conservationStatus = intent.getStringExtra("conservationStatus")
        val averageLifespanText = intent.getStringExtra("averageLifespan")
        val description = intent.getStringExtra("description")
        val imageResId = intent.getIntExtra("imageResId", 0)

        // Find views and set data
        val speciesTextView: TextView = findViewById(R.id.species)
        val scientificNameTextView: TextView = findViewById(R.id.scientific_name)
        //val lifespanTextView: TextView = findViewById(R.id.averageLifespan)
        val conservationStatusTextView: TextView = findViewById(R.id.conservationStatus)
        val dietTextView: TextView = findViewById(R.id.diet)
        val descriptionTextView: TextView = findViewById(R.id.animal_description)
        val imageView: ImageView = findViewById(R.id.animal_image)
        val backButton: TextView = findViewById(R.id.back_button)

        //Setting the values to their corresponding views
        speciesTextView.text = species
        scientificNameTextView.text = "Scientic Name: $scientificName"
        conservationStatusTextView.text = "Conservation Status: $conservationStatus"
        dietTextView.text = "Diet: $diet"
        descriptionTextView.text = description

        imageView.setImageResource(0) // Clear previous image
        imageView.setBackgroundResource(0) // Clear any background
        imageView.setImageResource(imageResId)

        if (imageResId == R.drawable.img1) {
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER

        } else {
            // Set the default scaleType for other images
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP

        }


        backButton.setOnClickListener {
            val intent = Intent(this@DetailActivity, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
