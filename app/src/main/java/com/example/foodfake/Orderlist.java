package com.example.foodfake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.foodfake.adapters.PlaceYourOrderAdapter;
import com.example.foodfake.adapters.orederlistadapter;
import com.example.foodfake.model.Menu;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Orderlist extends AppCompatActivity {
    private RecyclerView cartItemsRecyclerView;
    private FirebaseAuth firebaseAuth;
    private TextView tvSubtotalAmount, tvDeliveryChargeAmount, tvDeliveryCharge, tvTotalAmount, buttonPlaceYourOrder;
    // private SwitchCompat switchDelivery;
    private boolean isDeliveryOn;
    private orederlistadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderlist);

        tvSubtotalAmount = findViewById(R.id.tvSubtotalAmount);
        tvDeliveryChargeAmount = findViewById(R.id.tvDeliveryChargeAmount);
        tvDeliveryCharge = findViewById(R.id.tvDeliveryCharge);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        buttonPlaceYourOrder = findViewById(R.id.buttonPlaceYourOrder);


        cartItemsRecyclerView = findViewById(R.id.cartItemsRecyclerView);

        FirebaseRecyclerOptions<Menu> options =
                new FirebaseRecyclerOptions.Builder<Menu>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("orders").child("DplSCbn5xJc45dJrWkjF3Gvcvkv2"), Menu.class)
                        .build();
        adapter = new orederlistadapter(options);
        cartItemsRecyclerView.setAdapter(adapter);
    }
        protected void onstart()
        {
            super.onStart();
            adapter.startListening();
        }
        protected void onstop()
        {
            super.onStop();
            adapter.stopListening();
        }


}