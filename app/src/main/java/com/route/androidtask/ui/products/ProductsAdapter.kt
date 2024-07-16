package com.route.androidtask.ui.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.route.androidtask.databinding.ProductsItemBinding
import com.route.domain.model.ProductsItem

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {
    private val diffUtil = object : DiffUtil.ItemCallback<ProductsItem>() {
        override fun areItemsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductsItem, newItem: ProductsItem): Boolean {
            return oldItem == newItem
        }

    }

    private val asyncListDiffer = AsyncListDiffer(this, diffUtil)


    class ProductsViewHolder(private val itemBinding: ProductsItemBinding) :
        ViewHolder(itemBinding.root) {
        fun bind(productsItem: ProductsItem) {
            itemBinding.product = productsItem
            itemBinding.executePendingBindings()


            itemBinding.apply {
                Glide.with(itemView)
                    .load(productsItem.thumbnail)
                    .into(imageViewProduct)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemBinding =
            ProductsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(itemBinding)

    }

    override fun getItemCount() = asyncListDiffer.currentList.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val data = asyncListDiffer.currentList[position]
        holder.bind(data)
    }


    fun bindProducts(productsItem: List<ProductsItem?>?) {
        asyncListDiffer.submitList(productsItem)
    }

}