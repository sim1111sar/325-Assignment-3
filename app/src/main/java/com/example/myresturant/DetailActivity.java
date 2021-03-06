package com.example.myresturant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {
    ImageView Food_Image;
    TextView Food_Name,Description,Price_txt;
    EditText Quantity;
    String name;
    Button Add_Item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

         Food_Image = findViewById(R.id.Food_Image);
         Food_Name = findViewById(R.id.Food_Name);
         Description = findViewById(R.id.Description);
         Price_txt = findViewById(R.id.Price);
         Quantity = findViewById(R.id.Quantity);
         Add_Item = findViewById(R.id.Add);
         name = getIntent().getStringExtra("list_name");

            if (name.equals("Chicken Burger")) {
                Food_Image.setImageResource(R.drawable.chicken_burger);
                Food_Name.setText("CHICKEN BURGER");
                Description.setText("Whole white meat 100% Canadian chicken breast flame-grilled to perfection and served on a fresh, lightly toasted bun.");
                Price_txt.setText("7.99");
            } else if (name.equals("Buffalo Chicken Burger")) {
                Food_Image.setImageResource(R.drawable.buffalo);
                Food_Name.setText("BUFFALO CHICKEN BURGER");
                Description.setText("Crispy chicken breast tossed in Harvey's tasty buffalo sauce and served on a freshly toasted bun.");
                Price_txt.setText("8.99");
            } else if (name.equals("Beef Burger")) {
                Food_Image.setImageResource(R.drawable.beef);
                Food_Name.setText("BEEF BURGER");
                Description.setText("Juicy, flame-grilled burger made with 100% Canadian beef, placed on a fresh, lightly toasted bun and topped just the way you want it.");
                Price_txt.setText("6.99");
            } else if (name.equals("Veggie Burger")) {
                Food_Image.setImageResource(R.drawable.veggie);
                Food_Name.setText("VEGGIE BURGER");
                Description.setText("Veggie burger on a fresh, lightly toasted bun.");
                Price_txt.setText("6.19");
            }
            else if (name.equals("Flank Steak")) {
                Food_Image.setImageResource(R.drawable.flank);
                Food_Name.setText("FLANK STEAK");
                Description.setText("Flank steak is a large, thin cut from the belly of the steer. It???s lean and flavorful meat. While flank isn???t a tender cut, it???s not the toughest either.");
                Price_txt.setText("30.99");
            } else if (name.equals("Skirt Steak")) {
                Food_Image.setImageResource(R.drawable.skirt);
                Food_Name.setText("SKIRT STEAK");
                Description.setText("Skirt steak is a long, thin cut from the diaphragm muscles of the steer, and it???s sometimes confused with flank steak for its fibrous appearance.");
                Price_txt.setText("27.99");
            } else if (name.equals("Sirloin Steak")) {
                Food_Image.setImageResource(R.drawable.sirloin);
                Food_Name.setText("FLANK STEAK");
                Description.setText("Flank steak is a large, thin cut from the belly of the steer. It???s lean and flavorful meat. While flank isn???t a tender cut, it???s not the toughest either.");
                Price_txt.setText("25.99");
            } else if (name.equals("Filet Mignon")) {
                Food_Image.setImageResource(R.drawable.mignon);
                Food_Name.setText("FILET MIGNON");
                Description.setText("Beef tenderloin or filet mignon is the most tender cut of beef. Filet mignon refers to steak, while beef tenderloin is also the name for the entire boneless roast.");
                Price_txt.setText("35.99");
            }
            else if (name.equals("Brandy")) {
                Food_Image.setImageResource(R.drawable.brandy);
                Food_Name.setText("BRANDY");
                Description.setText("Although brandy can be made from any fruit but in order to achieve higher acidity it is traditionally made from early grapes.");
                Price_txt.setText("23.99");
            } else if (name.equals("Cognac")) {
                Food_Image.setImageResource(R.drawable.cognac);
                Food_Name.setText("COGNAC");
                Description.setText("Technically a type of brandy but cognac deserves a special mention because this particular drink can only be made if certain requirements are met.");
                Price_txt.setText("35.99");
            } else if (name.equals("Vodka")) {
                Food_Image.setImageResource(R.drawable.vodka);
                Food_Name.setText("VODKA");
                Description.setText("Vodka is traditionally made from potatoes or fermented cereal grains. Some brands also make it from other substances like fruit or sugar.");
                Price_txt.setText("25.99");
            } else if (name.equals("Wiskey")) {
                Food_Image.setImageResource(R.drawable.wiskey);
                Food_Name.setText("WISKEY");
                Description.setText("Whiskey is type of distilled alcoholic beverage, generally made from fermented grain mash including barley, corn, rye, and wheat.");
                Price_txt.setText("29.99");
            }
            else if (name.equals("Leafy Green Salad")) {
                Food_Image.setImageResource(R.drawable.leafy);
                Food_Name.setText("LEAFY GREEN SALAD");
                Description.setText("Green salad is a tossed salad made with greens.");
                Price_txt.setText("10.99");
            } else if (name.equals("Greek Salad")) {
                Food_Image.setImageResource(R.drawable.greek_salad);
                Food_Name.setText("GREEK SALAD");
                Description.setText("A Greek salad consists of tomatoes, cucumbers, olives, feta, and onions.");
                Price_txt.setText("12.99");
            } else if (name.equals("Fattoush")) {
                Food_Image.setImageResource(R.drawable.fattoush);
                Food_Name.setText("FATTOUSH");
                Description.setText("Fattoush is a Levantine salad composed of mixed greens and toasted or fried khubz, or flatbread.");
                Price_txt.setText("13.99");
            } else if (name.equals("Chicken Salad")) {
                Food_Image.setImageResource(R.drawable.chicken_salad);
                Food_Name.setText("CHICKEN SALAD");
                Description.setText("Chicken salad is a dish made of shredded chicken and mayonnaise.");
                Price_txt.setText("15.99");
            }



        Add_Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quantity = Quantity.getText().toString();
                String price = Price_txt.getText().toString();
               if (quantity.isEmpty() || Integer.parseInt(quantity) == 0) {
                    Toast.makeText(getApplicationContext(), "Quantity is empty", Toast.LENGTH_SHORT).show();
                } else {
                   Intent intent = new Intent();
                   intent.putExtra("quantity", quantity);
                   intent.putExtra("price", price);
                   intent.putExtra("name", name);

                   setResult(Activity.RESULT_OK, intent);
                   finish();
               }
            }
        });
    }

}