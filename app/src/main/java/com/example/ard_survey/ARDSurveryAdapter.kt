package com.example.ard_survey

import android.app.Activity
import android.content.Intent
import android.net.Uri
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
        val title: TextView
        val showType: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            videoLink = itemView.findViewById(R.id.linktextView)
            title = itemView.findViewById(R.id.titletextView)
            showType = itemView.findViewById(R.id.showtextView)

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
        holder.title.text= model.title
        holder.showType.text= model.showtype

//       holder.videoLink.setOnClickListener
        // this code open link by click
        holder.videoLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(model.videolink)

            context.startActivity(intent)
        }


    }

}