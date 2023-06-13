package com.astra.astramotormangement.ui.dealer.balikpapan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.astra.astramotormangement.R
import com.astra.astramotormangement.databinding.FragmentBalikpapanBinding
import com.astra.astramotormangement.model.Dealer

class BalikpapanFragment : Fragment(), BalikpapanAdapter.ItemAdapterCallback {

    private var _binding: FragmentBalikpapanBinding? = null
    private val binding get() = _binding!!

    private var menuArrayList: ArrayList<Dealer> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBalikpapanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyDealer()

        val adapter = BalikpapanAdapter(menuArrayList, this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvDealerBalikpapan.layoutManager = layoutManager
        binding.rvDealerBalikpapan.adapter = adapter
    }

    private fun initDummyDealer() {
        menuArrayList = ArrayList()
        menuArrayList.add(Dealer("ASTRA MOTOR - MT. HARYONO"))
        menuArrayList.add(Dealer("ASTRA MOTOR - SUDIRMAN"))
        menuArrayList.add(Dealer("ASTRA MOTOR - SEPINGGAN"))
        menuArrayList.add(Dealer("ASTRA MOTOR - KILO"))
        menuArrayList.add(Dealer("PT. HARAPAN UTAMA - KARANGJATI"))
        menuArrayList.add(Dealer("PT. HARAPAN UTAMA - DAMAI"))
        menuArrayList.add(Dealer("PT. HARAPAN UTAMA - RAJA MOTOR GUNUNG SARI"))
        menuArrayList.add(Dealer("PT. DAYA ANUGRAH MANDIRI - BALIKPAPAN"))
        menuArrayList.add(Dealer("PT. TUNAS DWIPA MATRA - BALIKPAPAN"))
        menuArrayList.add(Dealer("PT. NUSANTARA SURYA SAKTI - BALIKPAPAN"))
        menuArrayList.add(Dealer("CV. DAYA MAKMUR MANDIRI"))
    }

    override fun onClick(v: View, data: Dealer) {
        Toast.makeText(
            context,
            "Dealer ${data.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}