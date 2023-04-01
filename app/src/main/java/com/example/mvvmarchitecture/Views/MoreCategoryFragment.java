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

import com.example.mvvmarchitecture.Adapters.CategoryAdapter;
import com.example.mvvmarchitecture.R;
import com.example.mvvmarchitecture.databinding.FragmentMoreCategoryBinding;
import com.example.mvvmarchitecture.interfaces.CourseInterface;
import com.example.mvvmarchitecture.models.CategoryModel;
import com.example.mvvmarchitecture.models.CourseModel;
import com.example.mvvmarchitecture.viewModel.CategoryViewModel;
import com.example.mvvmarchitecture.viewModel.CourseViewModel;

import java.util.List;

public class MoreCategoryFragment extends Fragment implements CourseInterface {

    FragmentMoreCategoryBinding binding;
    CategoryAdapter adp;
    CategoryViewModel viewModel;
    CourseViewModel courseViewModel;
    NavController navController;

    public MoreCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoreCategoryBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        adp = new CategoryAdapter(this);
        binding.categoryList.setAdapter(adp);

        viewModel = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);

        viewModel.getCategory().observe(requireActivity(), new Observer<List<CategoryModel>>() {
            @Override
            public void onChanged(List<CategoryModel> categoryModels) {
                adp.submitList(categoryModels);
            }
        });

    }

    @Override
    public void moreCourses(String category) {
        courseViewModel.setCategory(category);
        navController.navigate(R.id.action_moreCategoryFragment_to_moreCoursesFragment);
    }

    @Override
    public void CourseDetail(CourseModel Course) {

    }
}