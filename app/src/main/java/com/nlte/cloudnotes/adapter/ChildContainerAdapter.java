package com.nlte.cloudnotes.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nlte.cloudnotes.fragment.ChildFolderFragment;
import com.nlte.cloudnotes.fragment.ChildLabelFragment;
import com.nlte.cloudnotes.fragment.ChildRecentFragment;

/**
 * 个人笔记子Fragment适配器
 * NLTE on 2016/8/28 0028 23:21
 */
public class ChildContainerAdapter extends FragmentPagerAdapter {

    String[] titles = {"近期", "文件夹", "标签"};

    ChildFolderFragment childFolderFragment;//文件夹
    ChildLabelFragment childLabelFragment;//标签
    ChildRecentFragment childRecentFragment;//近期

    public ChildContainerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                childRecentFragment = new ChildRecentFragment();
                return childRecentFragment;
            case 1:
                childFolderFragment = new ChildFolderFragment();
                return childFolderFragment;
            case 2:
                childLabelFragment = new ChildLabelFragment();
                return childLabelFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
