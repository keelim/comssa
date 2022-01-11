package com.keelim.comssa.ui.main.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.keelim.comssa.R
import com.keelim.comssa.databinding.FragmentSearchBinding
import com.keelim.comssa.provides.SuggestionProvider
import com.keelim.comssa.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment: Fragment() {
    private var _binding: FragmentSearchBinding? =null
    private val binding get() = _binding!!
    private val viewModel:SearchViewModel by viewModels()
    private val itemAdapter = SearchAdapter { favorite, id ->
            viewModel.favorite(favorite, id)
            requireContext().toast("관심 목록에 등록을 하였습니다.")
    }

    private var checked:String = ""
    private var queryed:String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() = with(binding){
        searchSection.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean = true
                override fun onQueryTextChange(query: String): Boolean  {
                    queryed = query.replace("\\s", "")
                    search2()
                    return true
                }
            })
        }

        if (Intent.ACTION_SEARCH == requireActivity().intent.action) {
            requireActivity().intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                SearchRecentSuggestions(
                    requireContext(),
                    SuggestionProvider.AUTHORITY,
                    SuggestionProvider.MODE
                )
                    .saveRecentQuery(query, null)
            }
        }

        val snap = LinearSnapHelper()
        recycler.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(requireContext())
            snap.attachToRecyclerView(this)
        }

        checkContainer.setOnCheckedChangeListener { group, id ->
            checked = when(id){
                R.id.chip_algorithms -> "알고리즘"
                R.id.chip_db -> "데이터베이스"
                R.id.chip_network -> "네트워크"
                R.id.chip_ds -> "자료구조"
                R.id.chip_os -> "운영체제"
                R.id.chip_android -> "안드로이드"
                R.id.chip_personality -> "인성"
                else -> ""
            }
            search2()
        }
    }

    private fun search2() = lifecycleScope.launch {
        viewModel.getContent(queryed, checked).collectLatest {
            itemAdapter.submitData(it)
        }
    }
}