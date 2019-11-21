package com.example.doctors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doctors.ui.login.LoginActivity;

public class DoctorRegistrationForm extends AppCompatActivity  {
databasehandler data;
EditText location,fname,lname,gender,email,dept;
Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_registration_form);
        location=findViewById(R.id.editlocation);
        fname=findViewById(R.id.editfirstname);
        lname=findViewById(R.id.editlastname);
        gender=findViewById(R.id.editgender);
        email=findViewById(R.id.editemail);
        dept=findViewById(R.id.editdept);
        cont=findViewById(R.id.btncontinue);
       // data=new databasehandler(this);


    }
    public void savedata(View view) {
        if (TextUtils.isEmpty(location.getText())) {
            location.setError("This cannot be empty");
        } else if (TextUtils.isEmpty(fname.getText())) {
            fname.setError("Enter First name");
        }
        else if (TextUtils.isEmpty(lname.getText())){
            lname.setError("Enter last name");
        }
        else if (TextUtils.isEmpty(gender.getText())){
            gender.setError("enter your gender");
        }
        else if (TextUtils.isEmpty(email.getText())){
            email.setError("enter your email");
        }
        else if (TextUtils.isEmpty(dept.getText())){
            dept.setError("Enter your department");
        }

        else {

        Boolean test= data.saveInfor(location.getText().toString(),fname.getText().toString(),lname.getText().toString(),gender.getText().toString(),email.getText().toString(),email.getText().toString()) ;
        if (test==true){
           Toast.makeText(this,"Data inserted successfully",Toast.LENGTH_LONG).show();





        }else {
            Toast.makeText(this, "Not saved successfully", Toast.LENGTH_SHORT).show();

        }


        }
    }
}
