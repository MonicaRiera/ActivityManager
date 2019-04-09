package com.example.activitymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName;
    private EditText etSurname;
    private Button btnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.activity_detail__tv__name);
        //tvName.setOnClickListener(this);
        String name = getIntent().getExtras().getString("name from main activity");
        tvName.setText(name);

        etSurname = findViewById(R.id.activity_detail__et__input);

        btnApply = findViewById(R.id.activity_detail__btn__apply);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retIntent = new Intent();
                //tvName.setText(tvName.getText() + " " + etSurname.getText());
                String retString = tvName.getText() + " " + etSurname.getText();
                retIntent.putExtra("returnString", retString);
                setResult(Activity.RESULT_OK, retIntent);
                finish();
            }
        });
    }
}
