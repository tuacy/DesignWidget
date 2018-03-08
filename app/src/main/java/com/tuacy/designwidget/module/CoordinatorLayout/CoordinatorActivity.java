package com.tuacy.designwidget.module.CoordinatorLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;
import com.tuacy.designwidget.module.CoordinatorLayout.home.FragmentHome;
import com.tuacy.designwidget.module.CoordinatorLayout.table.FragmentTable;

public class CoordinatorActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, CoordinatorActivity.class));
	}

	private static final int HOME      = 0;
	private static final int TABLE     = 1;
	private static final int ATTENTION = 2;
	private static final int ME        = 3;

	private RadioButton       mRadioHome;
	private RadioButton       mRadioTable;
	private RadioButton       mRadioAttention;
	private RadioButton       mRadioMe;
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
		mRadioHome = findViewById(R.id.radio_tab_home_page);
		mRadioTable = findViewById(R.id.radio_tab_table);
		mRadioAttention = findViewById(R.id.radio_tab_attention);
		mRadioMe = findViewById(R.id.radio_tab_me);
	}

	private void initEvent() {
		mRadioHome.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switchTab(HOME);
			}
		});
		mRadioTable.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switchTab(TABLE);
			}
		});
		mRadioAttention.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switchTab(ATTENTION);
			}
		});
		mRadioMe.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switchTab(ME);
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
		mRadioHome.setChecked(false);
		mRadioTable.setChecked(false);
		mRadioAttention.setChecked(false);
		mRadioMe.setChecked(false);
		switch (tab) {
			case HOME:
				mRadioHome.setChecked(true);
				if (mFragmentHome != null) {
					switchFragment(R.id.layout_main_fragment_content, mFragmentHome);
				}
				break;
			case TABLE:
				mRadioTable.setChecked(true);
				if (mFragmentTable != null) {
					switchFragment(R.id.layout_main_fragment_content, mFragmentTable);
				}
				break;
			case ATTENTION:
				mRadioAttention.setChecked(true);
				if (mFragmentAttention != null) {
					switchFragment(R.id.layout_main_fragment_content, mFragmentAttention);
				}
				break;
			case ME:
				mRadioMe.setChecked(true);
				if (mFragmentMe != null) {
					switchFragment(R.id.layout_main_fragment_content, mFragmentMe);
				}
				break;
		}
		mCurrentTab = tab;
	}
}
