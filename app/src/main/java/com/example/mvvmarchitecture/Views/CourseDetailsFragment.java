package com.example.mvvmarchitecture.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmarchitecture.viewModel.CourseViewModel;
import com.example.mvvmarchitecture.databinding.FragmentCourseDetailsBinding;

public class CourseDetailsFragment extends Fragment {

    FragmentCourseDetailsBinding binding;
    CourseViewModel viewModel;

    public CourseDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCourseDetailsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);
        binding.setCourseDetail(viewModel);
    }

    //    void toggle(View view) {
//        if (description.getMaxLines() == 4) {
//            description.setMaxLines(5);
//            dropdown.setRotation(50);
//        } else {
//            description.setMaxLines(2);
//        }
//    }
}