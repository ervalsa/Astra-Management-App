package com.astra.astramotormangement.ui.dealer.nunukan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.astra.astramotormangement.R
import com.astra.astramotormangement.databinding.FragmentNunukanBinding
import com.astra.astramotormangement.model.Dealer
import com.astra.astramotormangement.ui.dealer.berau.BerauAdapter

class NunukanFragment : Fragment(), NunukanAdapter.ItemAdapterCallback {

    private var _binding: FragmentNunukanBinding? = null
    private val binding get() = _binding!!

    private var menuArrayList: ArrayList<Dealer> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNunukanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyDealer()

        val adapter = NunukanAdapter(menuArrayList, this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvDealerNunukan.layoutManager = layoutManager
        binding.rvDealerNunukan.adapter = adapter
    }

    private fun initDummyDealer() {
        menuArrayList = ArrayList()
        menuArrayList.add(Dealer("PT. NUSANTARA SURYA SAKTI - NUNUKAN"))
        menuArrayList.add(Dealer("DELAPAN JAYA"))
    }

    override fun onClick(v: View, data: Dealer) {
        Toast.makeText(
            context,
            "Dealer ${data.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}