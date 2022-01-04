package com.keelim.feed.ui.feed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.keelim.comssa.data.model.feed.Feed
import com.keelim.feed.databinding.FragmentFeedBinding
import com.keelim.feed.ui.comment.CommentActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    private val feedAdapter by lazy {
        FeedAdapter {
            startActivity(Intent(requireContext(), CommentActivity::class.java).apply {
                putExtra("postId", it.postId)
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 혜빈 작업공간
        _binding = FragmentFeedBinding.inflate(layoutInflater)
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

    private fun initViews() = with(binding) {
        recyclerviewFeed.apply {
            adapter = feedAdapter.apply {
                feedList.addAll(
                    listOf(
                        Feed(
                            0,
                            0,
                            "title",
                            "contnet",
                            "date",
                            false,
                            true,
                            6,
                            6
                        ),
                        Feed(
                            1,
                            1,
                            "title1",
                            "contnet1",
                            "date1",
                            false,
                            true,
                            7,
                            8
                        ),
                        Feed(
                            2,
                            2,
                            "title2",
                            "contnet2",
                            "date2",
                            false,
                            true,
                            6,
                            6
                        )
                    )
                )
            }
        }
    }

    companion object{
        fun newInstance(bundle: Bundle = bundleOf()): FeedFragment = FeedFragment().apply {
            arguments = bundle
        }
    }
}
