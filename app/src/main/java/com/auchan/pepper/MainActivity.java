package com.auchan.pepper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;

import com.aldebaran.apps.qichatplayer.QiChatPlayer;
import com.aldebaran.apps.qichatplayer.QiChatPlayerListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private QiChatPlayer qiChatPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bMetsList = (Button) findViewById(R.id.mets_button);
        bMetsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent MainToMetsList = new Intent(MainActivity.this,MetsActivity.class);
                startActivity(MainToMetsList);

            }
        });

        Button bVinsList = (Button) findViewById(R.id.vins_button);
        bVinsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent MainToVinsList = new Intent(MainActivity.this,VinsActivity.class);
                startActivity(MainToVinsList);

            }
        });


    }



    @Override
    protected  void onStart(){
        super.onStart();
        initQiChatPlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        qiChatPlayer.stopTalk();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        qiChatPlayer.destroy();
    }

    private void initQiChatPlayer() {
        // Instantiate a QiChatPlayer
        qiChatPlayer = new QiChatPlayer(this);
        // Register QiChatPlayer listener.
        qiChatPlayer.init(new QiChatPlayerListener() {

            @Override
            public void onQiChatPlayerServiceConnected() {
                // Load the topic file.
                qiChatPlayer.loadTopicFile("chat1");
            }

            @Override
            public void onLoadCompleted() {
                // The player is ready to play!
                qiChatPlayer.startTalk();
            }

            @Override
            public void onError(int error) {
                //QiChatPlayer.ERROR_FILE_NOT_EXIST
                Log.d(TAG, "NO=" + error);
                //...
            }
        });
    }
}