package pers.noclay.sevenzone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import pers.noclay.sevenzone.fragments.HomePaneFragment;
import pers.noclay.sevenzone.fragments.RemindPaneFragment;
import pers.noclay.sevenzone.fragments.ToolPaneFragment;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    private Toolbar mActionBar;
    private FrameLayout mMainPages;
    private ImageView mHomeButton;
    private ImageView mToolButton;
    private ImageView mRemindButton;
    private RelativeLayout mMainContent;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private HomePaneFragment homePage;
    private RemindPaneFragment remindPage;
    private ToolPaneFragment toolPage;
    private SwitchCompat mSwitchCompat;
    public static final int HOME_PAGE = 0;
    public static final int TOOL_PAGE = 1;
    public static final int REMIND_PAGE = 2;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initActionBar();
        setCurPages(HOME_PAGE);
    }


    private void setCurPages(int pos){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (homePage != null){
            transaction.hide(homePage);
        }
        if (toolPage != null){
            transaction.hide(toolPage);
        }
        if (remindPage != null){
            transaction.hide(remindPage);
        }
        switch (pos){
            case HOME_PAGE:{
                if (homePage == null){
                    homePage = new HomePaneFragment();
                    transaction.add(R.id.mainPages, homePage);
                }
                transaction.show(homePage);
                break;
            }
            case TOOL_PAGE:{
                if (toolPage == null){
                    toolPage = new ToolPaneFragment();
                    transaction.add(R.id.mainPages, toolPage);
                }
                transaction.show(toolPage);
                break;
            }
            case REMIND_PAGE:{
                if (remindPage == null){
                    remindPage = new RemindPaneFragment();
                    transaction.add(R.id.mainPages, remindPage);
                }
                transaction.show(remindPage);
                break;
            }
        }
        transaction.commit();
    }

    private void initActionBar() {
        setSupportActionBar(mActionBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initView() {
        mActionBar = (Toolbar) findViewById(R.id.actionBar);
        mMainPages = (FrameLayout) findViewById(R.id.mainPages);
        mHomeButton = (ImageView) findViewById(R.id.homeButton);
        mHomeButton.setOnClickListener(this);
        mToolButton = (ImageView) findViewById(R.id.toolButton);
        mToolButton.setOnClickListener(this);
        mRemindButton = (ImageView) findViewById(R.id.remindButton);
        mRemindButton.setOnClickListener(this);
        mMainContent = (RelativeLayout) findViewById(R.id.mainContent);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView.setNavigationItemSelectedListener(this);
        mSwitchCompat = (SwitchCompat) mNavigationView.getMenu().findItem(R.id.nightMode).getActionView();
        mSwitchCompat.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeButton:
                setCurPages(HOME_PAGE);
                break;
            case R.id.toolButton:
                setCurPages(TOOL_PAGE);
                break;
            case R.id.remindButton:
                setCurPages(REMIND_PAGE);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tool_bar, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

        }
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
