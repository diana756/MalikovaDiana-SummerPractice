package com.ranis.homeworknumbertwo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ranis.homeworknumbertwo.databinding.FragmentSendingBinding

class SendingFragment : Fragment(R.layout.fragment_sending)  {
    private var binding: FragmentSendingBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSendingBinding.bind(view)

        binding?.run {
            button.setOnClickListener {
                if(editText.text.toString().isNotEmpty()){
                    val text = editText.text.toString()
                    val bundle = Bundle()
                    bundle.putString("ARG_TEXT", text)

                    findNavController().navigate(
                        R.id.action_sendingFragment_to_receivingFragment,
                        args = bundle
                    )
                }else{
                    Snackbar.make(view, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}