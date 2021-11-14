package com.example.bktgiuaki;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent myIntent;
    private Bundle extras;
    private MediaPlayer music;
    private TextView baiHat;
    private TextView songName;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baiHat = this.findViewById(R.id.baihat);
        songName = this.findViewById(R.id.songName);
        music = null;
        index = 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2){
            if(resultCode == SelectActivity.RESULT_OK){
                if(music != null){
                    music.stop();
                }
                index = data.getIntExtra("songNumber",1);
                baiHat.setText("Bài Hát "+ index);
                switch (index){
                    case 1:
                        songName.setText("Hana Wa Odore Ya Iroha Niho");
                        music = MediaPlayer.create(this, R.raw.hanawaodoreyairohaniho);
                        break;
                    case 2:
                        songName.setText("Kimi no Namae");
                        music = MediaPlayer.create(this, R.raw.kiminonamae);
                        break;
                    case 3:
                        songName.setText("Shining Glow");
                        music = MediaPlayer.create(this, R.raw.shiningglow);
                        break;
                    case 4:
                        songName.setText("This Game");
                        music = MediaPlayer.create(this, R.raw.thisgame);
                        break;
                    case 5:
                        songName.setText("Unlasting");
                        music = MediaPlayer.create(this, R.raw.unlasting);
                        break;
                    default:
                        songName.setText("Yuuhi Saka");
                        music = MediaPlayer.create(this, R.raw.yuuhisaka);
                        break;
                }

            }
        }
    }

    public void playMusic(View view){
        if(music != null){
            music.start();
        }

    }

    public void changeActivity(View view) {
        myIntent = new Intent(MainActivity.this, SelectActivity.class);
        this.startActivityForResult(myIntent,2);
    }

    public void pause(View view) {
        if(music != null){
            music.pause();
        }
    }
}