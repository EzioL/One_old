package com.ezio.one.home;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezio.one.R;
import com.ezio.one.home.adapter.HomeViewPagerAdapter;
import com.ezio.one.home.fragment.HomePagerFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ezio on 2016/8/28.
 */

public class HomeFragment extends Fragment {
    View view;
    ViewPager viewPager;
    HomeViewPagerAdapter adapter;
    List<Fragment> fragmentList;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fagment_home, null);
        ButterKnife.bind(view);
        initView();
        return view;
    }

    private void initView() {
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        fragmentList = new ArrayList<Fragment>();
        for (int i = 0; i < 10; i++) {
            HomePagerFragment fragment = new HomePagerFragment();
            fragmentList.add(fragment);
        }
        adapter = new HomeViewPagerAdapter(getFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
