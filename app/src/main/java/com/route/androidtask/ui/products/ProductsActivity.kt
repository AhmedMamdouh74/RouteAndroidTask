package com.route.androidtask.ui.products

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.route.androidtask.databinding.ActivityProductsBinding
import com.route.androidtask.ui.common.customviews.ProgressDialog
import com.route.androidtask.ui.showSnakeBarError
import com.route.domain.common.ResultWrapper
import com.route.domain.model.ProductsItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {
    private val productsViewModel: ProductsViewModel by viewModels()
    private val productsAdapter = ProductsAdapter()
    private val progressDialog by lazy { ProgressDialog.createProgressDialog(this) }
    private var _binding: ActivityProductsBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initViews()
    }

    private fun initViews() {
        binding.recyclerView.adapter = productsAdapter
        binding.swipeRefreshLayout.setOnRefreshListener {
            productsViewModel.getProducts()
        }
    }

    private fun initViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                productsViewModel.productsState.collect {
                    renderProductsState(it)
                }
            }
        }

    }

    private fun renderProductsState(state: ResultWrapper<List<ProductsItem?>?>) {
        when (state) {
            is ResultWrapper.Error -> {



                 progressDialog.dismiss()
                binding.swipeRefreshLayout.isRefreshing = false
                binding.root.showSnakeBarError(state.error.localizedMessage ?: "")
            }

            is ResultWrapper.Loading -> {

                binding.swipeRefreshLayout.isRefreshing = false
                   progressDialog.show()
            }

            is ResultWrapper.Success -> {

                    progressDialog.dismiss()
                bindsProducts(state.data)
                binding.swipeRefreshLayout.isRefreshing = false

            }

            else -> {}
        }
    }

    private fun bindsProducts(data: List<ProductsItem?>?) {
        productsAdapter.bindProducts(data!!)

    }

    companion object {
        const val TAG = "ProductsActivity"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
