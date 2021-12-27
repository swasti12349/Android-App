package com.sro.androidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.sro.androidapp.Adapter.itemAdapter;
import com.sro.androidapp.Repository.ItemRepo;
import com.sro.androidapp.ViewModel.ItemViewModel;
import com.sro.androidapp.model.DataModel;
import com.sro.androidapp.network.RetrofitClass;
import com.sro.androidapp.network.api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ItemViewModel itemViewModel;
    private RecyclerView recyclerView;
    private List<DataModel> list;
    private itemAdapter adapter;
    private ItemRepo itemRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        list = new ArrayList<>();
        itemRepo = new ItemRepo(getApplication());
        adapter = new itemAdapter(this, list);
        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        itemViewModel.getAllItems().observe(this, new Observer<List<DataModel>>() {
            @Override
            public void onChanged(List<DataModel> dataModelList) {
                Log.d("listi", dataModelList.toString());
                adapter.getAllActor(dataModelList);
                recyclerView.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "sahi hai", Toast.LENGTH_SHORT).show();
            }
        });

        networkRequest();
    }

    private void networkRequest() {

        api apiInterface = new RetrofitClass().getRetrofit().create(api.class);
        apiInterface.getAllItems().enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if (response.isSuccessful()){
                    itemRepo.insert(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}