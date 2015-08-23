package com.example.bishwakhatri.nesteddrawer2;

/**
 * Created by bishwa khatri on 6/13/2015.
 */
public class RoutineCustomlist {


    String time;
    String lectnameA;
    String teachnameA;
    String roomnoA;
   String modeA;

    String lectnameB;
    String teachnameB;
    String roomnoB;

    String modeB;

    public RoutineCustomlist(String time, String lectnameA, String teachnameA, String roomnoA, String modeA, String lectnameB, String teachnameB, String roomnoB, String modeB) {
        this.time = time;
        this.lectnameA = lectnameA;
        this.teachnameA = teachnameA;
        this.roomnoA = roomnoA;
        this.modeA = modeA;
        this.lectnameB = lectnameB;
        this.teachnameB = teachnameB;
        this.roomnoB = roomnoB;
        this.modeB = modeB;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLectnameA() {
        return lectnameA;
    }

    public void setLectnameA(String lectnameA) {
        this.lectnameA = lectnameA;
    }

    public String getTeachnameA() {
        return teachnameA;
    }

    public void setTeachnameA(String teachnameA) {
        this.teachnameA = teachnameA;
    }

    public String getRoomnoA() {
        return roomnoA;
    }

    public void setRoomnoA(String roomnoA) {
        this.roomnoA = roomnoA;
    }

    public String getModeA() {
        return modeA;
    }

    public void setModeA(String modeA) {
        this.modeA = modeA;
    }

    public String getLectnameB() {
        return lectnameB;
    }

    public void setLectnameB(String lectnameB) {
        this.lectnameB = lectnameB;
    }

    public String getTeachnameB() {
        return teachnameB;
    }

    public void setTeachnameB(String teachnameB) {
        this.teachnameB = teachnameB;
    }

    public String getRoomnoB() {
        return roomnoB;
    }

    public void setRoomnoB(String roomnoB) {
        this.roomnoB = roomnoB;
    }

    public String getModeB() {
        return modeB;
    }

    public void setModeB(String modeB) {
        this.modeB = modeB;
    }
}
