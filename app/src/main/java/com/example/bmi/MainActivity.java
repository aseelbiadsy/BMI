package com.example.bmi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    EditText etName,etHeight,etWeight;
    ImageView img1;
    Button btnCalc;
    String st_H, st_W,reply;
    double RR=-1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10 && resultCode==RESULT_OK)
        {
                  reply = data.getStringExtra("Result");
                   RR=Double.parseDouble(reply);
                  if(RR>=0 && RR<=18.5)
                      img1.setImageResource(R.drawable.aa);

                  else if(RR>18.5 && RR<24)
                      img1.setImageResource(R.drawable.bb);

                  else if(RR>24 && RR<30)
                      img1.setImageResource(R.drawable.cc);

                  else if(RR>30)
                      img1.setImageResource(R.drawable.dd);
        }
    }
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///*************************************************/
        etName=findViewById(R.id.etName);
        etHeight=findViewById(R.id.etHeight);
        etWeight=findViewById(R.id.etWeight);
        img1=findViewById(R.id.img1);
        btnCalc=findViewById(R.id.btnCalc);
        ///***********************************************/
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go=new Intent(MainActivity.this,MainActivity2.class);
                st_H=etHeight.getText().toString();
                st_W=etWeight.getText().toString();
                go.putExtra("H",st_H);
                go.putExtra("W",st_W);
                startActivityForResult(go,10);
            }
        });
    }
}