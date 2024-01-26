package com.example.hw_1_7.doors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw_1_7.databinding.FragmentDoorsBinding

class DoorsFragment : Fragment() {
    private lateinit var binding:FragmentDoorsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = DoorsAdapter()
        binding.doorsRecyclerView.adapter = adapter
    }
}