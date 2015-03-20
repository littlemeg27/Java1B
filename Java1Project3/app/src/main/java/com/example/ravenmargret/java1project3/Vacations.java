//Brenna Pavlinchak 3/16/15

package com.example.ravenmargret.java1project3;

public class Vacations
{
    private  String nameOfVacation;
    private  String location;
    private  String vacationType;
    private  String locationType;


    public Vacations(String mNameOfVacation, String mLocation, String mVacationType, String mLocationType)
    {
        nameOfVacation = mNameOfVacation;
        location = mLocation;
        vacationType = mVacationType;
        locationType = mLocationType;
    }


    public String getNameOfVacation() {return nameOfVacation;}
    public String getLocation() {return location;}
    public String getVacationType() {return vacationType;}
    public String getLocationType() {return locationType;}

    @Override
    public String toString()
    {
        return "Name: " + nameOfVacation + "\n" + "Location: " + location +
               "\n" + "Type Of Vacation: " + vacationType + "\n" + "Type Of Location: " + locationType;
    }
}
