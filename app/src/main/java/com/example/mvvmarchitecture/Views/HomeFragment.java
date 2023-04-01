package com.example.mvvmarchitecture.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmarchitecture.Adapters.CategoryAdapterHome;
import com.example.mvvmarchitecture.Adapters.CourseSectionAdapter;
import com.example.mvvmarchitecture.R;
import com.example.mvvmarchitecture.viewModel.CategoryViewModel;
import com.example.mvvmarchitecture.databinding.FragmentHomeBinding;
import com.example.mvvmarchitecture.interfaces.CourseInterface;
import com.example.mvvmarchitecture.models.CategoryModel;
import com.example.mvvmarchitecture.models.CourseModel;
import com.example.mvvmarchitecture.models.CourseSectionModel;
import com.example.mvvmarchitecture.viewModel.CourseViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements CourseInterface{

    CourseSectionAdapter adp;
    CategoryAdapterHome categoryAdapterHome;
    CourseViewModel courseviewModel;
    CategoryViewModel categoryViewModel;
    NavController navController;


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

        categoryAdapterHome = new CategoryAdapterHome(this);

        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater, container, false);


        adp = new CourseSectionAdapter(this);
        binding.courselist.setAdapter(adp);
        binding.CatList.setAdapter(categoryAdapterHome);
        binding.moreCatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_homeFragment_to_moreCategoryFragment);
            }
        });


        courseviewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);

        courseviewModel.getCourseSection().observe(requireActivity(), new Observer<List<CourseSectionModel>>() {
            @Override
            public void onChanged(List<CourseSectionModel> courseSectionModels) {
                adp.submitList(courseSectionModels);
            }
        });

        categoryViewModel = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);

        categoryViewModel.getCategory().observe(requireActivity(), new Observer<List<CategoryModel>>() {
            @Override
            public void onChanged(List<CategoryModel> categoryModels) {
                ArrayList<CategoryModel> filteredList = new ArrayList<>();
                int count = 0;
                for (CategoryModel cat : categoryModels) {
                    if (count < 3) {
                        filteredList.add(cat);
                        count++;
                    }
                }
                categoryAdapterHome.submitList(filteredList);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Override
    public void moreCourses(String category) {
        courseviewModel.setCategory(category);
        navController.navigate(R.id.action_homeFragment_to_moreCoursesFragment);
    }

    @Override
    public void CourseDetail(CourseModel Course) {
        courseviewModel.setCourseModel(Course);
        navController.navigate(R.id.action_homeFragment_to_courseDetailsFragment);
    }

}