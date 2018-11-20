package com.ensim.projetsnowtam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SnowtamFragmentAdapter extends FragmentStatePagerAdapter{
    public SnowtamFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        SnowtamFragment sf = new SnowtamFragment();
        Bundle bundle = new Bundle();
        position=position+1;
        bundle.putString("position",position+"");

        return sf;
    }

    @Override
    public int getCount() {
        return 25;
    }
}
