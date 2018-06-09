package za.co.dubedivine.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import za.co.dubedivine.app.R

class MainActivityGridItemsAdapter : RecyclerView.Adapter<MainActivityGridItemsAdapter.GridItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridItemVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return GridItemVH(view)
    }

    override fun getItemCount(): Int = 8

    override fun onBindViewHolder(holder: GridItemVH, position: Int) {
        holder.bind(itemNames[position])
    }

    class GridItemVH(val v: View) : RecyclerView.ViewHolder(v) {
        val imageView: ImageView = v.findViewById(R.id.image_view)
        val tvName: TextView = v.findViewById(R.id.tv_item_name)
        fun bind(name: String) {
            tvName.text = name
            when (name) {
                itemNames[0] -> {
                    imageView.setImageResource(R.drawable.badge)
                }
                itemNames[1] -> {
                    imageView.setImageResource(R.drawable.bag)
                }
                itemNames[2] -> {
                    imageView.setImageResource(R.drawable.bankcar)
                }
                itemNames[3] -> {
                    imageView.setImageResource(R.drawable.gold1)
                }
                itemNames[4] -> {
                    imageView.setImageResource(R.drawable.gold2)
                }
                itemNames[5] -> {
                    imageView.setImageResource(R.drawable.money1)
                }
                itemNames[6] -> {
                    imageView.setImageResource(R.drawable.moneypi)
                }
                itemNames[7] -> {
                    imageView.setImageResource(R.drawable.bag2)
                }
                itemNames[8] -> {
                    imageView.setImageResource(R.drawable.badge)
                }
            }
        }
    }

    companion object {
        val itemNames: ArrayList<String> = arrayListOf("Finance",
                "Loan",
                "Best",
                "Bank",
                "Yes",
                "No",
                "Thando",
                "Tato",
                "Motto")
    }
}