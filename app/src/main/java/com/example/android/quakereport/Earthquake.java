package com.example.android.quakereport;

public class Earthquake {
    double mMag;
    String mCity;
    String mDate;

    public Earthquake (double mag, String city, String date) {
        mMag = mag;
        mCity = city;
        mDate = date;
    }
    public double getMag() { return mMag;}
    public String getCity() { return mCity;}
    public String getDate() { return mDate;}

    public double getMagnitude() {
        return mMag;
    }
}
