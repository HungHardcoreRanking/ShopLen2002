package com.example.shoplen2002.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoplen2002.R;
import com.example.shoplen2002.activities.ViewAllActivity;
import com.example.shoplen2002.models.HomeCategories;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    Context context;
    List<HomeCategories> categoriesList;

    public HomeAdapter(Context context, List<HomeCategories> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cat_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(categoriesList.get(position).getImg_url()).into(holder.catImg);
        holder.name.setText(categoriesList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAllActivity.class);
                intent.putExtra("type",categoriesList.get(position).getType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView catImg;
        TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catImg = itemView.findViewById(R.id.home_cat_img);
            name = itemView.findViewById(R.id.home_cat_name);
        }
    }
}
