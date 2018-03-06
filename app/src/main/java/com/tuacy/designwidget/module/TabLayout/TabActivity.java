package com.tuacy.designwidget.module.TabLayout;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;
import com.tuacy.designwidget.app.TabFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, TabActivity.class));
	}

	private Toolbar   mToolbar;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mToolbar = findViewById(R.id.tool_bar);
		mTabLayout = findViewById(R.id.tab_layout_title);
		mViewPager = findViewById(R.id.pager_fragment);
	}

	private void initEvent() {
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}

	private void initData() {
		List<String> titleList = new ArrayList<>();
		titleList.add("电视");
		titleList.add("电影");
		titleList.add("教育");
		titleList.add("体育");
		titleList.add("游戏");
		titleList.add("金融");
		List<Fragment> fragmentList = new ArrayList<>();
		fragmentList.add(TabFragment.newInstance(Color.LTGRAY, "电视"));
		fragmentList.add(TabFragment.newInstance(Color.CYAN, "电影"));
		fragmentList.add(TabFragment.newInstance(Color.GREEN, "教育"));
		fragmentList.add(TabFragment.newInstance(Color.BLUE, "体育"));
		fragmentList.add(TabFragment.newInstance(Color.YELLOW, "游戏"));
		fragmentList.add(TabFragment.newInstance(Color.MAGENTA, "金融"));
		mViewPager.setAdapter(new TabFragmentAdapter(getFragmentManager(), fragmentList, titleList));
		mTabLayout.setupWithViewPager(mViewPager);
	}
}
