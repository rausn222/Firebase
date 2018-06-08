package com.example.raushan.firegooglein;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Summery extends AppCompatActivity {
    FirebaseAuth mAuth;
    TextView tv1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summery);
        tv1 = (TextView)findViewById(R.id.textView10);
        b1 = (Button)findViewById(R.id.button4);
        mAuth = FirebaseAuth.getInstance();
        final String user = getIntent().getStringExtra("name");
        tv1.setText("Welcome "+user+" your summery is:-");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Summery.this,MainActivity.class));
            }
        });
    }
}
