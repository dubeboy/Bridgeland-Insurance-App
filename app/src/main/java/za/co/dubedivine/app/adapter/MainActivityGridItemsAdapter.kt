package za.co.dubedivine.app.adapter

import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
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

    class GridItemVH(v: View) : RecyclerView.ViewHolder(v) {
        val imageView: ImageView = v.findViewById(R.id.image_view)
        val tvName: TextView = v.findViewById(R.id.tv_item_name)
        val constraintLayout: ConstraintLayout = v.findViewById(R.id.item_grid_constraint)
        fun bind(name: String) {
            tvName.text = name
            when (name) {
                "Finance" -> {
                    imageView.setImageResource(R.drawable.ic_finance)

                }
                "Auto" -> {
                    imageView.setImageResource(R.drawable.ic_automobile)
                    itemView.setOnClickListener({
                        itemView.context.startActivity(AutoActivity.getStartActivity(itemView.context))
                    })
                }
                "Home" -> {
                    imageView.setImageResource(R.drawable.ic_house2)
                    itemView.setOnClickListener({
                        itemView.context.startActivity(HomeActivity.getStartActivity(itemView.context))
                    })
                }
                "Business" -> {
                    imageView.setImageResource(R.drawable.ic_office_building)
                }
                "Life & Health" -> {
                    imageView.setImageResource(R.drawable.ic_heart)
                }
                "Travel" -> {
                    imageView.setImageResource(R.drawable.ic_travel)
                }
                "My Account" -> {
                    imageView.setImageResource(R.drawable.ic_insurance)
                }
                "Quote" -> {
                    imageView.setImageResource(R.drawable.ic_qoute)
                    constraintLayout.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.my_material_green))
                }
                "Share App" -> {
                    imageView.setImageResource(R.drawable.ic_share)
                }
                "Payments" -> {
                    imageView.setImageResource(R.drawable.ic_pay)
                }

                "Messaging" -> {
                    imageView.setImageResource(R.drawable.ic_msg)
                }

                "Claims" -> {
                    imageView.setImageResource(R.drawable.ic_claim)
                }


            }
        }
    }

    companion object {
        private val itemNames: ArrayList<String> = arrayListOf("Finance",
                "Auto",
                "Home",
                "Travel",
                "Business",
                "Life & Health",
                "My Account",
                "Payments",
                "Quote",
                "Share App",
                "Messaging",
                "Claims"
        )
    }
}