package br.com.frameworksystem.marvelapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;

import br.com.frameworksystem.marvelapp.R;

/**
 * Created by wgomes on 21/09/16.
 */

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView img = (ImageView) findViewById(R.id.img_splah);
        Picasso.with(this).load(R.mipmap.ic_launcher).resize(500,500).centerCrop().into(img);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);

            }
        }, 3000);


    }

}
