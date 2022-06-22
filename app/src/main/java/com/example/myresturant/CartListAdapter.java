package com.example.myresturant;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CartListAdapter extends ArrayAdapter<CartListContent> {

    private Context mContext;
    private int mResource;
    String total;

    public CartListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CartListContent> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(mResource, parent, false);
        }

        String name = getItem(position).getName();
        String quantity = getItem(position).getQuantity();
        String price = getItem(position).getPrice();

        if(position==0){
            total = price;
        }
        if(position >= 1) {
            double temp = Double.parseDouble(total) + Double.parseDouble(price);
            total =  String.valueOf(temp);
        }

        TextView item_name = convertView.findViewById(R.id.Name_Cart_Value);
        TextView item_quantity = convertView.findViewById(R.id.Quantity_Cart_Value);
        TextView item_price = convertView.findViewById(R.id.Price_Cart_Value);
        TextView item_total = convertView.findViewById(R.id.Total_Cart_Value);

        item_name.setText(name);
        item_quantity.setText(quantity);
        item_price.setText(String.format("%.2f", Double.parseDouble(price)));
        item_total.setText(String.format("%.2f", Double.parseDouble(total)));

        return convertView;
    }
}
