package com.sro.androidapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sro.androidapp.R;
import com.sro.androidapp.model.DataModel;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.MyViewHolder> {
    Context context;
    List<DataModel> list;

    public itemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public itemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapter.MyViewHolder holder, int position) {
        DataModel dataModel = list.get(position);
        holder.body.setText(dataModel.getBody());
        holder.id.setText(dataModel.getId());
        holder.userid.setText(dataModel.getUserId());
        holder.title.setText(dataModel.getTitle());

    }

    public void getAllItems(List<DataModel> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView userid;
        public TextView title;
        public TextView body;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            userid = itemView.findViewById(R.id.userid);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
