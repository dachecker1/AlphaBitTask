package com.vk.alphabittask.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.vk.alphabittask.databinding.FragmentTransactionEventsBinding
import com.vk.alphabittask.presentation.adapters.BaseViewHolder
import com.vk.alphabittask.presentation.adapters.IAdapterDelegate
import com.vk.alphabittask.presentation.adapters.ListItemPagedDelegateAdapter
import com.vk.alphabittask.presentation.adapters.TransactionEventAdapter
import com.vk.alphabittask.presentation.adapters.diffutils.ListItemModel
import com.vk.alphabittask.presentation.view_models.TransactionEventsViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TransactionsEventsFragment : Fragment() {
    private var _binding: FragmentTransactionEventsBinding? = null
    private val binding: FragmentTransactionEventsBinding
        get() = _binding ?: throw RuntimeException("FragmentTransactionEventsBinding is null")

    private val viewModel: TransactionEventsViewModel by viewModel()
    private var userEventsAdapter: ListItemPagedDelegateAdapter? =  null
    private var transactionAdapter: TransactionEventAdapter? = TransactionEventAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userEventsAdapter = ListItemPagedDelegateAdapter.Builder()
            .add(transactionAdapter as IAdapterDelegate<BaseViewHolder<ListItemModel>, ListItemModel>)
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTransactionEventsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTransactionEvents.adapter = userEventsAdapter
        subscribeViewModelEvents()
    }

    override fun onDestroy() {
        _binding = null
        userEventsAdapter = null
        transactionAdapter = null
        super.onDestroy()
    }

    private fun subscribeViewModelEvents() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.transactionEventsFlow.collectLatest { items ->
                userEventsAdapter?.submitData(items)
            }
        }
    }
}