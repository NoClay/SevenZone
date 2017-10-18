package pers.noclay.sevenzone.viewInterfaces;

import android.support.v4.app.Fragment;

import java.util.List;


public interface TopTenInterface {
    void initTabLayout();
    void notifyTabLayout(List<String> titles, List<Fragment> mPages);
}
