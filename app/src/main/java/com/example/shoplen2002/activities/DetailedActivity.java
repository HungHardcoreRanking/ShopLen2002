package com.example.shoplen2002.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.shoplen2002.R;
import com.example.shoplen2002.models.ViewAllModels;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class DetailedActivity extends AppCompatActivity {
    ImageView detailImg;
    TextView price, rating, description, name, total, quantity;
    int totalQuantity=1;
    Button addtoCart;
    ImageView addItem, removeItem;
    androidx.appcompat.widget.Toolbar toolbar;
    FirebaseFirestore firestore;
    FirebaseAuth auth;
    ViewAllModels viewAllModels = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        firestore=FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();


        final Object object = getIntent().getSerializableExtra("detail");
        if(object instanceof ViewAllModels){
            viewAllModels = (ViewAllModels) object;
        }
        quantity = findViewById(R.id.quantly);
        detailImg = findViewById(R.id.detail_img);
        name = findViewById(R.id.detail_name);
        price = findViewById(R.id.detail_price);
        description = findViewById(R.id.detail_description);
        rating = findViewById(R.id.detail_rating);
        total = findViewById(R.id.detail_total);
        addItem = findViewById(R.id.add_item);
        removeItem = findViewById(R.id.remove_item);
        if(viewAllModels !=null){
            Glide.with(getApplicationContext()).load(viewAllModels.getImg_url()).into(detailImg);
            name.setText(viewAllModels.getName());
            price.setText(viewAllModels.getPrice());
            description.setText(viewAllModels.getDescription());
            rating.setText(viewAllModels.getRating());
            total.setText("Còn lại: "+viewAllModels.getTotal()+" sản phẩm");
            total.setText(String.valueOf(viewAllModels.getTotal()));
        }
        addtoCart = findViewById(R.id.add_to_cart);
        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addedtoCart();
            }
        });
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalValue = Integer.parseInt(total.getText().toString());
                if(totalQuantity<totalValue){
                    totalQuantity++;
                    quantity.setText(String.valueOf(totalQuantity));
                }
            }
        });
        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalQuantity>1){
                totalQuantity--;
                quantity.setText(String.valueOf(totalQuantity));}
            }
        });
    }
    private void addedtoCart(){

    }
}