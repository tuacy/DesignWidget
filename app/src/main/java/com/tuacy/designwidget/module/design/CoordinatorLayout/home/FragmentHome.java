package com.tuacy.designwidget.module.design.CoordinatorLayout.home;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileFragment;
import com.tuacy.designwidget.app.TabFragmentAdapter;

import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends BaseMobileFragment {

	public static FragmentHome instance() {
		return new FragmentHome();
	}

	private TabLayout mTabLayout;
	private ViewPager mViewPager;

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_home;
	}

	@Override
	protected void initViews(View root) {
		mTabLayout = root.findViewById(R.id.tab_layout_title);
		mViewPager = root.findViewById(R.id.page_collapsing);
	}

	@Override
	protected void initListeners() {

	}

	@Override
	protected void initData() {
		List<String> titleList = new ArrayList<>();
		titleList.add("推荐");
		titleList.add("抖音");
		titleList.add("音乐");
		titleList.add("搞笑");
		titleList.add("社会");
		titleList.add("影视");
		List<Fragment> fragmentList = new ArrayList<>();
		fragmentList.add(FragmentTabPager.newInstance(5, "推荐"));
		fragmentList.add(FragmentTabPager.newInstance(10, "抖音"));
		fragmentList.add(FragmentTabPager.newInstance(20, "音乐"));
		fragmentList.add(FragmentTabPager.newInstance(1, "搞笑"));
		fragmentList.add(FragmentTabPager.newInstance(24, "社会"));
		fragmentList.add(FragmentTabPager.newInstance(2, "影视"));
		mViewPager.setAdapter(new TabFragmentAdapter(getFragmentManager(), fragmentList, titleList));
		mTabLayout.setupWithViewPager(mViewPager);
	}
}
