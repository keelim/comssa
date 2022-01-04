package com.keelim.feed.ui.recommend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.keelim.feed.databinding.FragmentRecommendBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecommendFragment : Fragment() {
    private var _binding:FragmentRecommendBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecommendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstance(bundle: Bundle = bundleOf()): RecommendFragment = RecommendFragment().apply {
            arguments = bundle
        }
    }
}