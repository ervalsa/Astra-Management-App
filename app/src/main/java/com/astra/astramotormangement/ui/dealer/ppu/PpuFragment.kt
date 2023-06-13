package com.astra.astramotormangement.ui.dealer.ppu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.astra.astramotormangement.R
import com.astra.astramotormangement.databinding.FragmentPpuBinding
import com.astra.astramotormangement.model.Dealer
import com.astra.astramotormangement.ui.dealer.berau.BerauAdapter

class PpuFragment : Fragment(), PpuAdapter.ItemAdapterCallback {

    private var _binding: FragmentPpuBinding? = null
    private val binding get() = _binding!!

    private var menuArrayList: ArrayList<Dealer> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPpuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyDealer()

        val adapter = PpuAdapter(menuArrayList, this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvDealerPpu.layoutManager = layoutManager
        binding.rvDealerPpu.adapter = adapter
    }

    private fun initDummyDealer() {
        menuArrayList = ArrayList()
        menuArrayList.add(Dealer("ASTRA MOTOR - PENAJAM"))
        menuArrayList.add(Dealer("PT. HARAPAN UTAMA - PETUNG"))
        menuArrayList.add(Dealer("PT. DAYA ANUGRAH MANDIRI - PENAJAM"))
    }

    override fun onClick(v: View, data: Dealer) {
        Toast.makeText(
            context,
            "Dealer ${data.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}