package com.xendit.example;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int LOCATION_REQUEST = 1;
    private TextView createTokenTextView;
    private TextView authenticationTextView;
    private TextView validationUtilTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBarTitle("Xendit");

        createTokenTextView = (TextView) findViewById(R.id.createTokenTextView_MainActivity);
        authenticationTextView = (TextView) findViewById(R.id.authenticationTextView_MainActivity);
        validationUtilTextView = (TextView) findViewById(R.id.validationUtilTextView_MainActivity);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_REQUEST);
        }
        createTokenTextView.setOnClickListener(this);
        authenticationTextView.setOnClickListener(this);
        validationUtilTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.createTokenTextView_MainActivity:
                startActivity(CreateTokenActivity.getLaunchIntent(this));
                break;
            case R.id.authenticationTextView_MainActivity:
                startActivity(AuthenticationActivity.getLaunchIntent(this));
                break;
            case R.id.validationUtilTextView_MainActivity:
                startActivity(ValidationUtilActivity.getLaunchIntent(this));
                break;
        }
    }

    private void setActionBarTitle(String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }
}