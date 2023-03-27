package com.example.mvvmarchitecture.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmarchitecture.Models.CourseModel;
import com.example.mvvmarchitecture.Models.CourseSectionModel;
import com.example.mvvmarchitecture.R;

import java.util.ArrayList;

public class CourseSectionAdapter extends RecyclerView.Adapter<CourseSectionAdapter.ViewHolder> {
    Context context;
    ArrayList<CourseSectionModel> data = new ArrayList<>();

    public CourseSectionAdapter(Context context, ArrayList<CourseSectionModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CourseSectionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.course_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseSectionAdapter.ViewHolder holder, int position) {
        String category = data.get(position).getCategory();
        CourseAdapter c = new CourseAdapter(context,data.get(position).getCourseList());

        holder.setData(category,c);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Category;
        RecyclerView courses;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Category = itemView.findViewById(R.id.category);
            courses = itemView.findViewById(R.id.courses);
        }

        public void setData(String category,CourseAdapter c) {
            Category.setText(category);
            courses.setAdapter(c);

        }
    }
}
