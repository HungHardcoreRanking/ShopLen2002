package com.example.shoplen2002;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
// ...

public class MyCartsFragment extends Fragment {
    private ImageView productImage;
    private TextView productName;
    private TextView price;
    private TextView quantity;
    private TextView totalPrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_carts, container, false);

        // Ánh xạ các thành phần giao diện người dùng
        productImage = view.findViewById(R.id.productImage);
        productName = view.findViewById(R.id.productName);
        price = view.findViewById(R.id.price);
        quantity = view.findViewById(R.id.quantity);
        totalPrice = view.findViewById(R.id.totalPrice);

        // Khởi tạo Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference databaseReference = firebaseDatabase.getReference("users").child(userId);

            // Lắng nghe sự thay đổi dữ liệu trên Firebase
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Kiểm tra xem dữ liệu có tồn tại
                    if (dataSnapshot.exists()) {
                        // Lấy dữ liệu từ dataSnapshot và cập nhật lên các thành phần giao diện người dùng
                        String img_url = dataSnapshot.child("img_url").getValue(String.class);
                        String productNameText = dataSnapshot.child("productName").getValue(String.class);
                        String priceText = dataSnapshot.child("price").getValue(String.class);
                        String quantityText = dataSnapshot.child("quantity").getValue(String.class);
                        String totalPriceText = dataSnapshot.child("totalPrice").getValue(String.class);
                        productName.setText(productNameText);
                        price.setText(priceText);
                        quantity.setText(quantityText);
                        totalPrice.setText(totalPriceText);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Xử lý lỗi khi truy vấn dữ liệu thất bại
                }
            };

            // Đăng ký lắng nghe sự thay đổi dữ liệu trên Firebase
            databaseReference.addValueEventListener(valueEventListener);
        }

        return view;
    }
}