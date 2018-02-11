package com.tuacy.designwidget.module.Snackbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;

public class SnackbarActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, SnackbarActivity.class));
	}

	private Toolbar mToolbar;
	private Button mButtonSnack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_snack_bar);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mToolbar = findViewById(R.id.tool_bar);
		mButtonSnack = findViewById(R.id.button_snackbar);
	}

	private void initEvent() {
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});

		mButtonSnack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				showSnackBar(R.string.app_name);
				Snackbar.make(mButtonSnack, R.string.app_name,  Snackbar.LENGTH_SHORT).show();
			}
		});
	}

	private void initData() {

	}
}
