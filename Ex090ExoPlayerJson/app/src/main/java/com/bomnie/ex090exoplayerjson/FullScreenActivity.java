package com.bomnie.ex090exoplayerjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class FullScreenActivity extends AppCompatActivity {

    PlayerView pv;
    SimpleExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        pv= findViewById(R.id.pv);
        player= ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
        pv.setPlayer(player);

        Intent intent = getIntent();
        String videoUrl = intent.getStringExtra("videoUrl"); // 안오면 null
        long currentPos = intent.getLongExtra("currentPos", 0); // 안오면 0

        // 미디어 소스 객체 생성
        DataSource.Factory factory= new DefaultDataSourceFactory(this, "Ex090ExoPlayerJson");
        ProgressiveMediaSource.Factory mediaFactory = new ProgressiveMediaSource.Factory(factory); //  도매를 소매로 넘기는 과정

        ProgressiveMediaSource mediaSource= mediaFactory.createMediaSource(Uri.parse(videoUrl));
        player.prepare(mediaSource);
        player.setPlayWhenReady(true);

        player.seekTo(currentPos);

    }
}
