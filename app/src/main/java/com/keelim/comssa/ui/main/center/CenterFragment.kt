/*
 * Designed and developed by 2021 keelim (Jaehyun Kim)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.keelim.comssa.ui.main.center

import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.keelim.comssa.data.model.main.center.centerData
import com.keelim.comssa.databinding.FragmentCenterBinding
import com.keelim.comssa.di.download.DownloadReceiver
import com.keelim.comssa.di.download.DownloadRequest
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CenterFragment : Fragment() {
    private var _binding: FragmentCenterBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var recevier: DownloadReceiver
    @Inject
    lateinit var downloadRequest: DownloadRequest
    private val centerAdapter by lazy {
        CenterAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCenterBinding.inflate(layoutInflater)
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

    private fun initViews() = with(binding) {
        opensource.setOnClickListener {
            startActivity(Intent(requireContext(), OssLicensesMenuActivity::class.java))
        }
        recyclerCenter.apply {
            adapter = centerAdapter.apply {
                submitList(centerData)
            }
        }
        btnDownload.setOnClickListener{
            downloadDatabase()
        }
    }

    private fun downloadDatabase(link: String? = null) {
        with(requireContext()){
            val downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            registerReceiver(recevier, IntentFilter().apply {
                addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
                addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED)
            })
            downloadManager.enqueue(
                downloadRequest.provideDownloadRequest(link)
            )
        }
    }
}
