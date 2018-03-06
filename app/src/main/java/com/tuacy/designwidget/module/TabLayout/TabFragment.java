package com.tuacy.designwidget.module.TabLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileFragment;


public class TabFragment extends BaseMobileFragment {

	private static final String COLOR = "color";
	private static final String TITLE = "title";

	public static TabFragment newInstance(int color, String title) {
		TabFragment fragment = new TabFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(COLOR, color);
		bundle.putString(TITLE, title);
		fragment.setArguments(bundle);
		return fragment;
	}

	private int            mColor;
	private String         mTitle;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mColor = getArguments().getInt(COLOR);
		mTitle = getArguments().getString(TITLE);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_tab;
	}

	@Override
	protected void initViews(View root) {
		root.findViewById(R.id.relative_tab_parent).setBackgroundColor(mColor);
		TextView viewTitle = root.findViewById(R.id.text_tab_title);
		viewTitle.setText(mTitle);
	}

	@Override
	protected void initListeners() {

	}

	@Override
	protected void initData() {

	}
}
