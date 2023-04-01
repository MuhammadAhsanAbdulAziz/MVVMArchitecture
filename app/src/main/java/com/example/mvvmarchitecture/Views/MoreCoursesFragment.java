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

import com.example.mvvmarchitecture.Adapters.CourseAdapter;
import com.example.mvvmarchitecture.R;
import com.example.mvvmarchitecture.viewModel.CourseViewModel;
import com.example.mvvmarchitecture.databinding.FragmentMoreCoursesBinding;
import com.example.mvvmarchitecture.interfaces.CourseInterface;
import com.example.mvvmarchitecture.models.CourseModel;
import com.example.mvvmarchitecture.models.CourseSectionModel;

import java.util.List;

public class MoreCoursesFragment extends Fragment implements CourseInterface {

    FragmentMoreCoursesBinding binding;
    CourseAdapter adp;
    CourseViewModel viewModel;
    NavController navController;

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

        navController = Navigation.findNavController(view);

        adp = new CourseAdapter(this);
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

    @Override
    public void moreCourses(String category) {

    }

    @Override
    public void CourseDetail(CourseModel Course) {
        viewModel.setCourseModel(Course);
        navController.navigate(R.id.action_moreCoursesFragment_to_courseDetailsFragment);
    }
}