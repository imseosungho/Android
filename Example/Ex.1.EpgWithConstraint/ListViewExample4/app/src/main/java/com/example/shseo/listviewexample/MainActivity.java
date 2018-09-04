package com.example.shseo.listviewexample;
import com.example.shseo.listviewexample.EpgAdapter;
import com.example.shseo.listviewexample.EpgItem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;





public class MainActivity extends AppCompatActivity {

//    Toolbar mToolbar;
 //   ListView mListView;


    private ArrayList<EpgItem> arrayList = new ArrayList<>();
    String fileName = "Channel.json";


   static final String[] LIST_MENU = {"LIST1", "LIST2", "LIST3", "LIST4", "LIST5", "LIST6", "LIST7", "LIST8", "LIST9", "LIST10", "LIST11", "LIST12", "LIST13"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            Log.d("test","File Open??");
            InputStream is = getAssets().open(fileName);
            Log.d("test","File Open OK");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONObject jb = new JSONObject(json);

            JSONArray ja = jb.getJSONArray("epg");
            Log.d("test",ja.toString());

            for(int i=0; i<ja.length(); i++){
            //for(int i=0; i<10; i++){
                JSONObject obj = ja.getJSONObject(i);
                Log.d("test",obj.getString("Id"));
                EpgItem epg = new EpgItem(obj.getString("Id"),obj.getString("Name"),obj.getString("KTCh"),obj.getString("Icon_url"),obj.getString("Source"),obj.getString("ServiceId"));
                arrayList.add(epg);
            }
        }
        catch(IOException | JSONException e){
            e.printStackTrace();
            Log.e("test", e.toString());
        }

        ListView listview = (ListView) findViewById(R.id.listview1);

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LIST_MENU);

        Log.d("test","test ********************** check");
        EpgAdapter adapter = new EpgAdapter(this,arrayList);
        listview.setAdapter(adapter);

        //mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //mListView = (ListView) findViewById(R.id.listview1);
    }
}
