package za.co.dubedivine.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import za.co.dubedivine.app.R
import za.co.dubedivine.app.adapter.HomeAdapater.HomeViewHolder

class HomeAdapater : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid,
                parent,
                false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemNames.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(itemNames[position])
    }

    class HomeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val imageView: ImageView = v.findViewById(R.id.image_view)
        private val tvName: TextView = v.findViewById(R.id.tv_item_name)

        fun bind(s: String) {

            tvName.text = s

            when (s) {
                itemNames[0] -> {
                    imageView.setImageResource(R.drawable.ic_home_with_a_heart)
                }
                itemNames[1] -> {
                    imageView.setImageResource(R.drawable.ic_shopping_center)
                }
                itemNames[2] -> {
                    imageView.setImageResource(R.drawable.ic_house_contract)
                }
                itemNames[3] -> {
                    imageView.setImageResource(R.drawable.ic_for_rent)
                }
            }
        }
    }

    companion object {
        private val itemNames: ArrayList<String> = arrayListOf(
                "Homeowner",
                "Condo",
                "Tenant",
                "Rental Property"
        )
    }
}

