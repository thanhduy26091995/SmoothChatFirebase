package com.duybui.smoothchatfirebase.utils.components;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.duybui.smoothchatfirebase.R;



/**
 * Created by buivu on 10/10/2016.
 */
public class ImageLoader {
    private static final String TAG = "ImageLoader";
    private static ImageLoader instance;

    private ImageLoader() {

    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    public void loadImageAvatar(final Activity activity, final String url, final ImageView imageView) {

        try {
            Glide.with(activity)
                    .load(url)
                    .error(R.drawable.avatar)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .thumbnail(0.5f)
                    .centerCrop()
                    .placeholder(R.drawable.avatar)
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void loadImageInHome(final Activity activity, final String url, final ImageView imageView) {

        try {
            Glide.with(activity)
                    .load(url)
                    .error(R.drawable.no_image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .thumbnail(0.5f)
                    .placeholder(R.drawable.no_image)
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void loadImageAvatar(final Context context, final String url, final ImageView imageView) {
        try {
            Glide.with(context)
                    .load(url)
                    .error(R.drawable.avatar)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .thumbnail(0.5f)
                    .placeholder(R.drawable.avatar)
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void loadImageAvatar(final Activity activity, final Uri uri, final ImageView imageView) {

        try {
            Glide.with(activity)
                    .load(uri)
                    .error(R.drawable.avatar)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .thumbnail(0.5f)
                    .placeholder(R.drawable.avatar)
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void loadImage(final Activity activity, final String url, final ImageView imageView, Drawable drawable) {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        int deviceWidth = displaymetrics.widthPixels;
        try {
            Glide.with(activity)
                    .load(url)
                    .error(drawable)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .thumbnail(0.2f)
                    // .centerCrop()
                    .placeholder(drawable)
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void loadImage(final Activity activity, final String url, final ImageView imageView, Drawable drawable, int width, int height) {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        int deviceWidth = displaymetrics.widthPixels;
        try {
            Glide.with(activity)
                    .load(url)
                    .error(drawable)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .thumbnail(0.2f)
                    .override(width, height)
                    //   .centerCrop()
                    .placeholder(drawable)
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void loadImageOther(final Activity activity, final String url, final ImageView imageView) {
        try {
            Glide.with(activity)
                    .load(url)
                    .asBitmap()
                    .error(R.drawable.no_image)
                    .thumbnail(0.2f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.no_image)
                    .centerCrop()
                    .into(imageView);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
        }
    }
}
