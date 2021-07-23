package com.example.bookapi_app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Itemsss {
    @SerializedName("volumeInfo")
    VolumeInfoo volumeInfo;

    public Itemsss(VolumeInfoo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public VolumeInfoo getVolumeInfo() {
        return volumeInfo;
    }
}
