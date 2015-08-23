package com.example.bishwakhatri.nesteddrawer2;

/**
 * Created by bishwa khatri on 6/11/2015.
 */
public class ResultCustomList {
    String title;
    String time;
    String faculty;
    int images;


    public ResultCustomList(String title, String time, String faculty, int images) {
        this.title = title;
        this.time = time;
        this.faculty = faculty;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
