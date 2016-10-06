package br.com.frameworksystem.marvelapp.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import java.io.File;
import java.net.URI;

import br.com.frameworksystem.marvelapp.R;

/**
 * Created by wapeg on 05/10/2016.
 */
public class CameraActivity extends BaseActivity {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE_PERMISSION = 1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE_PERMISSION);
        } else {
            takePicture();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                takePicture();
            } else {
                onBackPressed();
            }
        }
    }

    private void takePicture() {
        File picsDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        ;
        File imageFile = new File(picsDir, "MarvelApp");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));
        startActivity(intent);
        ;
    }
}
