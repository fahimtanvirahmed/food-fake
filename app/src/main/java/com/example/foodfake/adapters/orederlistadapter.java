package com.example.foodfake.adapters;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodfake.R;
import com.example.foodfake.model.menuorder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class orederlistadapter extends FirebaseRecyclerAdapter<menuorder,orederlistadapter.MyViewHolder> {


    public orederlistadapter(@NonNull FirebaseRecyclerOptions options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull menuorder menuList) {
        holder.menuName.setText(menuList.getName());
        holder.menuPrice.setText("Price: tk"+String.format("%.2f", menuList.getPrice()*menuList.getTotalInCart()));
        holder.menuQty.setText("Qty: " + menuList.getTotalInCart());
        Glide.with(holder.thumbImage)
                .load(menuList.getUrl())
                .into(holder.thumbImage);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_order_recycler_row, parent, false);
        return  new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView menuName;
        TextView  menuPrice;
        TextView  menuQty;
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
