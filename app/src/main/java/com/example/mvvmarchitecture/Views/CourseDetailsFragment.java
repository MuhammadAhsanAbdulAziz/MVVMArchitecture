package com.example.mvvmarchitecture.Views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mvvmarchitecture.R;

public class CourseDetailsFragment extends Fragment {

    ImageButton dropdown;
    TextView description;

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

        View v = inflater.inflate(R.layout.fragment_course_details, container, false);

        description = v.findViewById(R.id.description);
        dropdown = v.findViewById(R.id.toggle);

        return v;
    }


    void toggle(View view) {
        if (description.getMaxLines() == 4) {
            description.setMaxLines(5);
            dropdown.setRotation(50);
        } else {
            description.setMaxLines(2);
        }
    }
}