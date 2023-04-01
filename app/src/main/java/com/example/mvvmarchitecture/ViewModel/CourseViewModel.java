package com.example.mvvmarchitecture.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmarchitecture.models.CourseModel;
import com.example.mvvmarchitecture.models.CourseSectionModel;
import com.example.mvvmarchitecture.Repository.CourseSectionRepository;

import java.util.List;

public class CourseViewModel extends ViewModel {

    CourseSectionRepository repo = new CourseSectionRepository();

    String Category;

    public CourseSectionRepository getRepo() {
        return repo;
    }

    public void setRepo(CourseSectionRepository repo) {
        this.repo = repo;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public LiveData<List<CourseModel>> getCourse()
    {
        return repo.getCourse();
    }

    public LiveData<List<CourseSectionModel>>getCourseSection()
    {
        return repo.getCourseSection();
    }


}
