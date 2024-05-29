package com.foodadviseapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodListAdapter extends ArrayAdapter<Food> {
    private final Context context;
    private final ArrayList<Food> data;
    public FoodListAdapter(Context context, ArrayList<Food> data) {
        super(context, R.layout.card_layout, data);
        this.context = context;
        this.data = data;
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the item_card layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.card_layout, parent, false);

        // Get the TextView and ImageView and basic items
        TextView textView = view.findViewById(R.id.map_item_title);
        TextView priceView = view.findViewById(R.id.map_item_price);
        TextView rateView = view.findViewById(R.id.map_item_rate);
        ImageView favView = view.findViewById(R.id.add_fav);
        ImageView chartView = view.findViewById(R.id.add_chart);
        ImageView imageView = view.findViewById(R.id.map_item_image);  // Get the ImageView by ID
        // Set the data for the current list item
        textView.setText(data.get(position).name);
        priceView.setText(String.valueOf(data.get(position).price) + " XAF");
        rateView.setText(String.valueOf(data.get(position).rate));
        imageView.setImageResource(data.get(position).imageResourceId);  // Example using a drawable resource
//        imageView.setImageResource(R.drawable.elon_musk);  // Example using a drawable resource
        favView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).name + " add Favourites pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        chartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).name + " add to Chart!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
