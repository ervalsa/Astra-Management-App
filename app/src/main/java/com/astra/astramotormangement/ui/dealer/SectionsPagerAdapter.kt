package com.astra.astramotormangement.ui.dealer

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.astra.astramotormangement.ui.dealer.balikpapan.BalikpapanFragment
import com.astra.astramotormangement.ui.dealer.berau.BerauFragment
import com.astra.astramotormangement.ui.dealer.bulungan.BulunganFragment
import com.astra.astramotormangement.ui.dealer.nunukan.NunukanFragment
import com.astra.astramotormangement.ui.dealer.paser.PaserFragment
import com.astra.astramotormangement.ui.dealer.ppu.PpuFragment
import com.astra.astramotormangement.ui.dealer.tarakan.TarakanFragment

class SectionsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = BalikpapanFragment()
            1 -> fragment = BerauFragment()
            2 -> fragment = BulunganFragment()
            3 -> fragment = NunukanFragment()
            4 -> fragment = TarakanFragment()
            5 -> fragment = PpuFragment()
            6 -> fragment = PaserFragment()
        }

        return fragment as Fragment
    }

    override fun getItemCount(): Int {
        return 7
    }

}