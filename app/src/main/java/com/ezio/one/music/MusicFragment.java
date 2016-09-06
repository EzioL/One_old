package com.ezio.one.music;
import android.support.v4.app.Fragment;
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

public class MusicFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fagment_music,null);
        ButterKnife.bind(view);
        return view;
    }
}
