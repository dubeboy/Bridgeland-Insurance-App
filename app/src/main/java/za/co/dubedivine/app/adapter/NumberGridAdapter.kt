package za.co.dubedivine.app.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import za.co.dubedivine.app.R

class NumberGridAdapter(val btnClickCallback: (value: Int) -> Unit) :
        RecyclerView.Adapter<NumberGridAdapter.GridItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridItemViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_password_button, parent, false)
        return GridItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 12
    }

    override fun onBindViewHolder(holder: GridItemViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class GridItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val btn = view.findViewById<Button>(R.id.btn_password)
        fun bind(pos: Int) {
            btn.setOnClickListener(View.OnClickListener {
                Log.d("NumberGridAdapter", "Clicked $pos")
                when (pos) {
                    in (0..8) -> {
                        btnClickCallback(pos + 1)
                    }
                    9 -> {
                        btnClickCallback(-1)
                    }
                    10 -> {
                        btnClickCallback(0)
                    }
                    11 -> {
                        btnClickCallback(-2)
                    }
                }
            })

            when (pos) {
                in (0..8) -> {
                    btn.text = (pos + 1).toString()
                }
                9 -> {
//                    val drawable = itemView.context.resources.getDrawable(R.drawable.ic_backspace_black_24dp)
//                    btn.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null)
                    btn.text = "DEL"
                }
                10 -> {
                    btn.text = "0"

                }
                11 -> {
                    btn.text = "OK"
                }

            }
        }
    }

}