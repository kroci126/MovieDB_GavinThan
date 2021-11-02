package com.example.moviedb.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviedb.R;

public class MovieDetailsActivity extends AppCompatActivity {

    private String movie_id = "";
    private String date = "";
    private String title = "";
    private String overview = "";
    private String img_path = "";
    private String popularity = "";

    TextView lbl_title, lbl_overview, lbl_date, buatdate, buatpopularity, lbl_popularity;
    ImageView movie_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent intent = getIntent();
        movie_id = intent.getStringExtra("movie_id");
        date = intent.getStringExtra("movie_rdate");
        title = intent.getStringExtra("movie_title");
        overview = intent.getStringExtra("movie_overview");
        img_path = intent.getStringExtra("movie_poster");
        popularity = intent.getStringExtra("movie_popularity");

        lbl_title = findViewById(R.id.lbl_details_title);
        lbl_title.setText(title);

        lbl_overview = findViewById(R.id.lbl_details_overview);
        lbl_overview.setText(overview);

        movie_image = findViewById(R.id.img_details_poster);
        Glide.with(MovieDetailsActivity.this).load(img_path).into(movie_image);

        lbl_date = findViewById(R.id.lbl_details_date);
        lbl_date.setText(date);

        lbl_popularity = findViewById(R.id.lbl_details_popularity);
        lbl_popularity.setText(popularity);

        buatdate = findViewById(R.id.release_date);
        buatdate.setText("Release date: ");

        buatpopularity = findViewById(R.id.popularity_bar);
        buatpopularity.setText("Popularity: ");



//        lbl_text = findViewById(R.id.lbl_movie_details);
//        lbl_text.setText(movie_id);

    }
}