package com.example.foodfake.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfake.R;
import com.example.foodfake.model.Menu;

import java.util.ArrayList;

public class FullOrderAdapter extends RecyclerView.Adapter<FullOrderAdapter.ViewHolder> {

    Context context;
    ArrayList<ArrayList<Menu>> orders;

    public FullOrderAdapter(Context context, ArrayList<ArrayList<Menu>> orders) {
        this.context = context;
        this.orders = orders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.orders_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderListAdapter adapter = new OrderListAdapter(orders.get(position));
        holder.rv.setLayoutManager(new LinearLayoutManager(context));
        holder.rv.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv);
        }
    }
}
