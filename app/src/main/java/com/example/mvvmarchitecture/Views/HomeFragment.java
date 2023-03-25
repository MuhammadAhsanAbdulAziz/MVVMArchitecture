package com.example.mvvmarchitecture.Views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmarchitecture.Adapters.CourseAdapter;
import com.example.mvvmarchitecture.Models.CourseModel;
import com.example.mvvmarchitecture.R;
import com.example.mvvmarchitecture.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    CourseAdapter adp;
    ArrayList<CourseModel> data = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

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

        data.clear();
        data.add(new CourseModel("1","HTML","Behtreen course",""));
        data.add(new CourseModel("2","HTML","Behtreen course",""));
        data.add(new CourseModel("3","HTML","Behtreen course",""));
        data.add(new CourseModel("4","HTML","Behtreen course",""));
        data.add(new CourseModel("5","HTML","Behtreen course",""));

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        binding.courselist.setLayoutManager(linearLayoutManager);
        adp = new CourseAdapter(getContext(),data);
        binding.courselist.setAdapter(adp);
        return binding.getRoot();
    }


}