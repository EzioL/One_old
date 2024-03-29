package com.ezio.one.movie;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ezio.one.R;

import butterknife.ButterKnife;

/**
 * Created by Ezio on 2016/8/28.
 */

public class MovieFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fagment_movie,null);
        ButterKnife.bind(view);
        ImageView image = (ImageView) view.findViewById(R.id.loading);
        image.setBackgroundResource(R.drawable.loading);
        AnimationDrawable animation = (AnimationDrawable) image.getBackground();
        animation.start();
        return view;
    }
}
