package com.example.bancamovil.ui.products

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bancamovil.data.common.PREF_USER_ID
import com.bancamovil.data.utils.PrefUtils
import com.bancamovil.domain.common.Resource
import com.bancamovil.domain.interactors.product.ProductRequest
import com.example.bancamovil.R
import com.example.bancamovil.common.adapters.ProductsListAdapter
import com.example.bancamovil.databinding.FragmentProductsBinding
import org.koin.android.ext.android.inject

class ProductsFragment: Fragment() {
    private val productsViewModel : ProductsViewModel by inject()
    private lateinit var binding : FragmentProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductsBinding.inflate(inflater)
        val root  = inflater.inflate(R.layout.fragment_products, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeProducts()

        //nav_view.visibility = View.VISIBLE

        getProducts()


    }

    private fun getProducts() {
        var userId = PrefUtils.getIntPreference(requireContext(), PREF_USER_ID)
        if (userId != 0)
            productsViewModel.getProducts(ProductRequest(userId!!))
        else
            Toast.makeText(requireContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    private fun observeProducts(){
        productsViewModel.viewState.observe(this) { state ->
            when (state) {
                is Resource.Loading -> {
                    binding.swipeRefreshLayout.isRefreshing = true
                }
                is Resource.Success -> {
                    if (state.data!!.isNotEmpty()) {
                        binding.swipeRefreshLayout.isRefreshing = false
                        val adapter = ProductsListAdapter(state.data!!, requireContext())
                        binding.recyclerProductsList.layoutManager = LinearLayoutManager(requireContext())
                        binding.recyclerProductsList.adapter = adapter
                    } else
                        Toast.makeText(
                            requireContext(),
                            "Ha ocurrido un error cargando productos",
                            Toast.LENGTH_LONG
                        ).show()
                }
                is Resource.Error -> {
                    Toast.makeText(
                        requireContext(),
                        "Ha ocurrido un error ${state.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}