//package com.phoenixforcehq.onestopmovies.view.adapters;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.phoenixforcehq.onestopmovies.R;
//import com.phoenixforcehq.onestopmovies.model.Movie;
//
//import java.util.List;
//
//public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
//
//    private List<Movie> moviesList;
//    String[] a;
//
//
//    public class MovieViewHolder extends RecyclerView.ViewHolder {
//        public TextView title, year, genre;
//
//        public MovieViewHolder(View view) {
//            super(view);
//            title = (TextView) view.findViewById(R.id.title);
//            genre = (TextView) view.findViewById(R.id.genre);
//            year = (TextView) view.findViewById(R.id.year);
//        }
//    }
//
//
//    public MoviesAdapter(List<Movie> moviesList) {
//        this.moviesList = moviesList;
//    }
//
//    @Override
//    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.movie_list_row, parent, false);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(MovieViewHolder holder, int position) {
//        Movie movie = moviesList.get(position);
//        holder.title.setText(movie.getTitle());
//        holder.genre.setText(movie.getGenre());
//        holder.year.setText(movie.getYear());
//    }
//
//    @Override
//    public int getItemCount() {
//        return moviesList.size();
//    }
//}
