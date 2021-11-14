package com.example.bktgiuaki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectActivity extends AppCompatActivity {

    private Intent intent;
    private Bundle extras = new Bundle();
    private int songNum;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        text = this.findViewById(R.id.songNumber);
        intent = new Intent();
    }

    public void playmusic(int song) {
//        MediaPlayer music = MediaPlayer.create(this, R.raw.shiningglow);
//        music.start();
    }

    private void update() {
        text.setText("" + songNum);
    }

    public void bai1(View view) {
        songNum = 1;
        update();
    }

    public void bai2(View view) {
        songNum = 2;
        update();
    }
    public void bai3(View view) {
        songNum = 3;
        update();
    }
    public void bai4(View view) {
        songNum = 4;
        update();
    }
    public void bai5(View view) {
        songNum = 5;
        update();
    }
    public void bai6(View view) {
        songNum = 6;
        update();
    }

    public void select(View view) {
        intent.putExtra("songNumber", songNum);
        setResult(SelectActivity.RESULT_OK, intent);
        finish();
    }
}