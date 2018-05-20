package com.example.android.quakereport;

public class Earthquake {
    double mMag;
    String mCity;
    long mTimeInMilliseconds;


    public Earthquake (double mag, String city, long TimeInMilliseconds) {
        mMag = mag;
        mCity = city;
        mTimeInMilliseconds = TimeInMilliseconds;
    }
    public double getMag() { return mMag;}
    public String getCity() { return mCity;}
    public long getDate() { return mTimeInMilliseconds;}

    public double getMagnitude() {
        return mMag;
    }
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }
}
