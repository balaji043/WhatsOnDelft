package com.bamdevelopers.balaji.whatson.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Balaji on 31-12-2017.
 */

public class Event implements Parcelable {

    private String ID;
    private String about_event;
    private String address;
    private String end_date;
    private String event_name;
    private String img_url;
    private String min_age;
    private String price;
    private String startDate;
    private String update;
    private String website;

    public Event() {
    }

    public Event(String ID, String about_event, String address, String end_date, String event_name, String img_url, String
            min_age, String price, String startDate, String update, String website) {
        this.ID = ID;
        this.about_event = about_event;
        this.address = address;
        this.end_date = end_date;
        this.event_name = event_name;
        this.img_url = img_url;
        this.min_age = min_age;
        this.price = price;
        this.startDate = startDate;
        this.update = update;
        this.website = website;
    }

    protected Event(Parcel in) {
        ID = in.readString();
        about_event = in.readString();
        address = in.readString();
        end_date = in.readString();
        event_name = in.readString();
        img_url = in.readString();
        min_age = in.readString();
        price = in.readString();
        startDate = in.readString();
        update = in.readString();
        website = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAbout_event() {
        return about_event;
    }

    public void setAbout_event(String about_event) {
        this.about_event = about_event;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getMin_age() {
        return min_age;
    }

    public void setMin_age(String min_age) {
        this.min_age = min_age;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ID);
        dest.writeString(about_event);
        dest.writeString(address);
        dest.writeString(end_date);
        dest.writeString(event_name);
        dest.writeString(img_url);
        dest.writeString(min_age);
        dest.writeString(price);
        dest.writeString(startDate);
        dest.writeString(update);
        dest.writeString(website);
    }
}
