package com.harshit.quantumAssessment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.harshit.quantumAssessment.R
import com.harshit.quantumAssessment.databinding.ParentItemsBinding
import com.harshit.quantumAssessment.pojo.entities.ArticleWrapper
import com.harshit.quantumAssessment.ui.home.HomeViewModel
import com.harshit.quantumAssessment.utils.DiffUtilParent

class ParentAdapter : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    private var categoryList: List<ArticleWrapper> = listOf()
    lateinit var homeViewModel: HomeViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ParentItemsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.parent_items, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    fun update(updated: List<ArticleWrapper>?) {
        val old = categoryList
        categoryList = updated ?: listOf()
        DiffUtil.calculateDiff(DiffUtilParent(old, categoryList)).dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: ParentItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currentCategory: ArticleWrapper) {
            binding.item = currentCategory
            binding.viewModel = homeViewModel
            binding.executePendingBindings()
        }

    }
}