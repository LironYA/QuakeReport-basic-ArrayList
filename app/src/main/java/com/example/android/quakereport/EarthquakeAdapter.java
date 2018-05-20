package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(@NonNull Context context, ArrayList <Earthquake> Earthquake) {
        super(context, 0, Earthquake);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_adapter, parent, false);
        }
        Earthquake currentValue = getItem(position);
        TextView mag = (TextView)listItemView.findViewById(R.id.mag);
        String formattedMagnitude = formatMagnitude(currentValue.getMagnitude());
        mag.setText(formattedMagnitude);

        String fullLocation = currentValue.getCity();
        TextView location = (TextView)listItemView.findViewById(R.id.location);
        String location_one;
        String location_two;
        if (fullLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = fullLocation.split(LOCATION_SEPARATOR);
            location_two = parts[0] + LOCATION_SEPARATOR;
            location_one = parts[1];
        } else {
            location_two = getContext().getString(R.string.near_the);
            location_one = fullLocation;

        }
        location.setText(location_two);
      //  String fullLocation = currentValue.getCity();
        TextView city = (TextView)listItemView.findViewById(R.id.city);
        city.setText(location_one);
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentValue.getTimeInMilliseconds());
        TextView date = (TextView)listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        date.setText(formattedDate);
        TextView time = (TextView)listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        time.setText(formattedTime);
        return listItemView;

        }

    private String formatMagnitude(double mag) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(mag);
    }
        private String formatDate(Date dateObject) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
            return dateFormat.format(dateObject);
        }
    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


    }



