package com.itis.homeworknumbertwo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.itis.homeworknumbertwo.databinding.FragmentInformationBinding

class InformationFragment : Fragment(R.layout.fragment_information) {
    private var binding: FragmentInformationBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInformationBinding.bind(view)

        val id = arguments?.getInt(getString(R.string.id))
        val list = BookRepository.books

        var index: Int? = null
        var book: Book? = null

        for (i in list.indices) {
            if (id?.equals(list[i].id) == true) {
                index = i
            }
        }

        index?.let { book = list[it] }

        binding?.run {
            tvBookName.text = book?.name
            tvAuthor.text = getString(R.string.author).plus(book?.author)
            tvGenre.text = getString(R.string.genre).plus(book?.genre)
            tvInfo.text = getString(R.string.info).plus(book?.info)
            val urlRes = book?.url
            context?.let {
                Glide.with(it)
                    .load(urlRes)
                    .into(tvLogo)
                backButton.setOnClickListener {
                    findNavController().navigate(
                        R.id.action_informationFragment_to_contactsFragment
                    )
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}