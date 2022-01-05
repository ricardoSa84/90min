package com.example.pp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pp.api.datamodels.Search

class MoviesAdapter :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private var dataSet: List<Search> = emptyList()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieTitle: TextView
        val movieYear: TextView
        val poster: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            movieTitle = view.findViewById(R.id.movieTitle)
            movieYear = view.findViewById(R.id.moviedate)
            poster = view.findViewById(R.id.poster)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.movie_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    fun setData(data: List<Search>) {
        dataSet = data
        notifyDataSetChanged()
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.movieTitle.text = dataSet[position].title
        viewHolder.movieYear.text = dataSet[position].year

        Glide
            .with(viewHolder.itemView.context)
            .load(dataSet[position].poster)
            .centerCrop()
            .into(viewHolder.poster);
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}