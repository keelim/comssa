package com.keelim.comssa.ui.main.bottom_sheet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.keelim.comssa.databinding.BottomSheetDialogBinding
import com.keelim.comssa.ui.favorite.FavoriteActivity
import com.keelim.comssa.utils.DownloadReceiver
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BottomSheetDialog: BottomSheetDialogFragment() {
    private var _binding : BottomSheetDialogBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var recevier: DownloadReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initViews() = with(binding){
        downloadButton.setOnClickListener {
//            databaseDownloadAlertDialog()
            startActivity(Intent(requireActivity(), FavoriteActivity::class.java))
        }
    }
}