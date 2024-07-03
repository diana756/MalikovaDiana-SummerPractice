package com.itis.homeworknumbertwo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itis.homeworknumbertwo.databinding.FragmentContactsBinding

class ContactsFragment : Fragment(R.layout.fragment_contacts) {
    private var binding: FragmentContactsBinding? = null

    private var adapter: BookAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactsBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = BookAdapter(
            list = BookRepository.books,
            onClick = { book ->
                val bundle = Bundle()
                bundle.putInt("ID_TAG", book.id)
                findNavController().navigate(
                    R.id.action_contactsFragment_to_informationFragment,
                    args = bundle
                )
            }
        )

        binding?.run {
            rvBooks.adapter = adapter
            rvBooks.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}