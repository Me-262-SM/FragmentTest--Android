package com.edu.sicnu.cs.zzy.fragmenttest.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.sicnu.cs.zzy.fragmenttest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_1 extends Fragment {


    public Fragment_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_1, container, false);
        TabLayout tabLayout = view.findViewById(R.id.mytab);
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        List<String> mTitle = new ArrayList<>();
        mTitle.add("选项1");
        mTitle.add("选项2");
        mTitle.add("选项3");
        List<Fragment> mFragment = new ArrayList<>();
        mFragment.add(new Fragment_1_1());
        mFragment.add(new Fragment_1_2());
        mFragment.add(new Fragment_1_3());

        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getFragmentManager(),mTitle,mFragment);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    //派生一个适配器
    class MyPagerAdapter extends FragmentStatePagerAdapter {

        List<String> mTitle;
        List<Fragment> mFragment;

        public MyPagerAdapter(FragmentManager fm, List<String> mTitle, List<Fragment> mFragment) {
            super(fm);
            this.mTitle = mTitle;
            this.mFragment = mFragment;
        }

        @Override
        public Fragment getItem(int i) {
            return mFragment.get(i);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle.get(position);
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }
    }


}
