package br.com.frameworksystem.marvelapp.broadcast;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import br.com.frameworksystem.marvelapp.service.MonitorService;

/**
 * Created by wgomes on 07/07/16.
 */
public class TestReceiver extends WakefulBroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, MonitorService.class);
        startWakefulService(context, service);
    }
}
