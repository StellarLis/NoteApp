package com.example.noteapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.domain.model.NoteModelToUse
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentDetailsBinding
import com.example.noteapp.viewmodels.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var currentNote: NoteModelToUse
    private val vm: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater)
        currentNote = arguments?.getSerializable("note") as NoteModelToUse
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        binding.tvTitleDetails.text = currentNote.title
        binding.tvDescDetails.text = currentNote.description
        binding.btnBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_detailsFragment_to_mainFragment)
        }
        binding.btnDelete.setOnClickListener {
            vm.delete(currentNote)
            Navigation.findNavController(view).navigate(R.id.action_detailsFragment_to_mainFragment)
            Toast.makeText(context, "Delete is successful", Toast.LENGTH_LONG).show()
        }
    }
}