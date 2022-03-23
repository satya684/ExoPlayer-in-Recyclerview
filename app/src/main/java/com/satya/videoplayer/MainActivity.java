package com.satya.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.satya.videoplayer.Adapter.VideoAdapter;
import com.satya.videoplayer.Model.MediaObjects;
import com.satya.videoplayer.Utils.Resources;
import com.satya.videoplayer.Utils.VerticalSpacingItemDecorator;
import com.satya.videoplayer.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        activityMainBinding.recyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        activityMainBinding.recyclerView.addItemDecoration(itemDecorator);

        ArrayList<MediaObjects> mediaObjects = new ArrayList<MediaObjects>(Arrays.asList(Resources.MEDIA_OBJECTS));
        activityMainBinding.recyclerView.setMediaObjects(mediaObjects);
        videoAdapter = new VideoAdapter(mediaObjects, initGlide());
        activityMainBinding.recyclerView.setAdapter(videoAdapter);
    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }


    @Override
    protected void onDestroy() {
        if(activityMainBinding.recyclerView!=null)
            activityMainBinding.recyclerView.releasePlayer();
        super.onDestroy();
    }
}