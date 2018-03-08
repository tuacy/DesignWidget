package com.tuacy.designwidget.module.CoordinatorLayout.home;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileFragment;

public class FragmentTabPager extends BaseMobileFragment {

	private static final String ITEM_COUNT = "item_count";
	private static final String TITLE      = "title";

	public static FragmentTabPager newInstance(int count, String title) {
		FragmentTabPager fragment = new FragmentTabPager();
		Bundle bundle = new Bundle();
		bundle.putInt(ITEM_COUNT, count);
		bundle.putString(TITLE, title);
		fragment.setArguments(bundle);
		return fragment;
	}

	private RefreshLayout mRefreshLayout;
	private String        mTitle;
	private int           mCount;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mTitle = getArguments().getString(TITLE);
		mCount = getArguments().getInt(ITEM_COUNT);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_coordinator_page;
	}

	@Override
	protected void initViews(View root) {
		RecyclerView recyclerView = root.findViewById(R.id.recycler_coordinator_tab_content);
		recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
		recyclerView.setAdapter(new ItemAdapter(mCount, mTitle));
		mRefreshLayout = root.findViewById(R.id.refreshLayout);
		mRefreshLayout.setRefreshHeader(new ClassicsHeader(mContext));
	}

	@Override
	protected void initListeners() {
		mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh(RefreshLayout refreshlayout) {
				refreshlayout.finishRefresh(2000);
			}
		});
		mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
			@Override
			public void onLoadmore(RefreshLayout refreshlayout) {
				refreshlayout.finishLoadmore(2000);
			}
		});
	}

	@Override
	protected void initData() {

	}

}
