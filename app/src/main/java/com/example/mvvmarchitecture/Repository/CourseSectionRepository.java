package com.example.mvvmarchitecture.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmarchitecture.Models.CourseModel;
import com.example.mvvmarchitecture.Models.CourseSectionModel;

import java.util.ArrayList;
import java.util.List;

public class CourseSectionRepository {

    MutableLiveData<List<CourseSectionModel>> CourseSectionLiveData;
    MutableLiveData<List<CourseModel>> CourseLiveData;
    ArrayList<CourseModel> dev;


    public LiveData<List<CourseModel>> getCourse() {
        CourseLiveData = new MutableLiveData<>();

        CourseLiveData.setValue(dev);
        return CourseLiveData;
    }

    public LiveData<List<CourseSectionModel>> getCourseSection() {
        CourseSectionLiveData = new MutableLiveData<>();
        dev = new ArrayList<>();
        dev.add(new CourseModel("0", "HTML1", "Markup Lanugage", ""));
        dev.add(new CourseModel("0", "HTML2", "Markup Lanugage", ""));
        dev.add(new CourseModel("0", "HTML3", "Markup Lanugage", ""));


        ArrayList<CourseSectionModel> data = new ArrayList<CourseSectionModel>();
        data.add(new CourseSectionModel("Development", dev));
        data.add(new CourseSectionModel("Marketing", dev));

        CourseSectionLiveData.setValue(data);
        return CourseSectionLiveData;

    }


}
