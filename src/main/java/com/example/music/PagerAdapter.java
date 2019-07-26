package com.example.music;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.music.fragment.Matching;
import com.example.music.fragment.Playing;
import com.example.music.fragment.SongList;

public class PagerAdapter extends FragmentStatePagerAdapter {

    Context mContext;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new SongList();
                break;
            case 1:
                fragment = new Playing();
                break;
            case 2:
                fragment = new Matching();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position)
        {
            case 0:
                title = mContext.getResources().getString(R.string.song_list);
                break;
            case 1:
                title = mContext.getResources().getString(R.string.playing);
                break;
            case 2:
                title = mContext.getResources().getString(R.string.matching);
                break;
        }
        return title;
//        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}