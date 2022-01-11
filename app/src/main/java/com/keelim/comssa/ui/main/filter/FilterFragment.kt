package com.keelim.comssa.ui.main.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.keelim.common.repeatCallDefaultOnStarted
import com.keelim.comssa.R
import com.keelim.comssa.databinding.FragmentFilterBinding
import com.keelim.comssa.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber

@AndroidEntryPoint
class FilterFragment: Fragment() {
    private var _binding: FragmentFilterBinding? =null
    private val binding get() = _binding!!
    private val viewModel:FilterViewModel by viewModels()
    private val itemAdapter = FilterAdapter { favorite, id ->
        viewModel.favorite(favorite, id)
        requireContext().toast("관심 목록에 등록을 하였습니다.")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() = with(binding){
        val snap = LinearSnapHelper()
        recycler.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(requireContext())
            snap.attachToRecyclerView(this)
        }
        checkContainer.setOnCheckedChangeListener { group, id ->
            when(id){
                R.id.chip_algorithms -> viewModel.filter("알고리즘")
                R.id.chip_db -> viewModel.filter("데이터베이스")
                R.id.chip_network -> viewModel.filter("네트워크")
                R.id.chip_ds -> viewModel.filter("자료구조")
                R.id.chip_os -> viewModel.filter("운영체제")
                R.id.chip_android -> viewModel.filter("안드로이드")
            }
        }
    }

    private fun observeState() = viewLifecycleOwner.repeatCallDefaultOnStarted {
        viewModel.state.collect {
            when(it){
                is FilterState.UnInitialized -> {
                    requireContext().toast("데이터가 많아 화면을 정리하고 있습니다.")
                }
                is FilterState.Error -> {
                    requireContext().toast("에러 입니다.")
                }
                is FilterState.Filtered -> Unit
                is FilterState.Loading -> {
                    requireContext().toast("로딩 중입니다.")
                }
                is FilterState.Success -> {
                    requireContext().toast("데이터 로딩 성공")
                    Timber.d("프래그먼트로 내려온 데이터 ${it.data}")
                    itemAdapter.submitList(it.data)
                }
            }
        }
    }
}