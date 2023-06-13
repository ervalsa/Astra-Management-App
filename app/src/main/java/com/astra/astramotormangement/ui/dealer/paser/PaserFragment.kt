package com.astra.astramotormangement.ui.dealer.paser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.astra.astramotormangement.R
import com.astra.astramotormangement.databinding.FragmentPaserBinding
import com.astra.astramotormangement.model.Dealer
import com.astra.astramotormangement.ui.dealer.berau.BerauAdapter

class PaserFragment : Fragment(), PaserAdapter.ItemAdapterCallback {

    private var _binding: FragmentPaserBinding? = null
    private val binding get() = _binding!!

    private var menuArrayList: ArrayList<Dealer> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaserBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyDealer()

        val adapter = PaserAdapter(menuArrayList, this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvDealerPaser.layoutManager = layoutManager
        binding.rvDealerPaser.adapter = adapter
    }

    private fun initDummyDealer() {
        menuArrayList = ArrayList()
        menuArrayList.add(Dealer("ASTRA MOTOR - TANAH GROGOT"))
        menuArrayList.add(Dealer("ASTRA MOTOR - SIMPANG PAIT"))
        menuArrayList.add(Dealer("PT. TUNAS DWIPA MATRA - TANAH GROGOT"))
    }

    override fun onClick(v: View, data: Dealer) {
        Toast.makeText(
            context,
            "Dealer ${data.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}