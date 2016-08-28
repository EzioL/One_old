package com.ezio.one.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezio.one.R;

import butterknife.ButterKnife;

/**
 * Created by Ezio on 2016/8/28.
 */

public class ReadingFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fagment_reading,null);
        ButterKnife.bind(view);
        return view;
    }
}
