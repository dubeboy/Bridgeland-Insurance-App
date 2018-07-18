package za.co.dubedivine.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.nav_header_main.view.*
import za.co.dubedivine.app.R

class AutoAdapter : RecyclerView.Adapter<AutoAdapter.AutoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid,
                parent,
                false)
        return AutoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemNames.size

    }

    override fun onBindViewHolder(holder: AutoViewHolder, position: Int) {
        holder.bind(itemNames[position])
    }

    class AutoViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val imageView: ImageView = v.findViewById(R.id.image_view)
        private val tvName: TextView = v.findViewById(R.id.tv_item_name)
        fun bind(s: String) {

            tvName.text = s

            when (s) {
                itemNames[0] -> {
                    imageView.setImageResource(R.drawable.ic_car_colored)

                }
                itemNames[1] -> {
                    imageView.setImageResource(R.drawable.ic_bike)
                }
                itemNames[2] -> {
                    imageView.setImageResource(R.drawable.ic_all_terrain_vehicle_motorbike)
                }
                itemNames[3] -> {
                    imageView.setImageResource(R.drawable.ic_snowmobile)
                }
                itemNames[4] -> {
                    imageView.setImageResource(R.drawable.ic_motorhome)
                }
                itemNames[5] -> {
                    imageView.setImageResource(R.drawable.ic_trailer_for_car)
                }
            }
        }

    }

    companion object {
        private val itemNames: ArrayList<String> = arrayListOf(
                "Auto",
                "Motocycle",
                "ATV",
                "Snowmobile",
                "Motorhome",
                "Trailers"
        )
    }
}