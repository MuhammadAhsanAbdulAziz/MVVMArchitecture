package com.example.mvvmarchitecture.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmarchitecture.Adapters.CategoryAdapter;
import com.example.mvvmarchitecture.Adapters.CourseAdapter;
import com.example.mvvmarchitecture.R;
import com.example.mvvmarchitecture.ViewModel.CategoryViewModel;
import com.example.mvvmarchitecture.ViewModel.CourseViewModel;
import com.example.mvvmarchitecture.databinding.FragmentMoreCategoryBinding;
import com.example.mvvmarchitecture.databinding.FragmentMoreCoursesBinding;
import com.example.mvvmarchitecture.models.CategoryModel;
import com.example.mvvmarchitecture.models.CourseSectionModel;

import java.util.List;

public class MoreCoursesFragment extends Fragment {

    FragmentMoreCoursesBinding binding;
    CourseAdapter adp;
    CourseViewModel viewModel;

    public MoreCoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoreCoursesBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adp = new CourseAdapter();
        binding.MoreCourseList.setAdapter(adp);

        viewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);

        String category = viewModel.getCategory();

        viewModel.getCourseSection().observe(requireActivity(), new Observer<List<CourseSectionModel>>() {
            @Override
            public void onChanged(List<CourseSectionModel> courseSectionModels) {
                for(CourseSectionModel model : courseSectionModels)
                {
                    if(model.getCategory().equals(category))
                    {
                        adp.submitList(model.getCourseList());
                    }
                }
            }
        });

    }
}