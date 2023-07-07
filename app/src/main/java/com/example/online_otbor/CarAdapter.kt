package com.example.online_otbor


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.online_otbor.databinding.ItemCarBinding


class CarAdapter(
    private val list: ArrayList<CarModel>,
    private val listener: ItemClickListener
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(
            ItemCarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class CarViewHolder(val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(carModel: CarModel) {
            binding.tvName.text = carModel.name
            binding.tvYear.text = carModel.year
            Glide.with(binding.ivCar).load(carModel.iv).into(binding.ivCar)
            itemView.setOnClickListener {
                listener.itemClick()
            }
        }

    }

}