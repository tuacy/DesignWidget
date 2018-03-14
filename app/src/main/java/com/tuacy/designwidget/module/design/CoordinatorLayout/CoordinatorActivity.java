package com.tuacy.designwidget.module.design.CoordinatorLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;
import com.tuacy.designwidget.module.design.CoordinatorLayout.home.FragmentHome;
import com.tuacy.designwidget.module.design.CoordinatorLayout.me.FragmentMe;
import com.tuacy.designwidget.module.design.CoordinatorLayout.table.FragmentTable;

public class CoordinatorActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, CoordinatorActivity.class));
	}

	private static final int HOME      = 0;
	private static final int TABLE     = 1;
	private static final int ATTENTION = 2;
	private static final int ME        = 3;

	private RadioGroup        mRadioGroup;
	private int               mCurrentTab;
	private FragmentHome      mFragmentHome;
	private FragmentTable     mFragmentTable;
	private FragmentAttention mFragmentAttention;
	private FragmentMe        mFragmentMe;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coordination);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mRadioGroup = findViewById(R.id.group_bottom_navigation_bar);
	}

	private void initEvent() {
		mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
					case R.id.radio_tab_home_page:
						switchTab(HOME);
						break;
					case R.id.radio_tab_table:
						switchTab(TABLE);
						break;
					case R.id.radio_tab_attention:
						switchTab(ATTENTION);
						break;
					case R.id.radio_tab_me:
						switchTab(ME);
						break;
				}
			}
		});
	}

	private void initData() {
		mCurrentTab = -1;
		mFragmentHome = FragmentHome.instance();
		mFragmentTable = FragmentTable.instance();
		mFragmentAttention = FragmentAttention.instance();
		mFragmentMe = FragmentMe.instance();
		switchTab(HOME);
	}

	private void switchTab(int tab) {
		if (mCurrentTab == tab) {
			return;
		}
		switch (tab) {
			case HOME:
				mRadioGroup.check(R.id.radio_tab_home_page);
				if (mFragmentHome != null) {
					switchFragment(R.id.layout_main_fragment_content, mFragmentHome);
				}
				break;
			case TABLE:
				mRadioGroup.check(R.id.radio_tab_table);
				if (mFragmentTable != null) {
					switchFragment(R.id.layout_main_fragment_content, mFragmentTable);
				}
				break;
			case ATTENTION:
				mRadioGroup.check(R.id.radio_tab_attention);
				if (mFragmentAttention != null) {
					switchFragment(R.id.layout_main_fragment_content, mFragmentAttention);
				}
				break;
			case ME:
				mRadioGroup.check(R.id.radio_tab_me);
				if (mFragmentMe != null) {
					switchFragment(R.id.layout_main_fragment_content, mFragmentMe);
				}
				break;
		}
		mCurrentTab = tab;
	}
}
