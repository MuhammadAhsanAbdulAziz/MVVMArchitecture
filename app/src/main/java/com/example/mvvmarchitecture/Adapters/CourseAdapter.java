package com.example.mvvmarchitecture.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmarchitecture.databinding.CourseBoxBinding;
import com.example.mvvmarchitecture.models.CourseModel;

public class CourseAdapter extends ListAdapter<CourseModel, CourseAdapter.ViewHolder> {


    public CourseAdapter() {
        super(CourseModel.courseModelItemCallback);
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        CourseBoxBinding binding = CourseBoxBinding.inflate(layout, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        CourseModel data = getItem(position);
        holder.binding.coursename.setText(data.getName());
        holder.binding.coursedescription.setText(data.getDescription());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        CourseBoxBinding binding;

        public ViewHolder(CourseBoxBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }

    }
}
