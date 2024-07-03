package ru.itis.homework3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.homework3.databinding.ItemBookBinding

class BookAdapter(
    private val list: List<Book>,
    private val onClick: (Book) -> Unit,
) : RecyclerView.Adapter<BookHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookHolder = BookHolder(
        binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onClick = onClick
    )

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}