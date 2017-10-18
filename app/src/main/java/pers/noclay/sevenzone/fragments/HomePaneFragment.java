package pers.noclay.sevenzone.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import pers.noclay.sevenzone.R;
import pers.noclay.sevenzone.adapters.TopTenAdapter;
import pers.noclay.sevenzone.bases.BaseFragment;
import pers.noclay.sevenzone.presenters.TopTenPresenter;
import pers.noclay.sevenzone.viewInterfaces.TopTenInterface;

/**
 * Created by noclay on 2017/10/12.
 */

public class HomePaneFragment extends BaseFragment<TopTenInterface, TopTenPresenter>
        implements TopTenInterface, ViewPager.OnPageChangeListener, View.OnClickListener {

    public static final int RESOURCE = R.layout.fragment_home_pane;
    public View mView;
    private View view;
    private TabLayout mChanelTab;
    private ImageView mAddChannel;
    private ViewPager mViewPager;
    private TopTenAdapter mTopTenAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(RESOURCE, container, false);
        initView(mView);
        return mView;
    }

    private void initView(View mView) {
        mChanelTab = (TabLayout) mView.findViewById(R.id.chanelTab);
        mAddChannel = (ImageView) mView.findViewById(R.id.addChannel);
        mAddChannel.setOnClickListener(this);
        mViewPager = (ViewPager) mView.findViewById(R.id.viewPager);
        mTopTenAdapter = new TopTenAdapter(getChildFragmentManager(),
                getPresenter().getTitles(), getPresenter().getPages());
        getPresenter().initPages();
        mViewPager.setAdapter(mTopTenAdapter);
        mViewPager.addOnPageChangeListener(this);
        mChanelTab.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addChannel:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void initTabLayout() {
        mChanelTab.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void notifyTabLayout(List<String> titles, List<Fragment> mPages) {
        for (String title : titles) {
            mChanelTab.addTab(mChanelTab.newTab().setText(title));
            NewsPageFragment temp = new NewsPageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", title);
            temp.setArguments(bundle);
            mPages.add(temp);
        }
    }

    @Override
    protected TopTenPresenter createPresenter() {
        return new TopTenPresenter();
    }
}
