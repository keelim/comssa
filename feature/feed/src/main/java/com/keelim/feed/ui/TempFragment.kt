package com.keelim.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.keelim.feed.databinding.FragmentWriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TempFragment : Fragment() {
    private var _binding:FragmentWriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        fun newInstance(bundle: Bundle = bundleOf()): TempFragment = TempFragment().apply {
            arguments = bundle
        }
    }
}