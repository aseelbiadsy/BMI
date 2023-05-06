package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView tv1,tv2;
    Button btnC;
    double x,y;
    String value;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // /******************************************/
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        btnC=findViewById(R.id.btnC);
       // /***********************************************/
        Intent intent=getIntent();
        String st_user1=intent.getStringExtra("H");
        String st_user2=intent.getStringExtra("W");
        tv1.setText(st_user1);
        tv2.setText(st_user2);
        ///***********************************************/
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1=new Intent();
                x=Double.parseDouble(tv1.getText().toString())/100;
                y=Double.parseDouble(tv2.getText().toString());
                value= (y/(x*x))+"";
                intent1.putExtra("Result",value);
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
    }
}