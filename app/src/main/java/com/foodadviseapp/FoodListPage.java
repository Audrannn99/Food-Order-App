package com.foodadviseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class FoodListPage extends AppCompatActivity {
    private ListView listView;
    private LinearLayout option;
    private LinearLayout chartOpt,settingsOpt,previousOrderOpt;
    private ImageButton optionBtn;
    private Boolean isMenuOpen = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_list_layout);
        listView = findViewById(R.id.food_list);
        optionBtn = findViewById(R.id.map_item_opt_btn);
        option = findViewById(R.id.option);
        chartOpt = findViewById(R.id.chart_opt);
        previousOrderOpt = findViewById(R.id.previous_order_opt);
        settingsOpt = findViewById(R.id.settings_opt);
        // Create an ArrayList to store Food objects
        ArrayList<Food> recipes = new ArrayList<>();
        optionBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                isMenuOpen = !isMenuOpen;
                if (isMenuOpen) {
                    option.setVisibility(View.VISIBLE);
                }else{
                    option.setVisibility(View.GONE);
                }
            }
        });
        chartOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(FoodListPage.this, DetailActivity.class);
                startActivity(intent);
            }
        });
        previousOrderOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(FoodListPage.this, " Pervious order opt!", Toast.LENGTH_SHORT).show();
            }
        });
        settingsOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(FoodListPage.this," Settings pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        recipes.add(new Food("Pasta with Marinara Sauce",4, 2000,2,R.drawable.pasta));
        recipes.add(new Food("Chicken Stir-Fry", 3, 2300,2,R.drawable.chicken));
        recipes.add(new Food("Vegetarian Chili",2, 600, 3,R.drawable.vegetarian_chili));
        recipes.add(new Food("Scrambled Eggs",2, 1000, 1,R.drawable.scrambled_eggs));
        recipes.add(new Food("Banana Bread",1, 1000, 3,R.drawable.banana_bread));
        recipes.add(new Food("Pasta with Sauce",4000, 2000,2,R.drawable.pasta));
        recipes.add(new Food("Vegetarian",2, 3000, 2,R.drawable.vegetarian_chili));
        recipes.add(new Food("Eggs",2, 2000, 4,R.drawable.scrambled_eggs));

        // Create a custom adapter for the ListView
        FoodListAdapter adapter = new FoodListAdapter(this, recipes);
        listView.setAdapter(adapter);
        if (isMenuOpen) {
            option.setVisibility(View.VISIBLE);
        }else{
            option.setVisibility(View.GONE);
        }
    }
}
