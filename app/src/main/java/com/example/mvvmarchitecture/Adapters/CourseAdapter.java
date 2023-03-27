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
import com.example.mvvmarchitecture.R;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    Context context;
    ArrayList<CourseModel> data = new ArrayList<>();

    public CourseAdapter(Context context, ArrayList<CourseModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.course_box, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        String Name = data.get(position).getName();
        String Description = data.get(position).getDescription();
        String Picture = data.get(position).getPicture();

        holder.setData(Name, Description, Picture);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView Tname, Tdescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Tname = itemView.findViewById(R.id.coursename);
            imageView = itemView.findViewById(R.id.courseimg);
            Tdescription = itemView.findViewById(R.id.coursedescription);
        }

        public void setData(String name, String des, String image) {
            Tname.setText(name);
            Tdescription.setText(des);
            Glide.with(context).load(image).error(R.drawable.ic_launcher_background).dontAnimate().into(imageView);

        }
    }
}
