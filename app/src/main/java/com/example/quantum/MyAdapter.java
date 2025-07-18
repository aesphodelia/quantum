package com.example.quantum;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    private ArrayList<Item> mItemsList;
    private ArrayList<Item> mItemsListFull;

    private OnItemClickListener mListener;



    public interface OnItemClickListener{
        void onItemClick(String name);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.itemImageView);
            mTextView = itemView.findViewById(R.id.itemName);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(listener != null){

                        int position = getAdapterPosition();
                        String name = mItemsList.get(position).getName();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(name);
                        }
                    }
                }
            });
        }
    }

    public MyAdapter(ArrayList<Item> itemsList){

        mItemsList = itemsList;
        mItemsListFull = new ArrayList<>(itemsList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder mvh = new MyViewHolder(v, mListener);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item currentItem = mItemsList.get(position);

        holder.mImageView.setImageResource(currentItem.getImg());
        holder.mTextView.setText(currentItem.getName());
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private Filter mFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Item>filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(mItemsListFull);
            }
            else {
                String filterPattern =  constraint.toString().toLowerCase().trim();

                for(Item item : mItemsListFull){
                    if(item.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mItemsList.clear();
            mItemsList.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };
}
