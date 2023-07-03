package com.astra.astramotormangement.ui.dealer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.astra.astramotormangement.R
import com.astra.astramotormangement.databinding.FragmentDealerBinding
import com.astra.astramotormangement.utils.Utils
import com.google.android.material.tabs.TabLayoutMediator


class DealerFragment : Fragment() {

    private var _binding: FragmentDealerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDealerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        val tabs = binding.tabs.getChildAt(0) as ViewGroup
        for (i in 0 until tabs.childCount) {
            val tab = tabs.getChildAt(i)
            val layoutParams = tab.layoutParams as LinearLayout.LayoutParams
            layoutParams.marginEnd = Utils.dpToPx(8)
            tab.layoutParams = layoutParams
            binding.tabs.requestLayout()
        }
    }

    companion object {
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_balikpapan,
            R.string.tab_text_berau,
            R.string.tab_text_bulungan,
            R.string.tab_text_nunukan,
            R.string.tab_text_tarakan,
            R.string.tab_text_ppu,
            R.string.tab_text_paser,
        )
    }
}