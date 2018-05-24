package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
    private String []names=new String []{"Lion","Tiger","monkey","dog","Cat","elephant"};
    private int[]imgIds=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String,Object>showItem=new HashMap<>();
            showItem.put("img",imgIds[i]);
            showItem.put("name",names[i]);
            list.add(showItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.simple_item, new String[]{"img","name"},new int[] { R.id.header, R.id.name } );
        ListView listView=(ListView)findViewById(R.id.mylist);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick( AdapterView parent, View view, int position, long id){
                Toast.makeText(MainActivity.this,names[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
