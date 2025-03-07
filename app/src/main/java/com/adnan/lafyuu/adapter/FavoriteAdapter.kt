package com.adnan.lafyuu.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adnan.lafyuu.ProductDetailActivity
import com.adnan.lafyuu.R
import com.adnan.lafyuu.data.ItemData

class FavoriteAdapter(val context: Context, val itemList: List<ItemData>) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.ProductImage)
        val productName: TextView = view.findViewById(R.id.ProductName)
        val productPrice: TextView = view.findViewById(R.id.ProductPrice)
        val deleteIcon: ImageView = view.findViewById(R.id.delete_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.productImage.setImageResource(item.imageId)
        holder.productName.text = item.name
        holder.productPrice.text = item.price

        // Handle item click
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("product_name", item.name)
            intent.putExtra("product_price", item.price)
            intent.putExtra("product_image", item.imageId)
            context.startActivity(intent)
        }

        // Handle delete icon click
        holder.deleteIcon.setOnClickListener {
            // Implement the deletion logic here
        }
    }

    override fun getItemCount() = itemList.size
}
