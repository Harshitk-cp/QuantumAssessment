package com.harshit.quantumAssessment.utils

import androidx.recyclerview.widget.DiffUtil
import com.harshit.quantumAssessment.pojo.entities.Article
import com.harshit.quantumAssessment.pojo.entities.ArticleWrapper

class DiffUtilParent(
    private val oldList: List<ArticleWrapper>,
    private val newList: List<ArticleWrapper>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int =oldList.size

    override fun getNewListSize(): Int =newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].category == newList[newItemPosition].category
    }

}

class DiffUtilChild(
    private val oldList: List<Article>,
    private val newList: List<Article>
): DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].url == newList[newItemPosition].url
    }

}