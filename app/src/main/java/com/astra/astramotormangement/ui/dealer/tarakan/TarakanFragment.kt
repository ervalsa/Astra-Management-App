package com.astra.astramotormangement.ui.dealer.tarakan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.astra.astramotormangement.R
import com.astra.astramotormangement.databinding.FragmentTarakanBinding
import com.astra.astramotormangement.model.Dealer
import com.astra.astramotormangement.ui.dealer.berau.BerauAdapter

class TarakanFragment : Fragment(), TarakanAdapter.ItemAdapterCallback {

    private var _binding: FragmentTarakanBinding? = null
    private val binding get() = _binding!!

    private var menuArrayList: ArrayList<Dealer> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTarakanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyDealer()

        val adapter = TarakanAdapter(menuArrayList, this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvDealerTarakn.layoutManager = layoutManager
        binding.rvDealerTarakn.adapter = adapter
    }

    private fun initDummyDealer() {
        menuArrayList = ArrayList()
        menuArrayList.add(Dealer("ASTRA MOTOR - TARAKAN"))
        menuArrayList.add(Dealer("MOTOR MEGA TANO"))
    }

    override fun onClick(v: View, data: Dealer) {
        Toast.makeText(
            context,
            "Dealer ${data.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}