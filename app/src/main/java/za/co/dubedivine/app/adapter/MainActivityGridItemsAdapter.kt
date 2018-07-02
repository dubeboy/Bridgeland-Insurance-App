package za.co.dubedivine.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import za.co.dubedivine.app.AutoActivity
import za.co.dubedivine.app.R

class MainActivityGridItemsAdapter : RecyclerView.Adapter<MainActivityGridItemsAdapter.GridItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridItemVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid,
                parent,
                false)
        return GridItemVH(view)
    }

    override fun getItemCount(): Int = itemNames.size

    override fun onBindViewHolder(holder: GridItemVH, position: Int) {
        holder.bind(itemNames[position])
    }

    class GridItemVH(v: View): RecyclerView.ViewHolder(v) {
        val imageView: ImageView = v.findViewById(R.id.image_view)
        val tvName: TextView = v.findViewById(R.id.tv_item_name)
        fun bind(name: String) {
            tvName.text = name
            when (name) {
                itemNames[0] -> {
                    imageView.setImageResource(R.drawable.money)

                }
                itemNames[1] -> {
                    imageView.setImageResource(R.drawable.ic_car)
                    itemView.setOnClickListener({
                        itemView.context.startActivity(AutoActivity.getStartActivity(itemView.context))
                    })
                }
                itemNames[2] -> {
                    imageView.setImageResource(R.drawable.home)
                }
                itemNames[3] -> {
                    imageView.setImageResource(R.drawable.shop)
                }
                itemNames[4] -> {
                    imageView.setImageResource(R.drawable.heart)
                }
                itemNames[5] -> {
                    imageView.setImageResource(R.drawable.around)
                }
                itemNames[6] -> {
                    imageView.setImageResource(R.drawable.account)
                }
                itemNames[7] -> {
                    imageView.setImageResource(R.drawable.quote)
                    itemView.background = itemView.context.getDrawable(R.drawable.side_nav_bar);
                }
                itemNames[8] -> {
                    imageView.setImageResource(R.drawable.share_outlined_button)
                }
                itemNames[9] -> {
                    imageView.setImageResource(R.drawable.pay)
                }

                itemNames[10] -> {
                    imageView.setImageResource(R.drawable.chat)
                }

                itemNames[11] -> {
                    imageView.setImageResource(R.drawable.refund)
                }


            }
        }
    }

    companion object {
        val itemNames: ArrayList<String> = arrayListOf("Finance",
                "Auto",
                "Home",
                "Business",
                "Life & Health",
                "Travel",
                "My Account",
                "Quote",
                "ShareApp",
                "Payments",
                "Messaging",
                "Claims"
        )
    }
}