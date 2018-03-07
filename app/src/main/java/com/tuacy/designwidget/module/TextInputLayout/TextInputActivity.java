package com.tuacy.designwidget.module.TextInputLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;

public class TextInputActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, TextInputActivity.class));
	}

	private Toolbar           mToolbar;
	private TextInputLayout   mTextInputLayout;
	private TextInputEditText mTextInputEditText;
	private Button            mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_input);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mToolbar = findViewById(R.id.tool_bar);
		mTextInputLayout = findViewById(R.id.layout_input_password);
		mTextInputEditText = findViewById(R.id.edit_password);
		mButton = findViewById(R.id.button_show_error);
	}

	private void initEvent() {
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTextInputLayout.setEnabled(true);
				mTextInputLayout.setError("密码不能小于6位");
			}
		});
	}

	private void initData() {

	}
}
