package com.tuacy.designwidget.module.behavior;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;
import com.tuacy.designwidget.module.behavior.bottomSheet.BottomSheetActivity;
import com.tuacy.designwidget.module.behavior.fab.FabBottomInOutActivity;
import com.tuacy.designwidget.module.behavior.headercover.HeaderCoverActivity;

public class BehaviorMainActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, BehaviorMainActivity.class));
	}

	private Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_behavior_main);
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

		findView(R.id.button_behavior_bottom_sheet).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				BottomSheetActivity.startup(mContext);
			}
		});

		findView(R.id.button_behavior_fab_bottom_in_out).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FabBottomInOutActivity.startup(mContext);
			}
		});

		findView(R.id.button_behavior_header_cover).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				HeaderCoverActivity.startup(mContext);
			}
		});
	}

	private void initData() {

	}
}
