package za.co.dubedivine.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import za.co.dubedivine.app.AutoActivity
import za.co.dubedivine.app.HomeActivity
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
                    imageView.setImageResource(R.drawable.ic_finance)

                }
                itemNames[1] -> {
                    imageView.setImageResource(R.drawable.ic_automobile)
                    itemView.setOnClickListener({
                        itemView.context.startActivity(AutoActivity.getStartActivity(itemView.context))
                    })
                }
                itemNames[2] -> {
                    imageView.setImageResource(R.drawable.ic_house2)
                    itemView.setOnClickListener({
                        itemView.context.startActivity(HomeActivity.getStartActivity(itemView.context))
                    })
                }
                itemNames[3] -> {
                    imageView.setImageResource(R.drawable.ic_office_building)
                }
                itemNames[4] -> {
                    imageView.setImageResource(R.drawable.ic_heart)
                }
                itemNames[5] -> {
                    imageView.setImageResource(R.drawable.ic_travel)
                }
                itemNames[6] -> {
                    imageView.setImageResource(R.drawable.ic_insurance)
                }
                itemNames[7] -> {
                    imageView.setImageResource(R.drawable.ic_qoute)
                    itemView.background = itemView.context.getDrawable(R.drawable.side_nav_bar);
                }
                itemNames[8] -> {
                    imageView.setImageResource(R.drawable.ic_share)
                }
                itemNames[9] -> {
                    imageView.setImageResource(R.drawable.ic_pay)
                }

                itemNames[10] -> {
                    imageView.setImageResource(R.drawable.ic_msg)
                }

                itemNames[11] -> {
                    imageView.setImageResource(R.drawable.ic_claim)
                }


            }
        }
    }

    companion object {
      private val itemNames: ArrayList<String> = arrayListOf("Finance",
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