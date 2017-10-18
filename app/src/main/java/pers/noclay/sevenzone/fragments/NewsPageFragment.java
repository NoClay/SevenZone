package pers.noclay.sevenzone.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pers.noclay.sevenzone.R;

/**
 * Created by noclay on 2017/10/16.
 */

public class NewsPageFragment extends Fragment {
    public static final int RESOURCE = R.layout.fragment_news_page;
    public View mView;
    private View view;
    private TextView mTest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(RESOURCE, container, false);
        initView(mView);
        return mView;
    }

    private void initView(View mView) {
        mTest = (TextView) mView.findViewById(R.id.test);
    }
}
