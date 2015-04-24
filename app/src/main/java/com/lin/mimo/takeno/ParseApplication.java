package com.lin.mimo.takeno;

import android.app.Application;

import com.parse.Parse;


/**
 * Created by mimo on 2015/4/24.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "niheH2SIhwCynAHlVJG5yPGYhjG6qaeXvB5FEuD9","iL9YtVzG34IShz5hPSusDUKqU1VqvChwHtkNb8DV");


            }
    }
