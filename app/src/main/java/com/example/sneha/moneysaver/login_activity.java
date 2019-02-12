package com.example.sneha.moneysaver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class login_activity extends AppCompatActivity {
//static int ty=0;
    Button login;
    TextView signu;
    EditText emailid,password;
    SharedPreferences auth;
    SharedPreferences.Editor editor;
static String email1;
static String pw1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
/*
        LinearLayout rl = (LinearLayout) findViewById(R.id.linearLayout3);
        rl.setBackgroundColor(Color.RED);*/

        login = (Button) findViewById(R.id.email_sign_in_button);
        emailid = (EditText) findViewById(R.id.email);
        password= (EditText) findViewById(R.id.Password);
        signu=(TextView) findViewById(R.id.textView3);

        signu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), Sign_up.class);
                startActivity(intent1);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                 email1=emailid.getText().toString();
                 pw1=password.getText().toString();



                auth = getApplicationContext().getSharedPreferences(email1, Context.MODE_PRIVATE);
                String savede = auth.getString("q", "");
                String savedp = auth.getString("m", "");


    Toast t;

    if (email1.isEmpty() || pw1.isEmpty()) {
        t = Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_SHORT);
        t.show();
    } else if (!(email1.equals(savede) && pw1.equals(savedp))) {
        t = Toast.makeText(getApplicationContext(), "Incorrect details", Toast.LENGTH_SHORT);
        t.show();
    } else {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            startActivity(intent);
        finish();
    }


                }


        });




    }
}
