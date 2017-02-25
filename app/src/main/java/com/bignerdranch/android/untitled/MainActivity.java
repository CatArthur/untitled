package com.bignerdranch.android.untitled;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    MyMonth[] makeMonth(){
        MyMonth[] arr=new MyMonth[12];
        String[] monthArr={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        double[] tempArr = {-12.7,-11.3,-4.5,7.7,19.3,23.9,23.5,22.8,16.0,5.2,-0.3,-9.3};
        int[] dayArr = {31,28,31,30,31,30,31,31,30,31,30,31 };

        for (int i = 0; i < arr.length; i++) {
            MyMonth month = new MyMonth();
            month.month = monthArr[i];
            month.temp = tempArr[i];
            month.days = dayArr[i];
            arr[i] = month;
        }
        return arr;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyMonthAdapter adapter = new MyMonthAdapter(this, makeMonth());

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }
}
