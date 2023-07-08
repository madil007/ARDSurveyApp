package com.example.ard_survey

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ard_survey.model.DisplayModel
import com.example.ard_survey.model.ModelResponse

class ARDSurveryAdapter(
    private val context: Activity,
    private val list: MutableList<DisplayModel>
) : RecyclerView.Adapter<ARDSurveryAdapter.ContentViewHolder>() {

    inner class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView
        val videoLink: TextView


        init {

            imageView = itemView.findViewById(R.id.imageView)
            videoLink = itemView.findViewById(R.id.linktextView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view =
            LayoutInflater.from(context)
                .inflate(R.layout.api_item_layout, parent, false)
        return ContentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val model = list[position]
        Glide.with(context)
            .load(model.imageurl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageView)

        holder.videoLink.text= model.videolink
//
//        for (i in 0 until model.items?.size!!) {
////            Log.d("imageUrlll", response.items[i]?.publisher?.institution?.imageURL.toString())
//
//
//        }

//        for (i in 0 until model.items?.get(position)?.publisher?.institution.imageURL!!) {

         //   println(model.items?.get(position)?.images?.get(i)?.url)
     //   }

//        holder.ownerName.text = model.items?.get(position)?.publisher?.imageURL
//        holder.ownerCity.text = hostelModel.city

    }

}