package com.vk.alphabittask.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vk.alphabittask.databinding.FragmentTransactionEventsBinding
import com.vk.alphabittask.presentation.adapters.TransactionEventAdapter
import com.vk.alphabittask.presentation.view_models.TransactionEventsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TransactionsEventsFragment : Fragment() {
    private var _binding: FragmentTransactionEventsBinding? = null
    private val binding: FragmentTransactionEventsBinding
        get() = _binding ?: throw RuntimeException("FragmentTransactionEventsBinding is null")

    private val viewModel : TransactionEventsViewModel by viewModel()
    lateinit var transactionEventAdapter : TransactionEventAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTransactionEventsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }


    private fun setupRecyclerView(){
        val rv = binding.rvTransactionEvents
        transactionEventAdapter = TransactionEventAdapter()
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = transactionEventAdapter
    }
}