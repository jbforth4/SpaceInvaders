package com.example.jaredforth.spaceinvaders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button sfwButton = (Button) findViewById(R.id.sfwButton);
        sfwButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, SpaceInvadersActivity.class);
                startActivity(intent);
            }
        });

        Button nsfwButton = (Button) findViewById(R.id.nsfwButton);
        nsfwButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, SpaceInvadersActivity.class);
                startActivity(intent);
            }
        });
    }


}
