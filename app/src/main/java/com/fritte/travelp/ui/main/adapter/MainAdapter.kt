package com.fritte.travelp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fritte.travelp.R
import com.fritte.travelp.data.model.place.TravelPlace

class MainAdapter(private val context: Context?, private var places: List<TravelPlace>?, private var onClick: View.OnClickListener) :  RecyclerView.Adapter<MainAdapter.PlaceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        return PlaceHolder(LayoutInflater.from(context).inflate(R.layout.main_item_places, parent, false))
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.bind(places?.get(position))
        holder.itemView.tag = places?.get(position)
        holder.itemView.setOnClickListener(onClick)
    }

    override fun getItemCount(): Int {
        return places!!.size
    }

    class PlaceHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var tvTitle: TextView? = null
        private var tvDesc: TextView? = null

        init {
            tvTitle = view.findViewById(R.id.tvTitle)
            tvDesc  = view.findViewById(R.id.tvDesc)
        }

        fun bind(place: TravelPlace?) {
            tvTitle?.text = place?.city
            tvDesc?.text = place?.country
        }
    }
}