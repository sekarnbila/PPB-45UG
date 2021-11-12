package com.example.aplikasimenumcd;

import android.os.Parcel;
import android.os.Parcelable;

public class Mcd implements Parcelable {
    public Mcd() {

    }
    protected Mcd(Parcel in) {
        name = in.readString();
        detail = in.readString();
        price = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Mcd> CREATOR = new Creator<Mcd>() {
        @Override
        public Mcd createFromParcel(Parcel in) {
            return new Mcd(in);
        }

        @Override
        public Mcd[] newArray(int size) {
            return new Mcd[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    private String name;
    private String detail;
    private String price;
    private int photo;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(detail);
        parcel.writeString(price);
        parcel.writeInt(photo);
    }
}
