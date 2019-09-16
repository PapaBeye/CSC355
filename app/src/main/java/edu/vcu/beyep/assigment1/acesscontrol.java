package edu.vcu.beyep.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class acesscontrol extends AppCompatActivity {
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button sub_code;
    private TextView code_view_text;
    private String pwd = "";
    private String spwd = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acesscontrol);
        num1 =  findViewById(R.id.num1button);
        num1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        updatePassView("1");

                                    }
                                });
        num2 = findViewById(R.id.num2button);
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePassView("2");

            }
        });
        num3 = findViewById(R.id.num3button);
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePassView("3");

            }
        });
        num4 = findViewById(R.id.num4button);
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePassView("4");

            }
        });
        sub_code = findViewById(R.id.submit_code);
        sub_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spwd = pwd;
                unlock();
            }
        });
        code_view_text = findViewById(R.id.code_view);
        code_view_text.setText(pwd);
    }

    public void updatePassView(String s){
        pwd = pwd + s;
        code_view_text.setText(pwd);
    }
    public void unlock(){
        resetpwd();
        Integer val = Integer.valueOf(spwd);
        if (val == 1234){
            MainActivity.setC_pwd(true);
            MainActivity.updatewelcomtext();
            finish();
        }else {
            MainActivity.setC_pwd(false);
            MainActivity.updatewelcomtext();
            Toast t = Toast.makeText(this, "Wrong Code! Try Again", Toast.LENGTH_LONG);
            t.show();
        }

    }

    public void resetpwd(){
        pwd = "";
        code_view_text.setText(pwd);
    }


}
