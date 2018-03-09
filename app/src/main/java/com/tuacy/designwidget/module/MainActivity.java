package com.tuacy.designwidget.module;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;
import com.tuacy.designwidget.module.BottomSheet.BottomSheetActivity;
import com.tuacy.designwidget.module.CoordinatorLayout.CoordinatorActivity;
import com.tuacy.designwidget.module.NavigationView.NavigationViewActivity;
import com.tuacy.designwidget.module.Snackbar.SnackBarActivity;
import com.tuacy.designwidget.module.TabLayout.TabActivity;
import com.tuacy.designwidget.module.TextInputLayout.TextInputActivity;

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

		findViewById(R.id.button_bottom_sheet_layout).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				BottomSheetActivity.startup(mContext);
			}
		});
	}

	private void initData() {

	}
}
