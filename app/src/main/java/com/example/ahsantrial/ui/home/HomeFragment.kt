package com.example.ahsantrial.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.ahsantrial.data.entities.HomeItem
import com.example.ahsantrial.databinding.FragmentHomeBinding
import com.example.ahsantrial.ui.BaseFragment
import com.example.ahsantrial.ui.home.adapter.HomeAdapter
import com.example.ahsantrial.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    private var rootView: View? = null
    private lateinit var homeAdapter: HomeAdapter
    private val homeItemList = mutableListOf<HomeItem>()
    private val homeViewModel: HomeViewModel by viewModels()
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            homeViewModel.homeList.collectLatest {
                setData(it)
            }
        }
        lifecycleScope.launch {
            homeViewModel.loaderVisible.collectLatest {
                loaderVisibility(it)
            }
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)

        if (rootView == null) {
            binding = FragmentHomeBinding.inflate(inflater, container, false)
            rootView = binding.root

            initViews()
        }
        return rootView

    }

    private fun initViews() {
        initRecyclerView()

        getHomeDetails()


        binding.swipeLayout.setOnRefreshListener(OnRefreshListener { //Do your task
            getHomeDetails()
            binding.swipeLayout.isRefreshing = false
        })
    }


    private fun getHomeDetails() {
        when (count % 3) {
            0 -> {
                homeViewModel.getHomeOne()
            }
            1 -> {
                homeViewModel.getHomeTwo()
            }
            2 -> {
                homeViewModel.getHomeThree()
            }
        }
        count++
    }

    private fun initRecyclerView() {
        homeAdapter = HomeAdapter(requireContext(), homeItemList)

        binding.rcvHome.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    private fun setData(list: MutableList<HomeItem>) {
        homeItemList.clear()
        homeItemList.addAll(list)
        homeAdapter.notifyDataSetChanged()
    }

    private fun loaderVisibility(isVisible: Boolean) {
        binding.progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

}