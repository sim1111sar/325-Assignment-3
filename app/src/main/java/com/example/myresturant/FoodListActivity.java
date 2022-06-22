package com.example.myresturant;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.time.temporal.ValueRange;
import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {
    double total = 0;
    String  name,quantity, price;
    String[] list;
    Intent intent;
    ListView food_list;
    Button cart;
    TextView total_txt;
    ArrayList<String> arrayList = new ArrayList<>();
    ActivityResultLauncher <Intent> DetailActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();

                        quantity = data.getStringExtra("quantity");
                        Toast.makeText(getApplicationContext(), quantity + " items are added", Toast.LENGTH_SHORT).show();
                        price = data.getStringExtra("price");
                        name = data.getStringExtra("name");


                        double price_value = Double.parseDouble(price);
                        int quantity_value = Integer.parseInt(quantity);
                        total += price_value * quantity_value;
                        total_txt = findViewById(R.id.Total_Value);

                        total_txt.setText("" + (double) (Math.round(total * 100.0)/100.0));
                        boolean check = false;
                        for (int i = 0; i < arrayList.size() && !check; ++i) {
                            if (arrayList.get(i).equals(name)) {
                                int new_quantity = Integer.parseInt(arrayList.get(i + 1));
                                new_quantity += Integer.parseInt(quantity);

                                double new_price = Double.parseDouble(price) * new_quantity;

                                arrayList.set(i + 1, String.valueOf(new_quantity));
                                arrayList.set(i + 2, String.valueOf(new_price));
                                check = true;
                            }
                        }
                        if (!check) {
                            arrayList.add(name);
                            arrayList.add(quantity);
                            arrayList.add(String.valueOf(Double.parseDouble(price) * Integer.parseInt(quantity)));

                        }
                    }
                }
            });

    ActivityResultLauncher <Intent> CartActivityLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        total_txt.setText("0.0");
                        total = 0.0;
                        arrayList.clear();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        TextView total_text = findViewById(R.id.Total_Value);
        String total_string = getIntent().getStringExtra("total");
        ArrayList<String> backup = new ArrayList<>();
        backup = getIntent().getStringArrayListExtra("arraylist");

        boolean check = false;
        if (total_string != null){
            check = true;
        }
        if (check == true) {
            total = Double.parseDouble(total_string);
            total_text.setText(""+ (double) (Math.round(total * 100.0)/100.0));
            arrayList = backup;
        }

        cart = findViewById(R.id.see_Cart);
        food_list = findViewById(R.id.List);
        list = getIntent().getStringArrayExtra("list");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.food_list, R.id.food_list_text, list);
        food_list.setAdapter(adapter);
        food_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("list_name", list[i]);
                DetailActivityLauncher.launch(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent  = new Intent(getApplicationContext(), CartActivity.class);
                intent.putExtra("values", arrayList);
                intent.putExtra("total", Double.parseDouble(total_text.getText().toString()));
                CartActivityLaunch.launch(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.putExtra("total", ""+total);
        intent.putExtra("arraylist", arrayList);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}


