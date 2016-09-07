package com.nlte.cloudnotes.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.astuetz.PagerSlidingTabStrip;
import com.nlte.cloudnotes.EditActivity;
import com.nlte.cloudnotes.R;
import com.nlte.cloudnotes.adapter.ChildContainerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerNotesFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private ViewPager mVpContainer;
    private View mView;
    private PagerSlidingTabStrip tabs;
    private static final int REQUEST_ADD = 1;//打开editactivity请求码
    private int currentPagerPosition = 0;//当前ViewPager的位置

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
        mVpContainer.addOnPageChangeListener(this);

        tabs = (PagerSlidingTabStrip) mView.findViewById(R.id.tabs);
        tabs.setViewPager(mVpContainer);//tab与viewpager关联
        //tabs.setTextSize(18);//设置tab字体大小
        tabs.setTextColor(R.color.tabColor);//设置字体颜色

        FloatingActionButton fab = (FloatingActionButton) mView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), EditActivity.class),  REQUEST_ADD);
            }
        });
    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.fragment_per_notes_menu, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        System.out.println("+++++");
        MenuItem menuItem = menu.findItem(R.id.action_search);

        System.out.println("+++++++++"+currentPagerPosition);
        switch (currentPagerPosition){
            case 1:
                menuItem.setVisible(false);
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPagerPosition = position;
        //
        mVpContainer.postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().getWindow().invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
            }
        }, 500);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
