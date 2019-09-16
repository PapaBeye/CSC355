package edu.vcu.beyep.assigment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button unlockButton;
    private static TextView welcometext;
    private static Boolean c_pwd = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unlockButton = findViewById(R.id.unlock_button);
        welcometext = findViewById(R.id.welcomeText);
        welcometext.setText("Welcome to the App! The App is LOCKED!");
        updatewelcomtext();
        unlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAccessControl();
            }
        });
    }
    public void openAccessControl(){
        Intent intent = new Intent(this , acesscontrol.class);
        startActivity(intent);
    }
    public static void setC_pwd(Boolean b){
        c_pwd = b;
    }
    public static void updatewelcomtext(){
        if (c_pwd == true){
            welcometext.setText("Welcome to the App! The App is UNLOCKED!");
        }else {
            welcometext.setText("Welcome to the App! The App is LOCKED!");
        }
    }
}
