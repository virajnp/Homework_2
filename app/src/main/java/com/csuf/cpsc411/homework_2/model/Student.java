package com.csuf.cpsc411.homework_2.model;

import java.util.ArrayList;

public class Student {
    protected String mCWID;
    protected String mFirstName;
    protected String mLastName;
    protected ArrayList<Vehicle> mVehicle;

    public Student(String cwid,String fName, String lName ) {
        mFirstName = fName;
        mLastName = lName;
        mCWID = cwid;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getCWID() {
        return mCWID;
    }

    public void setCWID(String CWID) {
        mCWID = CWID;
    }

    public ArrayList<Vehicle> getVehicle() {
        return mVehicle;
    }

    public void setVehicle(ArrayList<Vehicle> vehicle) {
        mVehicle = vehicle;
    }
}
