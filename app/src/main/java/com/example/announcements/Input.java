package com.example.announcements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Input extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button login;
    private String vname="Admin";
    private  String vpassword="Admin";
    private boolean isok=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        name=(EditText) findViewById(R.id.name);
        password=(EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.lg);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urn=name.getText().toString();
                String ups=password.getText().toString();
                if(urn.isEmpty()|| ups.isEmpty()){
                    Toast.makeText(Input.this, "Please Enter Both Of Them", Toast.LENGTH_LONG).show();
                }
                else{
                    isok=valid(urn,ups);
                    if(!isok){
                        Toast.makeText(Input.this, "Incorrect Email or Password", Toast.LENGTH_LONG).show();
                    }
                    else{
                            next();
                    }
                }
            }
        });
    }
    private boolean valid(String n,String p){
        if(n.equals(vname) && p.equals(vpassword)){
            return true;
        }
        else
            return false;
    }
    public void next(){
        Intent intent=new Intent(this,data.class);
        intent.setAction(Intent.ACTION_VIEW);
        startActivity(intent);
    }
}