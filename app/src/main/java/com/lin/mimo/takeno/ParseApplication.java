package com.lin.mimo.takeno;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;

/**
 * Created by mimo on 2015/4/24.
 */
public class ParseApplication extends Application {
     String aid = getString(R.string.ApplicationID);
    String cid = getString(R.string.ClientKey);
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this,aid, cid);


            }
    }
