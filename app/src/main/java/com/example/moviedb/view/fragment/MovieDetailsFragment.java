package com.example.moviedb.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviedb.R;
import com.example.moviedb.helper.Const;
import com.example.moviedb.model.Genre;
import com.example.moviedb.model.Movies;
import com.example.moviedb.model.NowPlaying;
import com.example.moviedb.view.activities.MovieDetailsActivity;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieDetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MovieDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieDetailsFragment newInstance(String param1, String param2) {
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView lbl_title, lbl_date, lbl_vote, lbl_avg, lbl_overview, lbl_popularity, testId, lbl_genre;
    RoundedImageView img_poster;
    KenBurnsView img_backdrop;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);

        String movieId = getArguments().getString("movieId");
        String title = getArguments().getString("title");
        String date = getArguments().getString("date");
        String vote = getArguments().getString("vote");
        String avg = getArguments().getString("avg");
        String overview = getArguments().getString("overview");
        String poster_path = getArguments().getString("poster");
        String backdrop_path = getArguments().getString("backdrop");
        String popularity = getArguments().getString("popularity");

//        String test = getArguments().getString("genre");
//        ArrayList genre = getArguments().getIntegerArrayList("genre");
//        String genre_name = "";
//
//        testId = view.findViewById(R.id.testId);
//        lbl_genre = view.findViewById(R.id.mv_details_frag_genre);
//        Genre genres = new Genre();
//
//        for (int i = 0; i < genre.size();i++){
//            int id = (int) genre.get(i);
//            genre_name = genre_name + genres.getGenres().get(id).getName();
//        }
//        lbl_genre.setText(genre_name);
//
//        testId.setText(genre_name);

        lbl_title = view.findViewById(R.id.mv_details_frag_title);
        lbl_title.setText(title);

        lbl_date = view.findViewById(R.id.mv_details_frag_date);
        lbl_date.setText(date);

        lbl_vote = view.findViewById(R.id.mv_details_frag_vote);
        lbl_vote.setText(vote);

        lbl_avg = view.findViewById(R.id.mv_details_frag_avg);
        lbl_avg.setText(avg);

        lbl_overview = view.findViewById(R.id.mv_details_frag_overview);
        lbl_overview.setText(overview);

        lbl_popularity = view.findViewById(R.id.mv_details_frag_popularity);
        lbl_popularity.setText(popularity);

        img_poster = view.findViewById(R.id.mv_details_frag_poster);
        Glide.with(MovieDetailsFragment.this).load(Const.IMG_URL+poster_path).into(img_poster);

        img_backdrop = view.findViewById(R.id.kbv_backdrop);
        Glide.with(MovieDetailsFragment.this).load(Const.IMG_URL+backdrop_path).into(img_backdrop);

        return view;
    }
}