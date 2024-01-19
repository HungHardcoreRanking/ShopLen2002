package com.example.shoplen2002.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.shoplen2002.R;
import com.example.shoplen2002.models.UserModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {
    private ImageView profileimg;
    private EditText name, email, number, address;
    private Button update;
    private FirebaseAuth auth;
    private FirebaseDatabase database;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        profileimg = root.findViewById(R.id.profile_img);
        name = root.findViewById(R.id.profile_name);
        email = root.findViewById(R.id.profile_email);
        number = root.findViewById(R.id.profile_phonenumber);
        address = root.findViewById(R.id.profile_address);
        update = root.findViewById(R.id.btn_update);

        database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel userModel = snapshot.getValue(UserModel.class);
                Glide.with(requireContext()).load(userModel.getProfileImg()).into(profileimg);
                name.setText(userModel.getName());
                email.setText(userModel.getEmail());
                number.setText(userModel.getPhoneNumber());
                address.setText(userModel.getAddress());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserProfile();
            }
        });

        return root;
    }

    private void updateUserProfile() {
        String newName = name.getText().toString();
        String newEmail = email.getText().toString();
        String newNumber = number.getText().toString();
        String newAddress = address.getText().toString();

        String userId = FirebaseAuth.getInstance().getUid();

        if (userId != null) {
            DatabaseReference userRef = database.getReference().child("Users").child(userId);
            userRef.child("name").setValue(newName);
            userRef.child("email").setValue(newEmail);
            userRef.child("phoneNumber").setValue(newNumber);
            userRef.child("address").setValue(newAddress)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getContext(), "Thông tin đã được cập nhật!", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}