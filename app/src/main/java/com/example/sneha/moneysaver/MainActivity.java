package com.example.sneha.moneysaver;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {


    Button logoff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoff = (Button) findViewById(R.id.logout);

        String[] listitems =  {"Balance", "Plans", "Expenses", "Bucket List", "Review"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, listitems);

        ListView listView = (ListView) findViewById(R.id.con_list);
        listView.setAdapter(adapter);



        logoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), login_activity.class);
                startActivity(intent1);
                finish();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent myintent = new Intent(view.getContext(),Savings.class);
                    startActivityForResult(myintent,0);
                }
                if(i==1){
                    Intent myintent = new Intent(view.getContext(),Plans.class);
                    startActivityForResult(myintent,3);
                }
                if(i==2){
                    Intent myintent = new Intent(view.getContext(),Expenses.class);
                    startActivityForResult(myintent,1);
                }
                if(i==3){
                    Intent myintent = new Intent(view.getContext(),BucketList.class);
                    startActivityForResult(myintent,2);
                }

                if(i==4){
                    Intent myintent = new Intent(view.getContext(),Review.class);
                    startActivityForResult(myintent,4);
                }

            }
        });
    }


}
