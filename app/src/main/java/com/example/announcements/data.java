package com.example.announcements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class data extends AppCompatActivity {
    EditText ehead;
    EditText eurl;
    Button send;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    public DatabaseReference dbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ehead=(EditText)findViewById(R.id.headline);
        eurl=(EditText) findViewById(R.id.link);
        send=(Button) findViewById(R.id.up);
        dbs=db.getReference("Announcements");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
    }
    public void sendData(){
        String hd=ehead.getText().toString();
        String lnk=eurl.getText().toString();
        if(!TextUtils.isEmpty(hd)){
        info obj=new info(hd,lnk);
        dbs.push().setValue(obj);
        Toast.makeText(this, "Data Uploaded!!", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);}
        else{
            Toast.makeText(this, "Can't leave Blank", Toast.LENGTH_SHORT).show();
        }

    }
}