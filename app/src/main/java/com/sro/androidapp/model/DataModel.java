package com.sro.androidapp.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "DataTable")
public class DataModel {

    @PrimaryKey(autoGenerate = true)
    private int itemID;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private String id;

    @SerializedName("userId")
    @ColumnInfo(name = "userId")
    private String userId;

    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;

    @SerializedName("body")
    @ColumnInfo(name = "body")
    private String body;

    public DataModel(String id, String userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @NonNull
    @Override
    public String toString() {
        return "DataModel{" +
                "itemID=" + itemID +
                ", id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}