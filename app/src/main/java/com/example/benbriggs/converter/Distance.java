package com.example.benbriggs.converter;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by benbriggs on 20/09/2016.
 */
public class Distance {
    Context mContext;

    public Distance(Context context){
        mContext = context;
    }

    public double cmToInches(double entry, TextView text, String type){
        return convertDistance(entry, 0.393701, text, type);
    }

    public double inchesToCm(double entry, TextView text, String type){
        return convertDistance(entry, 2.54, text, type);
    }

    public double mToFeet(double entry, TextView text, String type){
        return convertDistance(entry, 3.28084, text, type);
    }

    public double feetToM(double entry, TextView text, String type){
        return convertDistance(entry, 0.3048, text, type);
    }

    public double kmToMiles(double entry, TextView text, String type){
        return convertDistance(entry, 0.621371, text, type);
    }

    public double milesToKm(double entry, TextView text, String type){
        return convertDistance(entry, 1.60934, text, type);
    }

    private double convertDistance(double entry, double conversionRate, TextView text, String type){
        double converted = entry * conversionRate;
        text.setText(type);
        return converted;
    }
}
