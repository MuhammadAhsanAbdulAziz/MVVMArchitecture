package com.example.mvvmarchitecture.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmarchitecture.databinding.CategoryRowBinding;
import com.example.mvvmarchitecture.models.CategoryModel;

public class CategoryAdapter extends ListAdapter<CategoryModel, CategoryAdapter.ViewHolder> {


    public CategoryAdapter() {
        super(CategoryModel.categoryModelItemCallback);
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        CategoryRowBinding binding = CategoryRowBinding.inflate(layout,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        CategoryModel data = getItem(position);
        holder.binding.setCategory(data);

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CategoryRowBinding binding;
        public ViewHolder(CategoryRowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }
    }
}
