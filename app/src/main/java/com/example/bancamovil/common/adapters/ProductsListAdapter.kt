package com.example.bancamovil.common.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bancamovil.domain.interactors.product.Product
import com.example.bancamovil.R
import kotlinx.android.synthetic.main.row_product_cardview.view.*
import org.koin.core.KoinApplication.Companion.init

class ProductsListAdapter(private val productList: List<Product>, private val context: Context):
    RecyclerView.Adapter<ProductsListAdapter.ProductsListHolder>() {

    private var product : Product?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListHolder {
        val itemBinding =
            LayoutInflater.from(context).inflate(R.layout.row_product_cardview, parent, false)
        return ProductsListHolder(itemBinding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductsListHolder, position: Int) {
        holder.adapterPosition
        product = productList[position]
        holder.bind(product!!)
    }

    inner class ProductsListHolder(private val itemBinding: View):
        RecyclerView.ViewHolder(itemBinding), View.OnClickListener {
            fun bind(product: Product){
                itemBinding.txtProductTitle.text = product.title
                itemBinding.txtProductAmount.text = product.amount
            }
            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
            }
            init {
                  itemBinding.setOnClickListener(this)
            }


    }

    interface ProductsAdapterListener{
        fun onRowItemClick(product: Product)
    }
}

