package com.sro.androidapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sro.androidapp.Adapter.itemAdapter;
import com.sro.androidapp.R;
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

public class MainActivity extends AppCompatActivity {
    private ItemViewModel itemViewModel;
    private RecyclerView recyclerView;
    private List<DataModel> list;
    private itemAdapter adapter;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recview);
        delete = findViewById(R.id.delete);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new itemAdapter(this);

        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        list = new ArrayList<>();




        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemViewModel.delete();
            }
        });


        itemViewModel.getAllItems().observe(this, new Observer<List<DataModel>>() {
            @Override
            public void onChanged(List<DataModel> dataModelList) {
                Log.d("listi", dataModelList.toString());
                adapter.getAllItems(dataModelList);
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
                if (response.isSuccessful()) {
                    itemViewModel.insert(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}