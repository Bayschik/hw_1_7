package com.example.hw_1_7.presentation.doors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.hw_1_7.base.BaseFragment
import com.example.hw_1_7.data.local.HomeDao
import com.example.hw_1_7.data.local.models.DoorData
import com.example.hw_1_7.databinding.FragmentDoorsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DoorsFragment : BaseFragment() {
    private lateinit var binding: FragmentDoorsBinding
    private val viewModel: DoorsViewModel by viewModels()
    private val adapter = DoorsAdapter()
    @Inject
    lateinit var dao: HomeDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.doorsRecyclerView.adapter = adapter

        if (dao.getDoorCount() == 0) {
            viewModel.getDoors().stateHandler(
                success = {
                    adapter.submitList(it.data)
                    val data = DoorData(
                        count = adapter.currentList.size
                    )
                    dao.insertDoorData(data)
                }
            )
        } else {
            binding.doorRefreshLayout.setOnRefreshListener {
                viewModel.getDoors().stateHandler(
                    success = {
                        adapter.submitList(it.data)
                    }
                )
                binding.doorRefreshLayout.isRefreshing = false
            }
        }

    }
}