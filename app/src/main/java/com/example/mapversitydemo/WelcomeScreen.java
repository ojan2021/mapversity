package com.example.mapversitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class WelcomeScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        hideNavigationBar();

        Spinner spinner = findViewById(R.id.UniversityChooser);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.universities,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

      @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String uniName = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),uniName,Toast.LENGTH_SHORT).show();
        if(uniName.equals("Oxford University")) {
            Intent navScreen = new Intent(getApplicationContext(), NavScreen.class);
            startActivity(navScreen, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }
}
