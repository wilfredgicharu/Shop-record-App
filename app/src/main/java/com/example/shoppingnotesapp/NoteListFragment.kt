package com.example.shoppingnotesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NoteListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview= view.findViewById<RecyclerView>(R.id.fragment_note_list_recyclerview)

        recyclerview.layoutManager= LinearLayoutManager(context)
        val adapter= NoteListAdapter(LayoutInflater.from(context))
        recyclerview.adapter= adapter

        val viewModel= ViewModelProvider(requireActivity(),object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return NoteListViewModel((requireActivity().application as NoteApplication).noreRepository) as T
            }
        }).get(NoteListViewModel::class.java)
        viewModel.getNoteListLiveData()
            .observe(viewLifecycleOwner, Observer{
                adapter.replaceItems(it)
            })
    }


}