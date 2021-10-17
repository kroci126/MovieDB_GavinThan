package com.example.moviedb.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviedb.model.Movies;
import com.example.moviedb.model.NowPlaying;
import com.example.moviedb.repositories.MovieRepository;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository repository;

    public MovieViewModel(@NonNull Application application){
        super(application);
        repository = MovieRepository.getInstance();
    }

    //Begin of viewmodel get movie by id

    private MutableLiveData<Movies> resultGetMovieId = new MutableLiveData<>();
    public void getMovieById(String movieId){
        resultGetMovieId = repository.getMovieData(movieId);
    }

    public LiveData<Movies> getResultGetMovieById(){

        return resultGetMovieId;
    }

    //End of viewmodel get movie by id

    //Begin of viewmodel get now playing

    private MutableLiveData<NowPlaying> resultGetNowPlaying = new MutableLiveData<>();
    public void getNowPlaying(){
        resultGetNowPlaying = repository.getNowPlayingData();
    }

    public LiveData<NowPlaying> getResultNowPlaying(){

        return resultGetNowPlaying;
    }

    //End of viewmodel get now playing

}
