package com.example.mvvmarchitecture.Views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmarchitecture.Adapters.CourseAdapter;
import com.example.mvvmarchitecture.Adapters.CourseSectionAdapter;
import com.example.mvvmarchitecture.Models.CourseModel;
import com.example.mvvmarchitecture.Models.CourseSectionModel;
import com.example.mvvmarchitecture.R;
import com.example.mvvmarchitecture.databinding.FragmentHomeBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    CourseSectionAdapter adp;
    ArrayList<CourseSectionModel> data = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater,container,false);

        ArrayList<CourseModel>dev = new ArrayList<>();
        dev.add(new CourseModel("0","HTML1","Markup Lanugage",""));
        dev.add(new CourseModel("0","HTML2","Markup Lanugage",""));
        dev.add(new CourseModel("0","HTML3","Markup Lanugage",""));

        data.add(new CourseSectionModel("Development",dev));
        data.add(new CourseSectionModel("Marketing",dev));

        adp = new CourseSectionAdapter(getContext(),data);
        binding.courselist.setAdapter(adp);
        return binding.getRoot();
    }


}