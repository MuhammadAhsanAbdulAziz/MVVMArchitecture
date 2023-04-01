package com.example.mvvmarchitecture.interfaces;

import com.example.mvvmarchitecture.models.CourseModel;
import com.example.mvvmarchitecture.models.CourseSectionModel;

public interface CourseInterface {

    public void moreCourses(String category);

    public void CourseDetail(CourseModel Course);
}
