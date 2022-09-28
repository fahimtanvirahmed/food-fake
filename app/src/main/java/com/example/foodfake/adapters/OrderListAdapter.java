package com.example.foodfake.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodfake.R;
import com.example.foodfake.model.Menu;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.MyViewHolder> {


    ArrayList<Menu> menus;

    public OrderListAdapter(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_order_recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.menuName.setText(menus.get(position).getName());
        holder.menuPrice.setText("Price: tk" + String.format("%.2f", menus.get(position).getPrice() * menus.get(position).getTotalInCart()));
        holder.menuQty.setText("Qty: " + menus.get(position).getTotalInCart());
        Glide.with(holder.thumbImage)
                .load(menus.get(position).getUrl())
                .into(holder.thumbImage);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView menuName;
        TextView menuPrice;
        TextView menuQty;
        ImageView thumbImage;

        public MyViewHolder(View view) {
            super(view);
            menuName = view.findViewById(R.id.menuName);
            menuPrice = view.findViewById(R.id.menuPrice);
            menuQty = view.findViewById(R.id.menuQty);
            thumbImage = view.findViewById(R.id.thumbImage);
        }
    }
}
