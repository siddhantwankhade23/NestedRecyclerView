package com.example.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nestedrecyclerview.databinding.LayoutChildRvBinding;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {


    private Context context;
    private List<MyPojo> myPojoListChild;

    public ChildAdapter(Context context, List<MyPojo> myPojoListChild) {
        this.context = context;
        this.myPojoListChild = myPojoListChild;
    }

    @NonNull
    @Override
    public ChildAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutChildRvBinding childRvBinding = LayoutChildRvBinding.inflate(LayoutInflater.from(context));

        return new ChildAdapter.ViewHolder(childRvBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.ViewHolder holder, int position) {

        MyPojo myPojo = myPojoListChild.get(position);

        Glide.with(context).load(myPojo.getDownload_url()).into(holder.childRvBinding.imageView);

    }

    @Override
    public int getItemCount() {
        return myPojoListChild.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LayoutChildRvBinding childRvBinding;

        public ViewHolder(@NonNull LayoutChildRvBinding childRvBinding) {
            super(childRvBinding.getRoot());
            this.childRvBinding = childRvBinding;
        }
    }
}

