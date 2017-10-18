package pers.noclay.sevenzone.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pers.noclay.sevenzone.R;

/**
 * Created by noclay on 2017/10/13.
 */

public class RemindPaneFragment extends Fragment {
    public static final int RESOURCE = R.layout.fragment_remind_pane;
    public View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(RESOURCE, container, false);
        return mView;
    }
}
