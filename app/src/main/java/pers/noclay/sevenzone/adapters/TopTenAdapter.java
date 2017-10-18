package pers.noclay.sevenzone.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by noclay on 2017/10/16.
 */

public class TopTenAdapter extends FragmentStatePagerAdapter {
    private List<String> titles;
    private List<Fragment> mPages;

    public TopTenAdapter(FragmentManager fm, List<String> titles, List<Fragment> mPages) {
        super(fm);
        this.titles = titles;
        this.mPages = mPages;
    }

    @Override
    public Fragment getItem(int position) {
        return mPages.get(position);
    }

    @Override
    public int getCount() {
        return mPages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
