package com.tuacy.designwidget.module;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;
import com.tuacy.designwidget.module.behavior.BehaviorMainActivity;
import com.tuacy.designwidget.module.design.DesignMainActivity;

public class MainActivity extends BaseMobileActivity {

	private Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mToolbar = findViewById(R.id.tool_bar);
	}

	private void initEvent() {
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});

		findViewById(R.id.button_design).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DesignMainActivity.startup(mContext);
			}
		});

		findViewById(R.id.button_behavior).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				BehaviorMainActivity.startup(mContext);
			}
		});

	}

	private void initData() {

	}
}
