package com.example.coafarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MainActivity extends AppCompatActivity {
    List<Farm> farms;
    boolean is_insert = true;
    private static final String API_URL = "https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAttractions.aspx";
    private RecyclerView mRecyclerView;
    FarmDAO dao;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        AttractionsApiManager apiManager = new AttractionsApiManager();
        dao = new FarmDAO(MainActivity.this);
        if (!is_insert) {
            apiManager.getAttractionsData(new AttractionsApiManager.OnDataReceivedListener() {
                @Override
                public void onDataReceived(String data) {
                    // 在這裡處理從 API 收到的資料
                    Log.d("MainActivity", "Received data: " + data);
                    Gson gson = new Gson();
                    farms = gson.fromJson(data.toString()
                            , new TypeToken<List<Farm>>() {
                            }.getType());
                    for (Farm farm:farms) {
                        dao.insert(farm);
                    }
                }
            });
        }else{
            Toast.makeText(this,""+dao.getAll().size(),Toast.LENGTH_SHORT).show();
        }


     }

    private String fetchDataFromApi() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        return response.toString();
    }




 }

