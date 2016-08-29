package com.nlte.cloudnotes.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.nlte.cloudnotes.R;
import com.nlte.cloudnotes.adapter.ChildContainerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerNotesFragment extends Fragment {

    private ViewPager mVpContainer;
    private View mView;
    private PagerSlidingTabStrip tabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_per_notes, container, false);
        setHasOptionsMenu(true);

        //界面初始化
        initView();

        return mView;
    }

    /**
     * 界面初始化
     */
    private void initView() {

        mVpContainer = (ViewPager) mView.findViewById(R.id.vp_per_notes_container);
        mVpContainer.setAdapter(new ChildContainerAdapter(getChildFragmentManager()));

        tabs = (PagerSlidingTabStrip) mView.findViewById(R.id.tabs);
        tabs.setViewPager(mVpContainer);//tab与viewpager关联
        tabs.setTextSize(28);//设置tab字体大小
        tabs.setTextColor(R.color.tabColor);

        FloatingActionButton fab = (FloatingActionButton) mView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_per_notes_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
