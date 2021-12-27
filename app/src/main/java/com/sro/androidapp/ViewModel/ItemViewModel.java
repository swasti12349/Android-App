package com.sro.androidapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sro.androidapp.Repository.ItemRepo;
import com.sro.androidapp.model.DataModel;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    // object of itemrepo class
    private ItemRepo itemRepo;

    // list for incoming data from itemrepo
    private final LiveData<List<DataModel>> listLiveData;

    public ItemViewModel(@NonNull Application application) {
        super(application);

        // itemrepo initialization
        itemRepo = new ItemRepo(application);

        // fetching list data from itemrepo
        listLiveData = itemRepo.listLiveData();

    }

    // insert function of itemViewModel
    public void insert(List<DataModel> list) {
        // calling insert function from itemrepo
        itemRepo.insert(list);
    }

    // delete function of itemViewModel
    public void delete() {
        // calling delete function from itemrepo
        itemRepo.delete();
    }

    // getAllItems function of itemViewModel
    public LiveData<List<DataModel>> getAllItems() {
        // return list from itemrepo
        return listLiveData;
    }


}
