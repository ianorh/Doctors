package com.example.doctors.ui.gallery;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//import android.widget.TextView;

//import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProviders;


import com.example.doctors.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class GalleryFragment extends Fragment {
    private String[] mNames = { "Fabian", "Carlos", "Alex", "Andrea", "Karla",
            "Freddy", "Lazaro", "Hector", "Carolina", "Edwin", "Jhon",
            "Edelmira", "Andres" ,"lyn","nakato"};
    private String[] mAnimals = { "Perro", "Gato", "Oveja", "Elefante", "Pez",
            "Nicuro", "Bocachico", "Chucha", "Curie", "Raton", "Aguila",
            "Leon", "Jirafa" ,"ian","orena"};
    private int[] flags = new int[]{
R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment,
            R.drawable.previousappointment



    };

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        List<HashMap<String,String>> aList = new ArrayList<>();
        for(int i=0;i<15;i++){
            HashMap<String, String> hm = new HashMap<>();
            hm.put("txt", "Doctor : " + mNames[i]);
            hm.put("cur","Patient : " + mAnimals[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }
        String[] from = { "flag","txt","cur" };

        int[] to = { R.id.flag,R.id.txt,R.id.cur,R.id.textView2};
        View v = inflater.inflate(R.layout.previous_appointments, container,false);
        ListView list = v.findViewById(R.id.listView1);
        SimpleAdapter adapter = new SimpleAdapter(Objects.requireNonNull(getActivity()).getBaseContext(), aList, R.layout.listview_layout, from, to);
        list.setAdapter(adapter);
        return v;


    }
}