package com.example.noteapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentAddBinding
import com.example.noteapp.viewmodels.AddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private val vm: AddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        binding.btnBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_addFragment_to_mainFragment)
        }
        binding.btnAddNote.setOnClickListener {
            if (binding.etAddTitle.text.isEmpty()) {
                binding.etAddTitle.error = "Field can`t be empty!"
            } else if (binding.etAddDescription.text.isEmpty()) {
                binding.etAddDescription.error = "Field can`t be empty!"
            } else {
                val title = binding.etAddTitle.text.toString()
                val desc = binding.etAddDescription.text.toString()
                vm.addNote(title, desc)
                Navigation.findNavController(view).navigate(R.id.action_addFragment_to_mainFragment)
            }
        }
    }
}