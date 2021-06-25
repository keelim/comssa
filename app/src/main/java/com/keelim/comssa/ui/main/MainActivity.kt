package com.keelim.comssa.ui.main

import android.app.DownloadManager
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.keelim.comssa.R
import com.keelim.comssa.data.db.entity.Search
import com.keelim.comssa.databinding.ActivityMainBinding
import com.keelim.comssa.extensions.toast
import com.keelim.comssa.provides.SuggestionProvider
import com.keelim.comssa.utils.DownloadReceiver
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import javax.inject.Inject
import timber.log.Timber

@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel:MainViewModel by viewModels()
    private val itemAdapter = MainAdapter(
        favoriteListener = { favorite, id ->
            viewModel.favorite(favorite, id)
        }
    )

    @Inject
    lateinit var recevier: DownloadReceiver

    private lateinit var downloadManager: DownloadManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()
        observeData()
        viewModel.fetchData()
        fileChecking()
    }

    private fun observeData() = viewModel.mainListState.observe(this){
        when(it){
            is MainListState.Error -> handleError()
            is MainListState.Loading -> handleLoading()
            is MainListState.Success -> handleSuccess(it.searchList)
            is MainListState.UnInitialized -> handleUnInitialized()
        }
    }

    private fun handleUnInitialized() {
        toast("데이터 로드 중입니다.")
    }

    private fun handleSuccess(data:List<Search>) {
        if (data.isEmpty()){
            toast("데이터 로드 중입니다.")
        }
        itemAdapter.submitList(data)
    }

    private fun handleLoading() {
        toast("로딩 중 입니다.")
    }

    private fun handleError() {
        toast("에러가 발생하였습니다. 재접속을 해주세요")
        Timber.e("에러 발생 지점")
    }

    private fun initViews() = with(binding){
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchSection.apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setIconifiedByDefault(false)
            setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.search(query.replace("\\s", ""))
                    return true
                }
                override fun onQueryTextChange(newText: String): Boolean {
                    return true
                }
            })
        }

        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                SearchRecentSuggestions(this@MainActivity, SuggestionProvider.AUTHORITY, SuggestionProvider.MODE)
                    .saveRecentQuery(query, null)
            }
        }

        recycler.adapter = itemAdapter
    }

    private fun fileChecking() {
        val check = File(getExternalFilesDir(null), "nanda.db")

        if (check.exists().not())
            databaseDownloadAlertDialog()
        else
            toast("데이터베이스가 존재합니다. 그대로 진행 합니다")
    }

    private fun databaseDownloadAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("다운로드 요청")
            .setMessage("어플리케이션 사용을 위해 데이터베이스를 다운로드 합니다.")
            .setPositiveButton("ok") { _, _ ->
                toast("서버로부터 데이터 베이스를 요청 합니다. ")
                downloadDatabase()
            }
            .show()

    }

    private fun downloadDatabase() {
        downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val intentFilter: IntentFilter = IntentFilter().apply {
            addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
            addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED)
        }
        registerReceiver(recevier, intentFilter)

        downloadManager.enqueue(
            DownloadManager.Request(Uri.parse(getString(R.string.db_path)))
                .setTitle("Downloading")
                .setDescription("Downloading Database file")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationUri(Uri.fromFile(File(getExternalFilesDir(null), "nanda.db")))
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)
        )
    }
}