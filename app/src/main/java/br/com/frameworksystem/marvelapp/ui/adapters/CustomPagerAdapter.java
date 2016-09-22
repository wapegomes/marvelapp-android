package br.com.frameworksystem.marvelapp.ui.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import br.com.frameworksystem.marvelapp.R;

/**
 * Created by wgomes on 22/09/16.
 */
public class CustomPagerAdapter extends PagerAdapter {

    Context context;


    private Integer[] Imgid = {
            R.raw.img1, R.raw.img2, R.raw.img3, R.raw.img4
    };

    public int getCount() {
        return Imgid.length;
    }

    public Object instantiateItem(View collection, int position) {


        ImageView img = new ImageView(collection.getContext());


        int resId = 0;
        switch (position) {
            case 0:
                resId = Imgid[0];
                break;
            case 1:
                resId = Imgid[1];
                break;
            case 2:
                resId = Imgid[2];
                break;
            case 3:
                resId = Imgid[3];
                break;
            case 4:
                resId = Imgid[4];
                break;
        }

        img.setImageResource(resId);
        ((ViewPager) collection).addView(img, 0);
        return img;
    }

    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }

    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }

    public Parcelable saveState() {
        return null;
    }


}

