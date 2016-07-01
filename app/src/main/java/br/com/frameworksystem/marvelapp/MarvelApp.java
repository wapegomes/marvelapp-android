package br.com.frameworksystem.marvelapp;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by wgomes on 01/07/16.
 */

public class MarvelApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().
                setDefaultFontPath("fonts/Roboto-Regular.ttf").
                setFontAttrId(R.attr.fontPath).build());
    }
}
