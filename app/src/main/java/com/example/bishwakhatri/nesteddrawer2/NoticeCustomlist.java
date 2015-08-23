package com.example.bishwakhatri.nesteddrawer2;

/**
 * Created by bishwa khatri on 4/23/2015.
 */
public class NoticeCustomlist {

    String name;
    String phone;
    String address;
    String birthday;
    int images;

    public NoticeCustomlist(String name, String phone, String address, String birthday, int images) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.images=images;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
