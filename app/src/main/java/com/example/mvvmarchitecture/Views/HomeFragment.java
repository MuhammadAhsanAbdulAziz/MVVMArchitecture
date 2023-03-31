package com.example.mvvmarchitecture.Views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmarchitecture.Adapters.CategoryAdapter;
import com.example.mvvmarchitecture.Adapters.CategoryAdapterHome;
import com.example.mvvmarchitecture.Adapters.CourseSectionAdapter;
import com.example.mvvmarchitecture.ViewModel.CategoryViewModel;
import com.example.mvvmarchitecture.databinding.FragmentHomeBinding;
import com.example.mvvmarchitecture.models.CategoryModel;
import com.example.mvvmarchitecture.models.CourseSectionModel;
import com.example.mvvmarchitecture.ViewModel.CourseViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    CourseSectionAdapter adp;
    CategoryAdapterHome categoryAdapterHome;
    CourseViewModel viewModel;
    CategoryViewModel categoryViewModel;




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

        categoryAdapterHome = new CategoryAdapterHome();

        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater,container,false);


        adp = new CourseSectionAdapter();
        binding.courselist.setAdapter(adp);
        binding.CatList.setAdapter(categoryAdapterHome);

        viewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);

        viewModel.getCourseSection().observe(requireActivity(), new Observer<List<CourseSectionModel>>() {
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
                for(CategoryModel cat : categoryModels)
                {
                    if(count < 3)
                    {
                        filteredList.add(cat);
                        count++;
                    }
                }
                categoryAdapterHome.submitList(filteredList);
            }
        });

        return binding.getRoot();
    }


}