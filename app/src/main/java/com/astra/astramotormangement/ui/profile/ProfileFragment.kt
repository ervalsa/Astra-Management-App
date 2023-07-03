package com.astra.astramotormangement.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.astra.astramotormangement.R
import com.astra.astramotormangement.databinding.FragmentDealerBinding
import com.astra.astramotormangement.databinding.FragmentProfileBinding
import com.astra.astramotormangement.ui.login.LoginActivity
import com.astra.astramotormangement.utils.UserPreference

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    lateinit var preference: UserPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preference = UserPreference(requireContext())

        binding.tvUserName.text = preference.getValues("nama")

        binding.btnLogout.setOnClickListener {
            preference.setValues("status", "0")

            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finishAffinity()
        }

    }
}