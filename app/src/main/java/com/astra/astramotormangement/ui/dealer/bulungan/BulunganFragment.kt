package com.astra.astramotormangement.ui.dealer.bulungan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.astra.astramotormangement.R
import com.astra.astramotormangement.databinding.FragmentBulunganBinding
import com.astra.astramotormangement.model.Dealer
import com.astra.astramotormangement.ui.dealer.berau.BerauAdapter

class BulunganFragment : Fragment(), BulunganAdapter.ItemAdapterCallback {

    private var _binding: FragmentBulunganBinding? = null
    private val binding get() = _binding!!

    private var menuArrayList: ArrayList<Dealer> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBulunganBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyDealer()

        val adapter = BulunganAdapter(menuArrayList, this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvDealerBulungan.layoutManager = layoutManager
        binding.rvDealerBulungan.adapter = adapter
    }

    private fun initDummyDealer() {
        menuArrayList = ArrayList()
        menuArrayList.add(Dealer("ASTRA MOTOR - TANJUNG SELOR"))
    }

    override fun onClick(v: View, data: Dealer) {
        Toast.makeText(
            context,
            "Dealer ${data.title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}