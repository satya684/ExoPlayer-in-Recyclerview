package com.satya.videoplayer.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.satya.videoplayer.Model.MediaObjects;
import com.satya.videoplayer.R;
import com.satya.videoplayer.ViewHolder.VideoViewHolder;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<MediaObjects> mediaObjects;
    private RequestManager requestManager;

    public VideoAdapter(ArrayList<MediaObjects> mediaObjects, RequestManager requestManager) {
        this.mediaObjects = mediaObjects;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_item_layout,parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((VideoViewHolder)holder).onBind(mediaObjects.get(position), requestManager);
    }

    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }
}
