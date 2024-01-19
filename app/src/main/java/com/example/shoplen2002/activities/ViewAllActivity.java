package com.example.shoplen2002.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shoplen2002.R;
import com.example.shoplen2002.adapters.ViewAllAdapter;
import com.example.shoplen2002.models.ViewAllModels;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {
    FirebaseFirestore firestore;
    List<ViewAllModels> viewAllModelsList;
    RecyclerView recyclerView;
    ViewAllAdapter viewAllAdapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        firestore = FirebaseFirestore.getInstance();
        String type = getIntent().getStringExtra("type");
        recyclerView = findViewById(R.id.view_all_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewAllModelsList = new ArrayList<>();
        viewAllAdapter = new ViewAllAdapter(this,viewAllModelsList);
        recyclerView.setAdapter(viewAllAdapter);

        if(type !=null && type.equalsIgnoreCase("Len")){
            firestore.collection("Products").whereEqualTo("type","Len").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot:task.getResult().getDocuments()){
                        ViewAllModels viewAllModels = documentSnapshot.toObject(ViewAllModels.class);
                        viewAllModelsList.add(viewAllModels);
                        viewAllAdapter.notifyDataSetChanged();
                    }
                }
            });
        }


        if(type !=null && type.equalsIgnoreCase("Dụng cụ")){
            firestore.collection("Products").whereEqualTo("type","Dụng cụ").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot:task.getResult().getDocuments()){
                        ViewAllModels viewAllModels = documentSnapshot.toObject(ViewAllModels.class);
                        viewAllModelsList.add(viewAllModels);
                        viewAllAdapter.notifyDataSetChanged();
                    }
                }
            });
        }


        if(type !=null && type.equalsIgnoreCase("Thành phẩm")){
            firestore.collection("Products").whereEqualTo("type","Thành phẩm").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot:task.getResult().getDocuments()){
                        ViewAllModels viewAllModels = documentSnapshot.toObject(ViewAllModels.class);
                        viewAllModelsList.add(viewAllModels);
                        viewAllAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}