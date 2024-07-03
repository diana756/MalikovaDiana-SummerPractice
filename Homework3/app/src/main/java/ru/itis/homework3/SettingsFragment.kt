package ru.itis.homework3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.homework3.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings)  {
    private var binding: FragmentSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}