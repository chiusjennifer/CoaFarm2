package com.example.coafarm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.net.ssl.HttpsURLConnection;

public class AttractionsApiManager {
    private static final String API_URL = "https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvAttractions.aspx";

    public interface OnDataReceivedListener {
        void onDataReceived(String data);
    }
    public void getAttractionsData(OnDataReceivedListener listener) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            try {
                String result = fetchDataFromApi();

                if (listener != null) {
                    listener.onDataReceived(result);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
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
