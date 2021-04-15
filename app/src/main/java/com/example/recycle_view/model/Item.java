package com.example.recycle_view.model;

import android.net.Uri;

import androidx.annotation.DrawableRes;

public class Item {
    private String id;
    private String name;
    private int uri;
    private String date;

    public Item(String id, String name, int uri, String date) {
        this.id = id;
        this.name = name;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUri() {
        return uri;
    }

    public void setUri(int uri) {
        this.uri = uri;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
