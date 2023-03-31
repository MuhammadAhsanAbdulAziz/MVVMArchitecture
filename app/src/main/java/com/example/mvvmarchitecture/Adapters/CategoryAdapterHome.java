package com.example.mvvmarchitecture.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmarchitecture.databinding.CategoryBoxBinding;
import com.example.mvvmarchitecture.databinding.CategoryRowBinding;
import com.example.mvvmarchitecture.models.CategoryModel;

public class CategoryAdapterHome extends ListAdapter<CategoryModel, CategoryAdapterHome.ViewHolder> {


    public CategoryAdapterHome() {
        super(CategoryModel.categoryModelItemCallback);
    }

    @NonNull
    @Override
    public CategoryAdapterHome.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        CategoryBoxBinding binding = CategoryBoxBinding.inflate(layout,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapterHome.ViewHolder holder, int position) {
        CategoryModel data = getItem(position);
        holder.binding.setCategory(data);

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CategoryBoxBinding binding;
        public ViewHolder(CategoryBoxBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }
    }
}
