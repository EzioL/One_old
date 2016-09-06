package com.ezio.one;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ezio.one.home.HomeFragment;
import com.ezio.one.movie.MovieFragment;
import com.ezio.one.music.MusicFragment;
import com.ezio.one.reading.ReadingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import common.BaseActivity;


public class MainActivity extends BaseActivity {
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.btn_home)
    RadioButton btnHome;
    @Bind(R.id.btn_reading)
    RadioButton btnReading;
    @Bind(R.id.btn_music)
    RadioButton btnMusic;
    @Bind(R.id.btn_movie)
    RadioButton btnMovie;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;
    @Bind(R.id.content)
    FrameLayout content;
    private HomeFragment mHomeFragment;
    private ReadingFragment mReadingFragment;
    private MusicFragment mMusicFragment;
    private MovieFragment mMovieFragment;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initListener();

    }

    private void initView() {
        initToolbarWithSearch("ONE", null);
        //默认显示首页
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        mHomeFragment = new HomeFragment();
        ft.add(R.id.content, mHomeFragment).commit();;
        currentFragment = mHomeFragment;
    }

    private void initListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_home:
                        setToolbarTitle("ONE");
                        if (mHomeFragment == null) {
                            mHomeFragment = new HomeFragment();
                        }
                        switchFragment(currentFragment, mHomeFragment);
                        break;

                    case R.id.btn_reading:
                        setToolbarTitle("阅读");
                        if (mReadingFragment == null) {
                            mReadingFragment = new ReadingFragment();
                        }
                        switchFragment(currentFragment, mReadingFragment);
                        break;

                    case R.id.btn_music:
                        setToolbarTitle("音乐");
                        if (mMusicFragment == null) {
                            mMusicFragment = new MusicFragment();
                        }
                        switchFragment(currentFragment, mMusicFragment);
                        break;

                    case R.id.btn_movie:
                        setToolbarTitle("电影");
                        if (mMovieFragment == null) {
                            mMovieFragment = new MovieFragment();
                        }
                        switchFragment(currentFragment, mMovieFragment);
                        break;

                }
            }
        });
    }

    public void switchFragment(Fragment from, Fragment to) {
        if (currentFragment != to) {
            currentFragment = to;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                ft.hide(from).add(R.id.content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                ft.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }
}
