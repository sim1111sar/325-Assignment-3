package com.example.myresturant;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;


public class CartActivity extends AppCompatActivity {

    double total;
    ArrayList<String> values;
    TextView total_bottom;
    ListView list;
    Button clear;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        intent = getIntent();
        clear = findViewById(R.id.clear);
        list = findViewById(R.id.Name_Cart_Value);
        total_bottom = findViewById(R.id.Total_Value_Cart);
        values = getIntent().getStringArrayListExtra("values");

        total = getIntent().getDoubleExtra("total", 0.0);
        total_bottom.setText("" + (double) (Math.round(total*100.0)/100.0));
        ArrayList<CartListContent > arrayList = new ArrayList<>();

                for (int i = 0; i < values.size() ; i = i + 3) {
                    arrayList.add(new CartListContent(values.get(i),values.get(i+1),values.get(i+2)));
                }

                CartListAdapter cartListAdapter = new CartListAdapter(this, R.layout.cart_list, arrayList);
                list.setAdapter(cartListAdapter);
                clear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent FoodList = new Intent();
                        total_bottom.setText("0.0");
                        list.setAdapter(null);
                        setResult(Activity.RESULT_OK, FoodList);
                    }
                });
            }
        }
