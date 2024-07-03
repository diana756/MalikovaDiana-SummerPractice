package com.ranis.homeworknumbertwo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ranis.homeworknumbertwo.databinding.FragmentReceivingBinding

class ReceivingFragment : Fragment(R.layout.fragment_receiving)  {
    private var binding: FragmentReceivingBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReceivingBinding.bind(view)

        val text = arguments?.getString("ARG_TEXT") ?: "ERROR"

        binding?.run{
            tvTitle.text = text
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}