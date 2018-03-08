package com.tuacy.designwidget.module.CoordinatorLayout;

import android.view.View;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileFragment;


public class FragmentMe extends BaseMobileFragment {

	public static FragmentMe instance() {
		return new FragmentMe();
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_home;
	}

	@Override
	protected void initViews(View root) {

	}

	@Override
	protected void initListeners() {

	}

	@Override
	protected void initData() {

	}
}
