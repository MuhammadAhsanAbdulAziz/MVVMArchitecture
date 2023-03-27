package com.example.mvvmarchitecture.Models;

import java.util.ArrayList;

public class CourseSectionModel {
    String Category;
    ArrayList<CourseModel> CourseList = new ArrayList<>();

    public CourseSectionModel(String category, ArrayList<CourseModel> courseList) {
        Category = category;
        CourseList = courseList;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public ArrayList<CourseModel> getCourseList() {
        return CourseList;
    }

    public void setCourseList(ArrayList<CourseModel> courseList) {
        CourseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSectionModel that = (CourseSectionModel) o;
        return getCategory().equals(that.getCategory()) && getCourseList().equals(that.getCourseList());
    }

    @Override
    public String toString() {
        return "CourseSectionModel{" +
                "Category='" + Category + '\'' +
                ", CourseList=" + CourseList +
                '}';
    }
}
