package br.com.frameworksystem.marvelapp.api;

import android.content.Context;

import br.com.frameworksystem.marvelapp.MarvelApp;
import okhttp3.OkHttpClient;

/**
 * Created by wgomes on 12/07/16.
 */

public class BaseApi {

    protected final Context context;
    protected final OkHttpClient okHttpClient;

    public BaseApi(Context context) {
        this.context = context;
        okHttpClient = MarvelApp.getInstance(context).getOkHttpClient();
    }
}
