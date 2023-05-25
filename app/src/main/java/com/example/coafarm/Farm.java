package com.example.coafarm;

import java.io.Serializable;

public class Farm implements Serializable {
    private long ID;
    private String Name;
    private String Tel;
    private String Introduction;
    private String TrafficGuidelines;
    private String Address;
    private String OpenHours;
    private String City;
    private String Town;
    private String Photo;
    private String Latitude;
    private String Longitude;

    public Farm() {
    }

    public Farm(long ID, String name, String tel, String introduction, String trafficGuidelines
            , String address, String openHours, String city, String town, String photo
            , String latitude, String longitude) {
        this.ID = ID;
        Name = name;
        Tel = tel;
        Introduction = introduction;
        TrafficGuidelines = trafficGuidelines;
        Address = address;
        OpenHours = openHours;
        City = city;
        Town = town;
        Photo = photo;
        Latitude = latitude;
        Longitude = longitude;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getTrafficGuidelines() {
        return TrafficGuidelines;
    }

    public void setTrafficGuidelines(String trafficGuidelines) {
        TrafficGuidelines = trafficGuidelines;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getOpenHours() {
        return OpenHours;
    }

    public void setOpenHours(String openHours) {
        OpenHours = openHours;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Introduction='" + Introduction + '\'' +
                ", TrafficGuidelines='" + TrafficGuidelines + '\'' +
                ", Address='" + Address + '\'' +
                ", OpenHours='" + OpenHours + '\'' +
                ", City='" + City + '\'' +
                ", Town='" + Town + '\'' +
                ", Photo='" + Photo + '\'' +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                '}';
    }
}
