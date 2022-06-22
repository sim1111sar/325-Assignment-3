package com.example.myresturant;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    ImageButton Hamburgers,Steak,Drinks,Salad;
    String total;
    ArrayList <String> arrayList = new ArrayList<>();
    ActivityResultLauncher <Intent> FoodListActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        total = data.getStringExtra("total");
                        arrayList = data.getStringArrayListExtra("arraylist");
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Hamburgers = findViewById(R.id.Hamburger_BTN);
         Steak = findViewById(R.id.Steak_BTN);
         Drinks = findViewById(R.id.Drinks_BTN);
         Salad = findViewById(R.id.Salad_BTN);
        String[] Burger_List = {"Chicken Burger", "Buffalo Chicken Burger", "Beef Burger", "Veggie Burger"};
        String[] Steak_List = {"Flank Steak", "Skirt Steak", "Sirloin Steak", "Filet Mignon"};
        String[] Drink_List = {"Brandy", "Cognac", "Vodka", "Wiskey"};
        String[] Salad_List = {"Leafy Green Salad", "Greek Salad", "Fattoush", "Chicken Salad"};


        intent = new Intent(this, FoodListActivity.class);
        Hamburgers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("list", Burger_List);
                intent.putExtra("total", total);
                intent.putExtra("arraylist", arrayList);
                FoodListActivity.launch(intent);
            }
        });
        Steak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("list", Steak_List);
                intent.putExtra("total", total);
                intent.putExtra("arraylist", arrayList);
                FoodListActivity.launch(intent);
            }
        });
        Drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("list", Drink_List);
                intent.putExtra("total", total);
                intent.putExtra("arraylist", arrayList);
                FoodListActivity.launch(intent);
            }
        });
        Salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("list", Salad_List);
                intent.putExtra("total", total);
                intent.putExtra("arraylist", arrayList);
                FoodListActivity.launch(intent);
            }
        });
    }
}