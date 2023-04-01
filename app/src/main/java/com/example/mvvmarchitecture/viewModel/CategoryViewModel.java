package com.example.mvvmarchitecture.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmarchitecture.models.CategoryModel;
import com.example.mvvmarchitecture.Repository.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    CategoryRepository repo = new CategoryRepository();

    public LiveData<List<CategoryModel>> getCategory()
    {
        return repo.getCategory();
    }



}
