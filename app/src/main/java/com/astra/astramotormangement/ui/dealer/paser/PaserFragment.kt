package com.astra.astramotormangement.ui.dealer.paser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.astra.astramotormangement.R
import com.astra.astramotormangement.data.Result
import com.astra.astramotormangement.data.response.dealer.DealerItem
import com.astra.astramotormangement.databinding.FragmentPaserBinding
import com.astra.astramotormangement.model.Dealer
import com.astra.astramotormangement.ui.dealer.DealerViewModel
import com.astra.astramotormangement.ui.dealer.berau.BerauAdapter
import com.astra.astramotormangement.utils.DEALER_BERAU_NAME
import com.astra.astramotormangement.utils.DEALER_PASER_NAME

class PaserFragment : Fragment(), PaserAdapter.ItemAdapterCallback {

    private var _binding: FragmentPaserBinding? = null
    private val binding get() = _binding!!

    private val dealerViewModel by viewModels<DealerViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaserBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PaserAdapter(this)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvDealerPaser.layoutManager = layoutManager
        binding.rvDealerPaser.adapter = adapter

        dealerViewModel.isLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }

        dealerViewModel.dealers(DEALER_PASER_NAME)
        dealerViewModel.listDealer.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {
                    showLoading(true)
                }

                is Result.Success -> {
                    adapter.submitList(result.data.listDealer)
                }

                is Result.Error -> {
                    Toast.makeText(requireContext(), "Ada kesalahan jaringan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.INVISIBLE
    }

    override fun onClick(v: View, data: DealerItem) {
        Toast.makeText(
            context,
            "Dealer ${data.name}",
            Toast.LENGTH_SHORT
        ).show()
    }
}