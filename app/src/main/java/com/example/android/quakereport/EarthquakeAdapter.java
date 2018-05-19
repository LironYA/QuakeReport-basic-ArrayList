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
import java.util.ArrayList;
import java.util.zip.Inflater;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
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
        TextView city = (TextView)listItemView.findViewById(R.id.city);
        city.setText(currentValue.getCity());
        TextView date = (TextView)listItemView.findViewById(R.id.date);
        date.setText(currentValue.getDate());
        return listItemView;

        }

    private String formatMagnitude(double mag) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(mag);

    }
    }

