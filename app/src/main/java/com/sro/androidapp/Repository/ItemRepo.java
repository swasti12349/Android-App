package com.sro.androidapp.Repository;

import android.app.Application;
import android.content.ClipData;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.sro.androidapp.Dao.ItemDao;
import com.sro.androidapp.Database.ItemDatabase;
import com.sro.androidapp.model.DataModel;

import java.util.List;

public class ItemRepo {
    //database object
    public ItemDatabase itemDatabaseRef;

    //list for database data
    public LiveData<List<DataModel>> getAllList;

    public ItemRepo(Application application) {

        // database refeernce
        itemDatabaseRef = ItemDatabase.getInstance(application);

        // getting all items from the database
        getAllList = itemDatabaseRef.mainDao().showAll();

    }

    //insert all items
    public void insert(List<DataModel> dataModelList) {


        new InsertAsycnTask(itemDatabaseRef).execute(dataModelList);
    }

    //delete all items
    public void delete() {
        new DeleteAsycnTask(itemDatabaseRef).execute();
    }


    // show all items
    public LiveData<List<DataModel>> listLiveData() {
        return getAllList;
    }


    // insert execution
    static class InsertAsycnTask extends AsyncTask<List<DataModel>, Void, Void> {
        // dao object
        private ItemDao itemDao;

        InsertAsycnTask(ItemDatabase itemDatabase) {
            //dao reference
            itemDao = itemDatabase.mainDao();
        }

        @Override
        protected Void doInBackground(List<DataModel>... lists) {

            // calling insert method from dao
            itemDao.insert(lists[0]);
            return null;
        }
    }

    // delete execution
    static class DeleteAsycnTask extends AsyncTask<Void, Void, Void> {
        private ItemDao itemDao;

        DeleteAsycnTask(ItemDatabase itemDatabase) {
            itemDao = itemDatabase.mainDao();
        }

        @Override
        protected Void doInBackground(Void... Voids) {
            // calling deleteAll method from dao
            itemDao.deleteAll();
            return null;
        }
    }


}
