package com.example.bishwakhatri.nesteddrawer2;

/**
 * Created by bishwa khatri on 4/23/2015.
 */
public class DrawerList {
    String names;
    int images;
    

    public DrawerList(String names, int images) {
        this.names = names;
        this.images = images;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
