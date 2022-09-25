package com.example.foodfake.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.foodfake.databinding.AddMenuLayoutBinding;
import com.example.foodfake.model.Menu;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AddMenuDialog extends AppCompatDialogFragment {

    AddMenuLayoutBinding binding;

    int id;
    List<Menu> menus;

    public AddMenuDialog(int id, List<Menu> menus) {
        this.id = id;
        this.menus = menus;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        binding = AddMenuLayoutBinding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(v -> {

            Menu menu = new Menu(
                    binding.name.getText().toString(),
                    Integer.parseInt(binding.price.getText().toString()),
                    binding.url.getText().toString()
            );

            menus.add(menu);

            FirebaseDatabase.getInstance().getReference("res").child(String.valueOf(id)).child("menus").setValue(menus).addOnCompleteListener(t -> {
                if (t.isSuccessful()) {
                    Toast.makeText(requireContext(), "Menu added successfully.", Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            });
        });

        builder.setView(binding.getRoot());
        return builder.create();
    }
}
