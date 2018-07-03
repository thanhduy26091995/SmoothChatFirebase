package com.duybui.smoothchatfirebase.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by buivu on 01/12/2017.
 */

public class Home{
    @SerializedName("songs")
    private List<Song> songs;
}
