package com.tuacy.designwidget.module.design;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;
import com.tuacy.designwidget.module.design.CoordinatorLayout.CoordinatorActivity;
import com.tuacy.designwidget.module.design.NavigationView.NavigationViewActivity;
import com.tuacy.designwidget.module.design.Snackbar.SnackBarActivity;
import com.tuacy.designwidget.module.design.TabLayout.TabActivity;
import com.tuacy.designwidget.module.design.TextInputLayout.TextInputActivity;

public class DesignMainActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, DesignMainActivity.class));
	}

	private Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_design_main);
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

		findViewById(R.id.button_coordinator_layout).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CoordinatorActivity.startup(mContext);
			}
		});

		findViewById(R.id.button_navigation_view).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				NavigationViewActivity.startup(mContext);
			}
		});

		findViewById(R.id.button_snack_bar).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SnackBarActivity.startup(mContext);
			}
		});

		findViewById(R.id.button_tab_layout).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TabActivity.startup(mContext);
			}
		});

		findViewById(R.id.button_text_input_layout).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextInputActivity.startup(mContext);
			}
		});
	}

	private void initData() {

	}
}
