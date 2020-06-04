package com.example.bt_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainButton1 = findViewById(R.id.mainButton1);
        mainButton1.setOnClickListener(this);

        TextView mainButton2 = findViewById(R.id.mainButton2);
        mainButton2.setOnClickListener(this);

        TextView mainButton3 = findViewById(R.id.mainButton3);
        mainButton3.setOnClickListener(this);

        TextView mainButton4 = findViewById(R.id.mainButton4);
        mainButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.mainButton1:
                // mainButton1 push push, do something something
                Intent toLog = new Intent(this, LogActivity.class);
                startActivity(toLog);
                break;

            case R.id.mainButton2:
                // mainButton2 push push, do something something
                Intent toNormal = new Intent(this, NormalActivity.class);
                startActivity(toNormal);
                break;

            case R.id.mainButton3:
                // mainButton3 push push, do something something
                Intent toMechanism = new Intent(this, MechanismActivity.class);
                startActivity(toMechanism);
                break;

            case R.id.mainButton4:
                // mainButton4 push push, do something something
                Intent toHandle = new Intent(this, HandleActivity.class);
                startActivity(toHandle);
                break;
        }
    }
}
