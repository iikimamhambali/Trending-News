package com.android.trendingnews.view.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.trendingnews.data.entity.NewsList
import kotlinx.android.synthetic.main.layout_item_news.view.*

class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(items: NewsList) {
        with(itemView) {
            tvPublishDate.text = items.publishedDate
            tvTitle.text = items.title
            tvAbstract.text = items.abstract
            tvAuthor.text = items.byline
        }
    }
}