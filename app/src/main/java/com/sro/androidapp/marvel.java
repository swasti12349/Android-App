package com.sro.androidapp;

public class marvel {

    String id;
    String name;
    String path;

    public marvel(String id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path + ".jpg";
    }

    public void setPath(String path) {
        this.path = path + ".jpg";
    }
}
