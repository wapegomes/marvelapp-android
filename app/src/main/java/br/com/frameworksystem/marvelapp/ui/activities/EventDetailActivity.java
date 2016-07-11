package br.com.frameworksystem.marvelapp.ui.activities;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;

import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.model.Event;
import br.com.frameworksystem.marvelapp.service.LogService;
import br.com.frameworksystem.marvelapp.util.Constants;

/**
 * Created by wgomes on 22/06/16.
 */

public class EventDetailActivity extends BaseActivity {

    private Event event;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_detail);

        Intent intent = new Intent(this, LogService.class);
        intent.putExtra(Constants.SERVICETAG,"Service");
        startService(intent);

        if (getIntent().hasExtra("event")) {
            event = (Event) getIntent().getSerializableExtra("event");
        }
        WebView webView = (WebView) findViewById(R.id.webview_event_detail);
        webView.loadUrl(event.getUrl());
    }

}
