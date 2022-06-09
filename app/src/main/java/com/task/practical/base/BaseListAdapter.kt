package com.task.practical.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.task.practical.BR

abstract class BaseListAdapter<T> :
    ListAdapter<T, BaseListAdapter<T>.BaseViewHolder>(BaseDiffUtilItemCallback<T>()) {
    private val itemTypeNormal = 1
    private val itemTypeLoader = 2

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(currentList[position], position)
    }

    override fun getItemViewType(position: Int): Int =
        if (isItemLoading(position)) itemTypeLoader else itemTypeNormal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutType: Int =
            if (viewType == itemTypeNormal) getLayoutIdForType(viewType)
            else getLayoutIdForLoading(viewType)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), layoutType, parent, false
        )
        return BaseViewHolder(binding)
    }

    /**
     * This fun is used to remove item from list
     * @param item T
     */
    fun removeItem(item: T) {
        currentList.remove(item)
    }

    /**
     * This fun is used to remove item from specific position
     * @param index Int
     */
    fun removeItem(index: Int) {
        currentList.removeAt(index)
    }

    /**
     * This class is used to get all data from adapter
     * @return ArrayList<T>
     */
    fun getListItem(position: Int): T {
        return (currentList[position])
    }

    /**
     * This class is used to get all data from adapter
     * @return ArrayList<T>
     */
    fun getListItems(): MutableList<T> = super.getCurrentList()

    /**
     * This fun is used to add item
     * @param item T
     */
    fun addItem(item: T) = currentList.add(item)

    /**
     * This fun is used to clear list
     */
    fun clearList() = currentList.clear()

    /**
     * This fun is used to get particular item is loading or not.
     * @param position Int
     * @return Boolean
     */
    open fun isItemLoading(position: Int): Boolean {
        return false
    }

    /**
     * This is abstract function used to get view type for adapter
     */
    abstract fun getLayoutIdForType(viewType: Int): Int

    /**
     * This fun is used to get layout for loader.
     * @param viewType Int
     * @return Int
     */
    open fun getLayoutIdForLoading(viewType: Int): Int {
        return 0
    }


    /**
     * This is abstract function used to get item click for all the adapter views
     */
    open fun onItemClick(view: View?, adapterPosition: Int) {}

    override fun getItemCount() = currentList.size

    /**
     * This fun is return loader item
     * @return T?
     */
    protected open fun getLoaderItem(): T? {
        return null
    }


    /**
     * This fun is used to add pagination loader.
     */
    fun addLoader() {
        if (!isLoading()) {
            val newList = ArrayList<T>(currentList)
            getLoaderItem()?.let { newList.add(it) }
        }
    }

    /**
     * This fun is used to pagination remove loader
     */
    fun removeLoader() {
        if (isLoading()) {
            if (currentList.isNotEmpty()) {
                val newList = ArrayList<T>(currentList)
                newList.remove(getLoaderItem())
            }
        }
    }

    /**
     * This fun is used to know item is loading or not.
     * @return Boolean
     */
    internal fun isLoading(): Boolean {
        return currentList.isEmpty() || isLastItemLoading()
    }

    /**
     * This fun is used to returns that last item is loading or not
     * @return Boolean
     */
    open fun isLastItemLoading(): Boolean {
        return false
    }

    /**
     * This is abstract function used to get set data for recycler list items.
     */
    open fun setDataForListItem(binding: ViewDataBinding, dataModel: T, position: Int) {
    }

    inner class BaseViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root), View.OnClickListener {
        /**
         * This function is used to bind recycler data particular row wise.
         */
        fun bind(dataModel: T, position: Int) {
            viewDataBinding.setVariable(BR.dataModel, dataModel)
            viewDataBinding.setVariable(BR.clickHandler, this)
            setDataForListItem(viewDataBinding, dataModel, position)
            viewDataBinding.executePendingBindings()
        }

        override fun onClick(v: View?) {
            onItemClick(v, adapterPosition)
        }
    }
}

