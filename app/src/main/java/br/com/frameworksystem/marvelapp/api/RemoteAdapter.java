package br.com.frameworksystem.marvelapp.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by wgomes on 11/07/16.
 */

public class RemoteAdapter {

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    private static final int CACHE_SIZE = 100 * 1024 * 1024; //200MB
    private static final int TIME_OUT = 10; //seconds;

    private static final String PUBLIC_KEY = "277232a94db26746c653c879d30cec89";
    private static final String PRIVATE_KEY = "6d332bb5f4ad1eb5e428179c15f492ae7eb74b0d";

    private RemoteAdapter() {
    }

    public static void init(@Nullable File cacheDir) {
        createAdapter(cacheDir);
    }


    public static synchronized <T>  T getApi(@NonNull Class<T> service) {
        return retrofit.create(service);
    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private static void createAdapter(@Nullable File cacheDir) {

        okHttpClient = createClient(cacheDir);

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://gateway.marvel.com")
                .addConverterFactory(LoganSquareConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static OkHttpClient createClient(File cacheDir) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new AuthInterceptor(PUBLIC_KEY,PRIVATE_KEY));

        if (cacheDir != null) {
            Cache cache = new Cache(cacheDir, CACHE_SIZE);
            builder.cache(cache);
        }

        return builder.build();
    }
}