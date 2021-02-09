package com.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void web (View view)
    {
        openUrl("https://www.youtube.com/channel/UCiWG51lxlLrN7rK_oeVRarQ");
    }
    public void openUrl(String url)
    {
        Uri uri=Uri.parse(url);
        Intent launchweb=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launchweb);
    }
}

