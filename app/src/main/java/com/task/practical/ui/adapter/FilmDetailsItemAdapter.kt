package com.task.practical.ui.adapter

import android.view.View
import com.task.practical.R
import com.task.practical.base.BaseListAdapter
import com.task.practical.model.interfaces.FilmDetailsClickListener
import com.task.practical.model.response.FilmDetails

class FilmDetailsItemAdapter : BaseListAdapter<FilmDetails>() {
    private var filmDetailsClickListener: FilmDetailsClickListener? = null
    override fun getLayoutIdForType(viewType: Int): Int = R.layout.item_movie_details

    override fun onItemClick(view: View?, adapterPosition: Int) {
        filmDetailsClickListener?.onFilmDetailsItemClick(currentList[adapterPosition])
    }

    fun setOnFilmDetailsClickListener(filmDetailsClickListener: FilmDetailsClickListener) {
        this.filmDetailsClickListener = filmDetailsClickListener
    }
}