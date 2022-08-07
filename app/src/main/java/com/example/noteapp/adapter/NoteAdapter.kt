package com.example.noteapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.NoteModelToUse
import com.example.noteapp.R
import com.example.noteapp.databinding.ItemListBinding

class NoteAdapter : ListAdapter<NoteModelToUse, NoteAdapter.Holder>(Comparator()) {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemListBinding.bind(view)
        fun bind(item: NoteModelToUse) {
            binding.itemTitle.text = item.title
            itemView.setOnClickListener {

                //
                val bundle = Bundle()
                bundle.putSerializable("note", item)
                Navigation.findNavController(itemView).navigate(R.id.action_mainFragment_to_detailsFragment, bundle)
            }
        }
    }
    class Comparator() : DiffUtil.ItemCallback<NoteModelToUse>() {
        override fun areItemsTheSame(oldItem: NoteModelToUse, newItem: NoteModelToUse): Boolean {
            return oldItem.equals(newItem)
        }

        override fun areContentsTheSame(oldItem: NoteModelToUse, newItem: NoteModelToUse): Boolean {
            return oldItem.equals(newItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}