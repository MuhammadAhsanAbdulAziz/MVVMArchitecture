package com.example.mvvmarchitecture.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmarchitecture.databinding.CourseRowBinding;
import com.example.mvvmarchitecture.models.CourseSectionModel;

public class CourseSectionAdapter extends ListAdapter<CourseSectionModel,CourseSectionAdapter.ViewHolder> {


    public CourseSectionAdapter() {
        super(CourseSectionModel.courseSectionModelItemCallback);
    }

    @NonNull
    @Override
    public CourseSectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        CourseRowBinding binding = CourseRowBinding.inflate(layout,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseSectionAdapter.ViewHolder holder, int position) {
        CourseSectionModel data = getItem(position);
        holder.binding.category.setText(data.getCategory());
        CourseAdapter c = new CourseAdapter();

        holder.binding.courses.setAdapter(c);

        c.submitList(data.getCourseList());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CourseRowBinding binding;

        public ViewHolder(CourseRowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }
    }
}
