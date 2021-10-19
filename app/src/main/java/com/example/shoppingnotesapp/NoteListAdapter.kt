package com.example.shoppingnotesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView

class NoteListAdapter(private val inflater: LayoutInflater): RecyclerView.Adapter<NoteListAdapter.NoteViewholder>() {

    private val notelist= mutableListOf<Note>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteListAdapter.NoteViewholder {
        return NoteViewholder(inflater.inflate(R.layout.view_note_item, parent, false))
    }

    override fun onBindViewHolder(holder: NoteListAdapter.NoteViewholder, position: Int) {
        holder.bind(notelist[position])
    }

    override fun getItemCount()= notelist.size

    fun replaceItems(notes: List<Note>){
        notelist.clear()
        notelist.addAll(notes)
        notifyDataSetChanged()

    }

    inner class NoteViewholder(containerView: View) : RecyclerView.ViewHolder(containerView){
        private val noteTextView: TextView= containerView.findViewById(R.id.view_note_list_text_view)

        fun bind(note: Note){
            noteTextView.text= note.text
        }

    }
}