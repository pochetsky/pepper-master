package com.auchan.pepper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Pochetsky on 11/10/2016.
 */

public class MetsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mets);

        ArrayAdapter<String> textCenter = new ArrayAdapter<>(this, R.layout.textcenter, R.id.textItem);
        listView.setAdapter(textCenter);
    }
}
