package com.example.activitymanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLoad;
    private EditText edInput;
    private TextView tvName;
    private TextView tvTitle;
    private Button btnLaunch;
    public static final int ACTIVITY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();

        btnLoad = findViewById(R.id.activity_main__btn__load);
        btnLoad.setOnClickListener(this);

        tvTitle = findViewById(R.id.activity_main__tv__title);
        tvTitle.setOnClickListener(this);

        tvName = findViewById(R.id.activity_main__tv__name);
        tvName.setOnClickListener(this);

        edInput = findViewById(R.id.activity_main__et__input);
        edInput.setOnClickListener(this);

        btnLaunch = findViewById(R.id.activity_main__btn__launch);
        btnLaunch.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        String message = null;

        switch (v.getId()){
            case R.id.activity_main__btn__load:
                message = "button clicked";
                tvName.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tvName.setText(edInput.getText());
                break;
            case R.id.activity_main__tv__title:
                message = "title clicked";
                break;
            case R.id.activity_main__tv__name:
                message = "";
                break;
            case R.id.activity_main__btn__launch:
                Intent actIntent = new Intent(this, DetailActivity.class);
                actIntent.putExtra("name from main activity", edInput.getText().toString());
                this.startActivityForResult(actIntent, ACTIVITY_REQUEST_CODE);
                break;
            default:
        }

        if (message != null){
            Toast.makeText(v.getContext(), message, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data from edit text", edInput.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        tvName.setText(inState.getString("data from edit text"));
        tvName.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            tvName.setText(data.getStringExtra("returnString"));
        }
    }
}
