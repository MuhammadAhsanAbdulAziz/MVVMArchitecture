package com.example.mvvmarchitecture.Models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class CourseModel {
    private String id, name, description, picture;

    public CourseModel(String id, String name, String description, String picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseModel that = (CourseModel) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getDescription().equals(that.getDescription()) && Objects.equals(getPicture(), that.getPicture());
    }

    public static DiffUtil.ItemCallback<CourseModel> courseModelItemCallback =
            new DiffUtil.ItemCallback<CourseModel>() {
                @Override
                public boolean areItemsTheSame(@NonNull CourseModel oldItem, @NonNull CourseModel newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }

                @Override
                public boolean areContentsTheSame(@NonNull CourseModel oldItem, @NonNull CourseModel newItem) {
                    return oldItem.equals(newItem);
                }
            };
}
