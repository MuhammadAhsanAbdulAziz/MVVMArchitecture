package com.example.mvvmarchitecture.models;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class CategoryModel {
    String id,Name,Image;

    public CategoryModel(String id, String name, String image) {
        this.id = id;
        Name = name;
        Image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", Image='" + Image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryModel that = (CategoryModel) o;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && Objects.equals(getImage(), that.getImage());
    }

    public static DiffUtil.ItemCallback<CategoryModel> categoryModelItemCallback
            = new DiffUtil.ItemCallback<CategoryModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull CategoryModel oldItem, @NonNull CategoryModel newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull CategoryModel oldItem, @NonNull CategoryModel newItem) {
            return oldItem.equals(newItem);
        }
    };
}
