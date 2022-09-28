package com.example.foodfake;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfake.adapters.FullOrderAdapter;
import com.example.foodfake.model.Menu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Orderlist extends AppCompatActivity {
    private RecyclerView cartItemsRecyclerView;
    private FirebaseAuth firebaseAuth;
    private TextView tvSubtotalAmount, tvDeliveryChargeAmount, tvDeliveryCharge, tvTotalAmount, buttonPlaceYourOrder;
    // private SwitchCompat switchDelivery;
    private boolean isDeliveryOn;
    private FullOrderAdapter adapter;
    private ArrayList<ArrayList<Menu>> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderlist);

        tvSubtotalAmount = findViewById(R.id.tvSubtotalAmount);
        tvDeliveryChargeAmount = findViewById(R.id.tvDeliveryChargeAmount);
        tvDeliveryCharge = findViewById(R.id.tvDeliveryCharge);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        buttonPlaceYourOrder = findViewById(R.id.buttonPlaceYourOrder);


        cartItemsRecyclerView = findViewById(R.id.cart_rv);
        cartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        orders = new ArrayList<>();

        adapter = new FullOrderAdapter(this, orders);
        cartItemsRecyclerView.setAdapter(adapter);

        FirebaseDatabase.getInstance().getReference("orders").get().addOnCompleteListener(t -> {
            if (t.isSuccessful()) {
                for (DataSnapshot ds : t.getResult().getChildren()) {
                    ArrayList<Menu> menus = new ArrayList<>();
                    for (DataSnapshot snapshot : ds.getChildren()) {
                        Menu menu = snapshot.getValue(Menu.class);
                        menus.add(menu);
                    }
                    orders.add(menus);
                }
                adapter.notifyDataSetChanged();

            }
        });

    }
}