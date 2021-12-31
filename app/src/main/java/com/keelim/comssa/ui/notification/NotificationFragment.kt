package com.keelim.comssa.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearSnapHelper
import com.keelim.common.repeatCallDefaultOnStarted
import com.keelim.comssa.databinding.FragmentNotificationBinding
import com.keelim.comssa.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class NotificationFragment: Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    private val notificationAdapter by lazy {
        NotificationAdapter()
    }
    private val viewModel: NotificationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeState()
    }

    private fun initViews() = with(binding){
        val snap = LinearSnapHelper()
        notificationRecycler.apply {
            adapter = notificationAdapter
            snap.attachToRecyclerView(this)
        }
    }

    private fun observeState() = viewLifecycleOwner.repeatCallDefaultOnStarted {
        viewModel.state.collect {
            when(it){
                is NotificationState.UnInitialized -> loadingOn()
                is NotificationState.Loading -> {
                    requireContext().toast("로딩 중입니다.")
                }
                is NotificationState.Success -> {
                    loadingOff()
                    notificationAdapter.submitList(it.data)
                }
                is NotificationState.Error -> {
                    loadingOff()
                    requireContext().toast(it.message)
                }
            }
        }
    }

    private fun loadingOn() {
        binding.loading.visibility = View.VISIBLE
    }

    private fun loadingOff(){
        binding.loading.visibility = View.GONE
    }
}