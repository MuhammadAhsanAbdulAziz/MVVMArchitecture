package com.example.mvvmarchitecture.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmarchitecture.databinding.CourseBoxBinding;
import com.example.mvvmarchitecture.interfaces.CourseInterface;
import com.example.mvvmarchitecture.models.CourseModel;

public class CourseAdapter extends ListAdapter<CourseModel, CourseAdapter.ViewHolder> {

    CourseInterface courseInterface;

    public CourseAdapter(CourseInterface courseInterface) {
        super(CourseModel.courseModelItemCallback);
        this.courseInterface = courseInterface;
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
        holder.binding.setCourseDetail(courseInterface);
        holder.binding.setCourse(data);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        CourseBoxBinding binding;

        public ViewHolder(CourseBoxBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }

    }
}
