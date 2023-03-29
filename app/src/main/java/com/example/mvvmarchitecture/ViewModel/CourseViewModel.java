package com.example.mvvmarchitecture.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmarchitecture.Models.CourseModel;
import com.example.mvvmarchitecture.Models.CourseSectionModel;
import com.example.mvvmarchitecture.Repository.CourseSectionRepository;

import java.util.List;

public class CourseViewModel extends ViewModel {

    CourseSectionRepository repo = new CourseSectionRepository();

    public LiveData<List<CourseModel>> getCourse()
    {
        return repo.getCourse();
    }

    public LiveData<List<CourseSectionModel>>getCourseSection()
    {
        return repo.getCourseSection();
    }


}
