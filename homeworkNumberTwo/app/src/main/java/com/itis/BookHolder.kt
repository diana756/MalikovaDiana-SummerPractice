package com.itis.homeworknumbertwo

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.itis.homeworknumbertwo.databinding.ItemBookBinding

class BookHolder(
    private val binding: ItemBookBinding,
    private val onClick: (Book) -> Unit,
) : ViewHolder(binding.root) {

    fun onBind(book: Book) {
        binding.run {
            tvBookName.text = book.name
            tvAuthor.text = book.author

            Glide.with(itemView.context)
                .load(book.url)
                .into(ivImage)
            root.setOnClickListener {
                onClick(book)
            }
        }
    }
}