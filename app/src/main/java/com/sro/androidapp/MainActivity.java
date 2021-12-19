package com.sro.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIendPoints apIendPoints;
    String key = "df0501a62e8e8e9b6246a469e124e4d3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apIendPoints = RetrofitClass.getRetrofit().create(APIendPoints.class);
        apIendPoints.getMarvelChar(key).enqueue(new Callback<List<marvel>>() {
            @Override
            public void onResponse(Call<List<marvel>> call, Response<List<marvel>> response) {

                Toast.makeText(MainActivity.this, "Fetched", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<marvel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                Log.d("error", t.getLocalizedMessage());
            }
        });
    }
}