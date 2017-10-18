package pers.noclay.sevenzone.presenters;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import pers.noclay.sevenzone.bases.BasePresenter;
import pers.noclay.sevenzone.viewInterfaces.TopTenInterface;

/**
 * Created by no_clay on 2017/4/3.
 */

public class TopTenPresenter extends BasePresenter<TopTenInterface> {
    List<String> titles;
    List<Fragment> mPages;

    public List<Fragment> getPages() {
        return mPages;
    }

    public List<String> getTitles() {
        return titles;
    }

    public TopTenPresenter() {
        titles = initTitles();
        mPages = new ArrayList<>();
    }

    public void initPages(){
        getView().initTabLayout();
        getView().notifyTabLayout(titles, mPages);
    }

    public List<String> initTitles() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("第" + i + "个页面");
        }
        return list;
    }
}
