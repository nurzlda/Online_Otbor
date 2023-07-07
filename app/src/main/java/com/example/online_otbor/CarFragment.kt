package com.example.online_otbor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.online_otbor.databinding.FragmentCarBinding

class CarFragment : Fragment(), ItemClickListener {

    private lateinit var binding: FragmentCarBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val list = arrayListOf<CarModel>()
        list.add(
            CarModel(
                "https://www.shutterstock.com/image-illustration/almaty-kazakhstan-march-24-2019-260nw-1349013494.jpg",
                "Mercedes", "2003"
            )
        )
        list.add(
            CarModel(
                "https://img.freepik.com/free-photo/car-with-blue-orange-taillight-word-maserati-side_1340-37769.jpg",
                "Bmw", "2008"
            )
        )


        val carAdapter = CarAdapter(list, this)
        binding.rvCar.adapter = carAdapter
    }


    override fun itemClick() {
        findNavController().navigate(R.id.detailFragment)
    }


}