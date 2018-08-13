package com.phoenixforcehq.onestopmovies.view.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phoenixforcehq.onestopmovies.R;
import com.phoenixforcehq.onestopmovies.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> moviesList;
    Context mContext;
    String posterPathBaseUrl = "http://image.tmdb.org/t/p/w185";


    public class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_movie_name)
        public TextView title;

        @BindView(R.id.iv_movie_poster)
        public AppCompatImageView poster;

        public MovieViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }


    public MoviesAdapter(Context con) {
        this.mContext = con;
    }

    public void setMoviesList(List<Movie> moviesList) {
        this.moviesList = moviesList;
        this.notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_home, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        Glide.with(mContext)
                .load(posterPathBaseUrl+movie.getPosterPath())
                .into(holder.poster);

    }

    @Override
    public int getItemCount() {
        if (moviesList == null)
            return 0;
        else
            return moviesList.size();
    }
}
