package com.example.mvvmarchitecture.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmarchitecture.models.CourseModel;
import com.example.mvvmarchitecture.models.CourseSectionModel;

import java.util.ArrayList;
import java.util.List;

public class CourseSectionRepository {

    MutableLiveData<List<CourseSectionModel>> CourseSectionLiveData;
    MutableLiveData<List<CourseModel>> CourseLiveData;
    ArrayList<CourseModel> dev;
    ArrayList<CourseModel> mar;

    public LiveData<List<CourseModel>> getCourse() {
        CourseLiveData = new MutableLiveData<>();
        dev = new ArrayList<>();
        dev.add(new CourseModel("0", "HTML1", "Markup Lanugage", ""));
        dev.add(new CourseModel("1", "HTML2", "Markup Lanugage", ""));
        dev.add(new CourseModel("2", "HTML3", "Markup Lanugage", ""));
        dev.add(new CourseModel("3", "HTML4", "Markup Lanugage", ""));
        dev.add(new CourseModel("4", "HTML5", "Markup Lanugage", ""));
        CourseLiveData.setValue(dev);
        return CourseLiveData;
    }


    public LiveData<List<CourseSectionModel>> getCourseSection() {
        CourseSectionLiveData = new MutableLiveData<>();
        dev = new ArrayList<>();
        dev.add(new CourseModel("0", "HTML1", "Markup Lanugage", ""));
        dev.add(new CourseModel("1", "HTML2", "Markup Lanugage", ""));
        dev.add(new CourseModel("2", "HTML3", "Markup Lanugage", ""));
        dev.add(new CourseModel("3", "HTML4", "Markup Lanugage", ""));
        dev.add(new CourseModel("4", "HTML5", "Markup Lanugage", ""));
        dev.add(new CourseModel("5", "HTML5", "Markup Lanugage", ""));

        mar = new ArrayList<>();
        mar.add(new CourseModel("0", "DM", "Digital Marketing", ""));
        mar.add(new CourseModel("1", "DM", "Digital Marketing", ""));
        mar.add(new CourseModel("2", "DM", "Digital Marketing", ""));
        mar.add(new CourseModel("3", "DM", "Digital Marketing", ""));
        mar.add(new CourseModel("4", "DM", "Digital Marketing", ""));
        mar.add(new CourseModel("5", "DM", "Digital Marketing", ""));


        ArrayList<CourseSectionModel> data = new ArrayList<CourseSectionModel>();
        data.add(new CourseSectionModel("Development", dev));
        data.add(new CourseSectionModel("Marketing", mar));

        CourseSectionLiveData.setValue(data);
        return CourseSectionLiveData;

    }





}
