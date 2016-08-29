package com.nlte.cloudnotes.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nlte.cloudnotes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildLabelFragment extends Fragment {


    public ChildLabelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child_label, container, false);
    }

}
