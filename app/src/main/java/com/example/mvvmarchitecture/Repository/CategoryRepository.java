package com.example.mvvmarchitecture.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmarchitecture.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    MutableLiveData<List<CategoryModel>> catlist;

    public LiveData<List<CategoryModel>>getCategory()
    {
        catlist = new MutableLiveData<>();
        ArrayList<CategoryModel> data = new ArrayList<CategoryModel>();

        data.add(new CategoryModel("0","Marketing",""));
        data.add(new CategoryModel("1","Development",""));
        data.add(new CategoryModel("2","Economics",""));
        data.add(new CategoryModel("3","Designing",""));
        data.add(new CategoryModel("4","Ecommerce",""));

        catlist.setValue(data);
        return catlist;
    }
}
