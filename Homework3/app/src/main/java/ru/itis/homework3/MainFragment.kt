package ru.itis.homework3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.homework3.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main)  {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentMainBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}