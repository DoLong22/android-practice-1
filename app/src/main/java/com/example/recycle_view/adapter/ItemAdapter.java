package com.example.recycle_view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycle_view.R;
import com.example.recycle_view.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {
    List<Item> listItem;

    public ItemAdapter() {
        this.listItem = new ArrayList<>();;
    }

    public void addToList(Item item){
        listItem.add(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemAdapter.ItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemAdapterViewHolder holder, int position) {
        holder.bind(listItem.get(position), position);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ItemAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView tvId, tvName, tvDate;
        Button btnDelete;
        int position;

        public ItemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.itemImage);
            tvId = itemView.findViewById(R.id.itemId);
            tvName = itemView.findViewById(R.id.itemName);
            tvDate = itemView.findViewById(R.id.itemDate);
            btnDelete = itemView.findViewById(R.id.btnDeleteItem);
        }

        public void bind(Item item,int position){
            image.setImageResource(item.getUri());
            tvId.setText(item.getId()+"");
            tvName.setText(item.getName());
            tvDate.setText(item.getDate());
            btnDelete.setOnClickListener(this);
            this.position = position;
        }
        @Override
        public void onClick(View v) {
            deleteItem(position);
        }
    }
    public void deleteItem(int position){
        Log.d("AppLog",position+"");
        listItem.remove(position);
        notifyDataSetChanged();
    }
}
