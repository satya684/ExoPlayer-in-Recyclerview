package com.satya.videoplayer.ViewHolder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.satya.videoplayer.Model.MediaObjects;
import com.satya.videoplayer.R;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    public RequestManager requestManager;
    public FrameLayout media_container;
    public ImageView volumeControl;
    public ImageView thumbnail;
    public ProgressBar progressBar;
    TextView title;
   // ImageView thumbnail, volumeControl;
   // ProgressBar progressBar;
    View parent;
//    RequestManager requestManager;


    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        title = itemView.findViewById(R.id.title);
        progressBar = itemView.findViewById(R.id.progressBar);
        volumeControl = itemView.findViewById(R.id.volume_control);
    }

    public void onBind(MediaObjects mediaObject, RequestManager requestManager) {
        this.requestManager = requestManager;
        parent.setTag(this);
        title.setText(mediaObject.getTitle());
        this.requestManager
                .load(mediaObject.getThumbnail())
                .into(thumbnail);

    }
}
