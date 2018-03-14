package com.tuacy.designwidget.module.behavior.fab;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;
import com.tuacy.designwidget.app.TabFragmentAdapter;
import com.tuacy.designwidget.module.design.CoordinatorLayout.home.FragmentTabPager;

import java.util.ArrayList;
import java.util.List;

public class FabBottomInOutActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, FabBottomInOutActivity.class));
	}

	private TabLayout mTabLayout;
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fab_bottom_in_out);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mTabLayout = findViewById(R.id.tab_layout_title);
		mViewPager = findViewById(R.id.page_collapsing);
	}

	private void initEvent() {
	}

	private void initData() {
		List<String> titleList = new ArrayList<>();
		titleList.add("推荐");
		titleList.add("抖音");
		titleList.add("音乐");
		titleList.add("搞笑");
		titleList.add("社会");
		titleList.add("影视");
		List<Fragment> fragmentList = new ArrayList<>();
		fragmentList.add(FragmentTabPager.newInstance(20, "推荐"));
		fragmentList.add(FragmentTabPager.newInstance(10, "抖音"));
		fragmentList.add(FragmentTabPager.newInstance(20, "音乐"));
		fragmentList.add(FragmentTabPager.newInstance(1, "搞笑"));
		fragmentList.add(FragmentTabPager.newInstance(24, "社会"));
		fragmentList.add(FragmentTabPager.newInstance(2, "影视"));
		mViewPager.setAdapter(new TabFragmentAdapter(getFragmentManager(), fragmentList, titleList));
		mTabLayout.setupWithViewPager(mViewPager);
	}


}
