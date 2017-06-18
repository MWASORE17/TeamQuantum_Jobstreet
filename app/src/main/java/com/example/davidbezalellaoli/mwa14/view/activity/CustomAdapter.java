package com.example.davidbezalellaoli.mwa14.view.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidbezalellaoli.mwa14.R;

/**
 * Created by user on 6/1/2017.
 */

class CustomAdapter extends ArrayAdapter<String> {

    CustomAdapter(Context context, String[] foods){
        super(context, R.layout.custom_row ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.custom_row, parent, false);
        String singleFoodItem = getItem(position);
        TextView buckysText = (TextView) customView.findViewById(R.id.buckysText);
        //ImageView buckysImage = (ImageView) customView.findViewById(R.id.buckysImage);
        buckysText.setText(singleFoodItem);
        /*
        switch (position) {
            case 0:
                buckysImage.setImageResource(R.drawable.gambar1);
                break;
            case 1:
                buckysImage.setImageResource(R.drawable.gambar2);
                break;
            case 2:
                buckysImage.setImageResource(R.drawable.gambar3);
                break;
            case 3:
                buckysImage.setImageResource(R.drawable.gambar4);
                break;
            case 4:
                buckysImage.setImageResource(R.drawable.gambar5);
                break;
            case 5:
                buckysImage.setImageResource(R.drawable.gambar6);
                break;
            case 6:
                buckysImage.setImageResource(R.drawable.gambar7);
        }
        */
        return customView;
    }
}
