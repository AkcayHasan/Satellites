package com.akcay.satellite.base

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T : BaseModel, V : ViewBinding> :
    RecyclerView.Adapter<BaseViewHolder<V>>() {

    //protected lateinit var items: List<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<V> {
        val binding: V = createBinding(parent)
        return BaseViewHolder(binding)
    }

    abstract fun createBinding(parent: ViewGroup): V
    abstract fun bind(binding: V, item: T?, position: Int)
    //abstract fun setData(items: List<T>)

    var clickListener: (id: Int) -> Unit = {}

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: BaseViewHolder<V>, position: Int) {
        bind(holder.binding, differ.currentList[position], position)
    }

    private val differCallback = object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
            return oldItem == newItem
        }
    }

    // TODO: avoid memory leak
    val differ = AsyncListDiffer(this, differCallback)
}