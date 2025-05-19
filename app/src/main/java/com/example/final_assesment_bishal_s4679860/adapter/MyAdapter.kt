package com.example.final_assesment_bishal_s4679860.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_assesment_bishal_s4679860.R
import com.example.final_assesment_bishal_s4679860.activities.DetailActivity
import com.example.final_assesment_bishal_s4679860.models.EntityDetails

class MyAdapter(private val imageList: List<Int>, private val entityList: List<EntityDetails>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.entityImageView)
        val entityTitle: TextView = itemView.findViewById(R.id.entity_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_entity_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])
        val entity = entityList.getOrNull(position)
        holder.entityTitle.text = entity?.species ?: "Unknown Title"

        // In MyAdapter class
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)

            //Pass animals details
            if (entity != null) {
                intent.putExtra("species", entity.species)
            }
            if (entity != null) {
                intent.putExtra("scientificName", entity.scientificName)
            }
            if (entity != null) {
                intent.putExtra("habitat", entity.habitat)
            }
            if (entity != null) {
                intent.putExtra("diet", entity.diet)
            }
            if (entity != null) {
                intent.putExtra("conservationStatus", entity.conservationStatus)
            }
            if (entity != null) {
                intent.putExtra("averageLifespan", entity.averageLifespan)
            }
            if (entity != null) {
                intent.putExtra("description", entity.description)
            }


            //Pass the image resource
            intent.putExtra("imageResId", imageList[position])

            // Start DetailActivity
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}
