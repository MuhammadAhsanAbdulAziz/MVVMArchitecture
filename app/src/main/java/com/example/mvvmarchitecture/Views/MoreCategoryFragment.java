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
import com.example.mvvmarchitecture.databinding.FragmentMoreCategoryBinding;
import com.example.mvvmarchitecture.models.CategoryModel;
import com.example.mvvmarchitecture.viewModel.CategoryViewModel;

import java.util.List;

public class MoreCategoryFragment extends Fragment {

    FragmentMoreCategoryBinding binding;
    CategoryAdapter adp;
    CategoryViewModel viewModel;

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

        adp = new CategoryAdapter();
        binding.categoryList.setAdapter(adp);

        viewModel = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);

        viewModel.getCategory().observe(requireActivity(), new Observer<List<CategoryModel>>() {
            @Override
            public void onChanged(List<CategoryModel> categoryModels) {
                adp.submitList(categoryModels);
            }
        });

    }
}