package com.ranis.homeworknumbertwo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ranis.homeworknumbertwo.databinding.FragmentContactsBinding

class ContactsFragment : Fragment(R.layout.fragment_contacts)  {
    private var binding: FragmentContactsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}