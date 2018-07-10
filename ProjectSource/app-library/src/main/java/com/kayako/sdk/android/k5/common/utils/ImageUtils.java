package com.kayako.sdk.android.k5.common.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import com.bumptech.glide.request.RequestOptions;
import com.kayako.sdk.android.k5.R;
import com.kayako.sdk.android.k5.common.adapter.messengerlist.ChannelDecoration;
import com.kayako.sdk.android.k5.common.view.CircleImageView;
import com.kayako.sdk.android.k5.common.view.CropCircleTransformation;
import com.kayako.sdk.android.k5.core.Kayako;
import com.kayako.sdk.auth.Auth;

import java.io.File;

public class ImageUtils {

    private static final int height = 600;
    private static final int width = 300;

    /**
     * Set public image url to imageView
     *
     * @param context    Context of the activity
     * @param avatarView ImageView to show avatar
     * @param avatarUrl  URL of the avatar image to show
     */
    public static void setAvatarImage(Context context, ImageView avatarView, String avatarUrl) {
        if (avatarUrl != null) {


            Glide.with(context)
                    .load(avatarUrl)
                    .apply(RequestOptions.placeholderOf(R.drawable.ko__placeholder_avatar))
                    .apply(RequestOptions.bitmapTransform(new CropCircleTransformation(context)))
                    .apply(RequestOptions.centerCropTransform())
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                    .into(avatarView);

        } else {
            Glide.with(context)
                    .load(R.color.ko__avatar_image_background)
                 //   .bitmapTransform(new CropCircleTransformation(context))
                    .into(avatarView);
        }
    }

    /**
     * Set public image url imageView and specify default placeholder resource
     *
     * @param context
     * @param imageView
     * @param imageUrl
     * @param placeholderDrawable
     */
    public static void setImage(Context context, ImageView imageView, String imageUrl, int placeholderDrawable) {
        if (imageUrl != null) {

            RequestOptions options = new RequestOptions();
            options.centerCrop();
            options.dontAnimate();
            options.placeholder(R.drawable.ko__placeholder_avatar);
            options.bitmapTransform(new CropCircleTransformation(context));
            options.centerCrop();
            options.skipMemoryCache(false); // false because avatars are repeatedly used in message listing, case listing, etc - when true, it shows placeholders
            options.diskCacheStrategy(DiskCacheStrategy.DATA);

            Glide.with(context)
                    .load(imageUrl)
                    .apply(options)
                    .into(imageView);

            /*
            Glide.with(context)
                    .load(imageUrl)
                    .dontAnimate()
                    .placeholder(placeholderDrawable)
                    .centerCrop()
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(imageView);*/
        } else {
            Glide.with(context)
                    .load(placeholderDrawable)
                    .into(imageView);
        }
    }

    /**
     * Set public image url to imageView
     *
     * @param context    Context of the activity
     * @param avatarView CircularImageView to show avatar
     * @param avatarUrl  URL of the avatar image to show
     */
    public static void setAvatarImage(Context context, CircleImageView avatarView, String avatarUrl) {
        if (avatarUrl != null) {

            RequestOptions options = new RequestOptions();
            options.centerCrop();
            options.dontAnimate();
            options.placeholder(R.drawable.ko__placeholder_avatar);
            options.bitmapTransform(new CropCircleTransformation(context));
            options.centerCrop();
            options.skipMemoryCache(false); // false because avatars are repeatedly used in message listing, case listing, etc - when true, it shows placeholders
            options.diskCacheStrategy(DiskCacheStrategy.DATA);

            Glide.with(context)
                    .load(avatarUrl)
                    .apply(options)
                    .into(avatarView);
            /*
            Glide.with(context)
                    .load(avatarUrl)
                    .dontAnimate()
                    .placeholder(R.drawable.ko__placeholder_avatar)
                    .centerCrop()
                    .skipMemoryCache(false) // false because avatars are repeatedly used in message listing, case listing, etc - when true, it shows placeholders
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(avatarView);*/
        } else {
            Glide.with(context)
                    .load(R.drawable.ko__placeholder_avatar)
                    .into(avatarView);
        }
    }

