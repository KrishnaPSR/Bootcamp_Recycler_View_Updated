package com.example.recyclermultiple1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MultiViewRecyclerAdapter(private val context: Context, private val listViewType: List<Int>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // to Create a companion object to identify the view
    companion object {
        const val TEXT_VIEW = 1
        const val IMAGE_VIEW = 2
        const val IMAGE_WITH_TEXT_VIEW = 3
    }
    class ViewHolderText(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.TextView)
    }
    class ViewHolderImage(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.ImageView2)
    }
    class ViewHolderImageWithText(view: View) : RecyclerView.ViewHolder(view) {
        val ImageTextView: TextView = view.findViewById(R.id.imageTextView)
        val imageView: ImageView = view.findViewById(R.id.ImageView)
    }
    override fun getItemViewType(position: Int): Int = listViewType[position]
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // Now , Create a new view, which defines the UI of the list item
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TEXT_VIEW -> ViewHolderText(inflater.inflate(R.layout.text, parent, false))
            IMAGE_VIEW -> ViewHolderImage(inflater.inflate(R.layout.image, parent, false))
            IMAGE_WITH_TEXT_VIEW -> ViewHolderImageWithText(inflater.inflate(R.layout.image_text, parent, false))
            else -> throw IllegalArgumentException("No ViewHolder")
        }
    }
    override fun getItemCount(): Int = listViewType.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(listViewType[position]) {
            TEXT_VIEW -> {
                val viewHolderText = holder as ViewHolderText
                viewHolderText.textView.text = context.getString(R.string.text)
            }
            IMAGE_VIEW -> {
                val viewHolderImage = holder as ViewHolderImage
                viewHolderImage.imageView.setImageResource(R.drawable.ttnimage)
            }
            IMAGE_WITH_TEXT_VIEW -> {
                val viewHolderImage = holder as ViewHolderImageWithText
                viewHolderImage.imageView.setImageResource(R.drawable.krish12)
                viewHolderImage.ImageTextView.text = context.getString(R.string.image_text)
            }
        }
    }
}