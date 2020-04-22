package com.example.recyclerview_viewbinding;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_viewbinding.databinding.RecyclerRowBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";
    private List<String> stringList = new ArrayList<>();

    public void updateList(List<String> stringList) {
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + stringList.size());
        return stringList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerRowBinding recyclerRowBinding;

        public ViewHolder(@NonNull RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;

            recyclerRowBinding.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: " + getAdapterPosition());
                }
            });
        }

        public void bindView(String title) {
            recyclerRowBinding.textView.setText(title);
        }
    }
}
