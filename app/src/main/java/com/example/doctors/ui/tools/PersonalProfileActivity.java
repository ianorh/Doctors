package com.example.doctors.ui.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.doctors.R;

public class PersonalProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalprofile);



    }
    private String fname,sname,email,gender,location,department;

    public PersonalProfileActivity(String fName,String sName,String eMail,String gEnder,String Location,String dEpartment){
        fname=fName;
        sname=sName;
        email=eMail;
        gender=gEnder;
        location=Location;
        department=dEpartment;


    }
}
