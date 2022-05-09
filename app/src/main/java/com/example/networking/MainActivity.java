package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private RecyclerView recyclerView;
    private MyAdapter recyclerAdapter;
    private ArrayList<Mountain> Mountain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(JSON_URL);

        recyclerView=findViewById(R.id.recyclerView);
        Mountain = new ArrayList<Mountain>();
        recyclerAdapter = new MyAdapter(Mountain);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Mountain>>() {}.getType();
        ArrayList<Mountain> array = gson.fromJson(json, type);
        Mountain.addAll(array);
        recyclerAdapter.notifyDataSetChanged();
    }

}
