package com.example.doctors;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.HashMap;
import android.widget.ListAdapter;

import com.example.doctors.R;

import java.util.jar.Attributes;

import org.xmlpull.v1.XmlPullParserException;

public class PreviousAppointments extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.previous_appointments);
        TextView my_textview;
        my_textview = (TextView) findViewById(R.id.text);
        XmlPullParserFactory pullParserFactory;
        try{
            ArrayList<HashMap<String, String>> userList = new ArrayList<>();
            HashMap<String,String> Drugs = new HashMap<>();
            // my_textview = (TextView) findViewById(R.id.text);

            ListView lv = (ListView) findViewById(R.id.user_list);

            InputStream istream = getAssets().open("parsers.xml");
            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);

            parser.setInput(istream,null);
            String tag = "" , text = "";
            int event = parser.getEventType();

            while (event!= XmlPullParser.END_DOCUMENT){
                tag = parser.getName();
                switch (event){
                    case XmlPullParser.START_TAG:
                        if(tag.equals("Drugs"))
                            Drugs = new HashMap<>();
                        break;
                    case XmlPullParser.TEXT:
                        text=parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        switch (tag){
                            case "Name": Drugs.put("Name",text);
                                break;
                            case "Disease": Drugs.put("Disease",text);
                                break;
//                            case "manufacturer": Drugs.put("manufacturer",text);
//                                break;
                            case "Drugs":
                                if(Drugs!=null)
                                    userList.add(Drugs);
                                break;
                        }
                        break;
                }
                event = parser.next();
            }
            ListAdapter adapter = new SimpleAdapter(PreviousAppointments.this, userList, R.layout.list_row,new String[]{"Name","Disease"}, new int[]{R.id.name, R.id.color});
            lv.setAdapter(adapter);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }    }
}
