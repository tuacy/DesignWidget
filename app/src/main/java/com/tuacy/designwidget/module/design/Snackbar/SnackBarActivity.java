package com.tuacy.designwidget.module.design.Snackbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;

public class SnackBarActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, SnackBarActivity.class));
	}

	private Toolbar    mToolbar;
	private Button     mButtonSnack;
	private RadioGroup mRadioGroup;

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
		mButtonSnack = findViewById(R.id.button_snack_bar);
		mRadioGroup = findViewById(R.id.radio_group_snack_type);
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
				switch (mRadioGroup.getCheckedRadioButtonId()) {
					case R.id.radio_info:
						SnackBarPackage.showInfoShortSnackBar(mButtonSnack, R.string.app_name);
						break;
					case R.id.radio_confirm:
						SnackBarPackage.showConfirmShortSnackBar(mButtonSnack, R.string.app_name);
						break;
					case R.id.radio_warning:
						SnackBarPackage.showWarningShortSnackBar(mButtonSnack, R.string.app_name);
						break;
					case R.id.radio_error:
						SnackBarPackage.showErrorShortSnackBar(mButtonSnack, R.string.app_name);
						break;
				}
			}
		});
	}

	private void initData() {

	}
}
