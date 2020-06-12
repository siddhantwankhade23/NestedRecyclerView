package com.example.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.databinding.LayoutParentRvBinding;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ViewHolder> {


    private Context context;
    private List<List<MyPojo>> myPojoListParent;

    private LinearLayoutManager linearLayoutManager;

    public ParentAdapter(Context context, List<List<MyPojo>> myPojoListParent) {
        this.context = context;
        this.myPojoListParent = myPojoListParent;



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutParentRvBinding parentRvBinding = LayoutParentRvBinding.inflate(LayoutInflater.from(context));

        return new ViewHolder(parentRvBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        List <MyPojo> myPojoListChild = myPojoListParent.get(position);

        holder.itemBinding.tvTitle.setText("Recycler View "+(++position));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        holder.itemBinding.rvChild.setLayoutManager(linearLayoutManager);

        ChildAdapter childAdapter = new ChildAdapter(context,myPojoListChild);

        holder.itemBinding.rvChild.setAdapter(childAdapter);

    }

    @Override
    public int getItemCount() {
        return myPojoListParent.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        LayoutParentRvBinding itemBinding;

        public ViewHolder(@NonNull LayoutParentRvBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
