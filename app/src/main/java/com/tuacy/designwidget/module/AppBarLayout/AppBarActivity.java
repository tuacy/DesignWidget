package com.tuacy.designwidget.module.AppBarLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;

public class AppBarActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, AppBarActivity.class));
	}

	private Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_bar);
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
	}

	private void initData() {

	}
}
