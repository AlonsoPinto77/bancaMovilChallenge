package com.example.bancamovil.common.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bancamovil.domain.interactors.product.Product
import com.example.bancamovil.databinding.RowProductCardviewBinding

class ProductsListAdapter(private val productList: List<Product>, private val context: Context) :
    RecyclerView.Adapter<ProductsListAdapter.ProductsListHolder>() {

    private var product: Product? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListHolder {
        val itemBinding =
            RowProductCardviewBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductsListHolder(itemBinding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductsListHolder, position: Int) {
        holder.adapterPosition
        product = productList[position]
        holder.bind(product!!)
    }

    inner class ProductsListHolder(private val itemBinding: RowProductCardviewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(product: Product) {
            itemBinding.txtProductTitle.text = product.title
            itemBinding.txtProductAmount.text = product.amount
        }
    }
}

