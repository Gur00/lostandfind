package com.example.myapplication.model;

public class item {
    private int phn, i_id;
    private String post_type, name, descrp, location, date;

    public int getPhn() {
        return phn;
    }

    public int getI_id() {
        return i_id;
    }

    public void setPhn(int phn) {
        this.phn = phn;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPost_type() {
        return post_type;
    }

    public String getName() {
        return name;
    }

    public String getDescrp() {
        return descrp;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public item(int phn, int i_id, String post_type, String name, String descrp, String location, String date) {
        this.phn = phn;
        this.i_id = i_id;
        this.post_type = post_type;
        this.name = name;
        this.descrp = descrp;
        this.location = location;
        this.date = date;
    }
    public item()
    {

    }


}