    /**
     * Set local drawable to imageview
     *
     * @param context
     * @param avatarView
     * @param avatarResId
     */
    public static void setAvatarImage(Context context, ImageView avatarView, int avatarResId) {

        RequestOptions options = new RequestOptions();
        options.centerCrop();
        options.dontAnimate();
        options.placeholder(R.drawable.ko__placeholder_avatar);
        options.bitmapTransform(new CropCircleTransformation(context));
        options.centerCrop();
        options.skipMemoryCache(false); // false because avatars are repeatedly used in message listing, case listing, etc - when true, it shows placeholders
        options.diskCacheStrategy(DiskCacheStrategy.DATA);

        Glide.with(context)
                .load(avatarResId)
                .apply(options)
                .into(avatarView);
        /*
        Glide.with(context)
                .load(avatarResId)
                .centerCrop()
                .skipMemoryCache(false) // false because avatars are repeatedly used in message listing, case listing, etc - when true, it shows placeholders
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(avatarView);*/
    }

    /**
     * Set local drawable and background to CircleImageView
     *
     * @param context
     * @param imageView
     * @param channelDecoration
     */
    public static void setChannelImage(Context context, CircleImageView imageView, ChannelDecoration channelDecoration) {
        int drawableResourceId = channelDecoration.getSourceDrawable();

        if (drawableResourceId != 0) {
            imageView.setImageResource(drawableResourceId);
        }
    }


    /**
     * Set image from file resource
     *
     * @param imageView
     * @param file
     */

    /*
    public static void loadFileAsAttachmentImage(@NonNull Context context, @NonNull ImageView imageView, @NonNull File file, boolean showPlaceholder, boolean configureSize) {

        DrawableTypeRequest<File> request = Glide.with(context).load(file);

        if (showPlaceholder) {
            request.placeholder(R.drawable.ko__loading_attachment);
        }

        if (configureSize) {
            request
                    .override(width, height)
                    .fitCenter();
        }

        request .dontAnimate()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.RESULT) // RESULT messes up when image resizes to fit into imageview with wrap_content
                .into(imageView);
    }

    public static void loadUrlAsAttachmentImage(@NonNull Context context, @NonNull ImageView imageView, @NonNull String imageUrl, boolean showPlaceholder, boolean configureSize, @Nullable final Auth auth, @Nullable final OnImageLoadedListener listener) {

        GlideUrl glideUrl;

        if (auth == null || auth.getHeaders().size() == 0) {
            glideUrl = new GlideUrl(imageUrl);
        } else {
            LazyHeaders.Builder lazyHeaderBuilder = new LazyHeaders.Builder();
            for (String key : auth.getHeaders().keySet()) {
                lazyHeaderBuilder.addHeader(key, auth.getHeaders().get(key));
            }
            glideUrl = new GlideUrl(imageUrl, lazyHeaderBuilder.build());
        }

        DrawableTypeRequest<GlideUrl> request = Glide.with(context).load(glideUrl);

        if (showPlaceholder) {
            request.placeholder(R.drawable.ko__loading_attachment);
        }

        if (configureSize) {
            request
                    .override(width, height)
                    .fitCenter();
        }

        request.listener(new RequestListener<GlideUrl, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, GlideUrl model, Target<GlideDrawable> target, boolean isFirstResource) {
                        if (listener != null) {
                            listener.onImageFailedToLoad();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, GlideUrl model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        if (listener != null) {
                            listener.onImageLoaded();
                        }
                        return false;
                    }
                })
                .dontAnimate()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.DATA) //  RESULT messes up when image resizes to fit into imageview with wrap_content
                .into(imageView);
    }

*/

    private static AsyncTask clearDiskCacheTask;

    public static void clearCache() {
        Glide.get(Kayako.getApplicationContext()).clearMemory();

        if (clearDiskCacheTask == null
                || clearDiskCacheTask.isCancelled() || clearDiskCacheTask.getStatus() != AsyncTask.Status.RUNNING) { // Prevent multiple calls
            clearDiskCacheTask = new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    Glide.get(Kayako.getApplicationContext()).clearDiskCache();
                    return null;
                }
            }.execute();
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded();

        void onImageFailedToLoad();
    }

}
