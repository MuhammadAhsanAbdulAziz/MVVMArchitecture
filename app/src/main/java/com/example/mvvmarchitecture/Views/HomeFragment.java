package com.example.mvvmarchitecture.Views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
import com.example.mvvmarchitecture.ViewModel.CourseViewModel;
import com.example.mvvmarchitecture.databinding.FragmentHomeBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    CourseSectionAdapter adp;
    CourseViewModel viewModel;


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







        viewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);

        viewModel.getCourseSection().observe(requireActivity(), new Observer<List<CourseSectionModel>>() {
            @Override
            public void onChanged(List<CourseSectionModel> courseSectionModels) {
                adp.submitList(courseSectionModels);
            }
        });
        adp = new CourseSectionAdapter();
        binding.courselist.setAdapter(adp);

        return binding.getRoot();
    }


}