package com.example.wanandroid.wanandorid.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseActivity;
import com.example.wanandroid.base.BasePersenter;
import com.example.wanandroid.wanandorid.collect.fragment.CollectFragment;
import com.example.wanandroid.wanandorid.fragment.HomeFragment;
import com.example.wanandroid.wanandorid.fragment.ZhiShiFragment;
import com.example.wanandroid.wanandorid.fragment.WeChatFragment;
import com.example.wanandroid.wanandorid.navigation.fragment.NavigationFragment;
import com.example.wanandroid.wanandorid.project.fragment.ProjectFragment;
import com.example.wanandroid.wanandorid.setting.fragment.SettingFragment;
import com.example.wanandroid.wanandorid.utils.CircularAnimUtil;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.common_toolbar_title_tv)
    TextView commonToolbarTitleTv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.main_fram)
    FrameLayout mainFram;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.bottom)
    BottomNavigationView bottom;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    //5cc7eb3f0cafb21298000f3c
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private FragmentManager manager;
    private ArrayList<Fragment> fragments;
    private int fragmentsList;

    @Override
    public void viewCreate(View view) {
        super.viewCreate(view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = drawer.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;
                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));
                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);
            }
        };

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(navigationView);
            }
        });
        initFragment();
        setBottomNavigationView();
    }

    private void setBottomNavigationView() {
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab_main_pager:
                        showFragment(0);
                        fragmentsList=0;
                        toolbar.setTitle(R.string.app_name);
                        break;
                    case R.id.tab_knowledge_hierarchy:
                        showFragment(1);
                        fragmentsList=1;
                        toolbar.setTitle(R.string.knowledge_hierarchy);
                        break;
                    case R.id.tab_wx_article:
                        showFragment(2);
                        fragmentsList=2;
                        toolbar.setTitle(R.string.wx_article);
                        break;
                    case R.id.tab_navigation:
                        showFragment(3);
                        fragmentsList=3;
                        toolbar.setTitle(R.string.navigation);
                        break;
                    case R.id.tab_project:
                        showFragment(4);
                        fragmentsList=4;
                        toolbar.setTitle(R.string.project);
                        break;
                }
                return true;
            }
        });
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ZhiShiFragment());
        fragments.add(new WeChatFragment());
        fragments.add(new NavigationFragment());
        fragments.add(new ProjectFragment());
        //1.获取碎片管理器0
        manager = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction transaction = manager.beginTransaction();
        //3.添加Fragment
        transaction.add(R.id.main_fram, fragments.get(0));
        //4.提交事务
        transaction.commit();
    }

    //显示对应位置的Fragment
    private void showFragment(int position) {
        FragmentTransaction transaction = manager.beginTransaction();
        ///需要显示的Fragment,同一Fragment对象只能添加一次,多次添加就崩了
        Fragment fragment = fragments.get(position);
        if (!fragment.isAdded()) {
            //如果没有添加过就添加
            transaction.replace(R.id.main_fram, fragment);
        }
        //如果已经添加过了,直接显示就可以了
        transaction.show(fragment);
        //原来显示的隐藏掉
        transaction.hide(fragments.get(fragmentsList));
        transaction.commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressLint("RestrictedApi")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (id == R.id.other) {

        } else if(id==R.id.nav_item_wan_android){
            transaction.replace(R.id.main_fram,new HomeFragment())
                    .commit();
            bottom.setVisibility(View.VISIBLE);
            fab.setVisibility(View.VISIBLE);
        }else if (id == R.id.nav_item_my_collect) {
            transaction.replace(R.id.main_fram,new CollectFragment())
                    .commit();
            bottom.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);
        } else if (id == R.id.nav_item_setting) {
            toolbar.setTitle(R.string.setting);
            transaction.add(R.id.main_fram,new SettingFragment())
                    .commit();
            bottom.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);

        } else if (id == R.id.nav_item_about_us) {

        } else if (id == R.id.nav_item_logout) {

        } else if (id == R.id.bugly) {
            Context context = getApplicationContext();
            // 获取当前包名
            String packageName = context.getPackageName();
            // 获取当前进程名
            String processName = getProcessName(Process.myPid());
            // 设置是否为上报进程
            CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
            strategy.setUploadProcess(processName == null || processName.equals(packageName));
            // 初始化Bugly
            CrashReport.initCrashReport(context, "a9b6ec7f00", true, strategy);
            CrashReport.testJavaCrash();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected BasePersenter createPresenter() {
        return new MainPersenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_usage:
                /*if (usageDialogFragment == null) {
                    usageDialogFragment = new UsageDialogFragment();
                }
                if (!isDestroyed() && usageDialogFragment.isAdded()) {
                    usageDialogFragment.dismiss();
                }
                usageDialogFragment.show(getSupportFragmentManager(), "UsageDialogFragment");*/
                //* Intent动画跳转
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, HomeInfoActivity.class);
        CircularAnimUtil.startActivity(MainActivity.this, intent, fab, R.color.fab_bg);
                break;
            case R.id.action_search:
                /*if (searchDialogFragment == null) {
                    searchDialogFragment = new SearchDialogFragment();
                }
                if (!isDestroyed() && searchDialogFragment.isAdded()) {
                    searchDialogFragment.dismiss();
                }
                searchDialogFragment.show(getSupportFragmentManager(), "SearchDialogFragment");*/
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
