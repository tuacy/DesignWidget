package com.tuacy.designwidget.module.BottomSheet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, BottomSheetActivity.class));
	}

	private Button              mButtonBottomSheetLayout;
	private Button              mButtonBottomSheetDialog;
	private RecyclerView        mRecyclerSheet;
	private BottomSheetBehavior mSheetBehavior;
	private BottomSheetDialog   mBottomSheetDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bottom_sheet);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mButtonBottomSheetLayout = findViewById(R.id.button_bottom_sheet_layout);
		View bottomSheet = findViewById(R.id.design_bottom_sheet);
		mSheetBehavior = BottomSheetBehavior.from(bottomSheet);
		mButtonBottomSheetDialog = findViewById(R.id.button_bottom_sheet_dialog);
		mRecyclerSheet = findViewById(R.id.recycler_sheet_item);
		mRecyclerSheet.setLayoutManager(new LinearLayoutManager(mContext));
	}

	private void initEvent() {
		mButtonBottomSheetLayout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleBottomSheetLayout(mSheetBehavior);
			}
		});
		mButtonBottomSheetDialog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mBottomSheetDialog != null) {
					if (mBottomSheetDialog.isShowing()) {
						mBottomSheetDialog.dismiss();
					} else {
						mBottomSheetDialog.show();
					}
				}
			}
		});
	}

	private void initData() {
		mRecyclerSheet.setAdapter(new BottomSheetAdapter(obtainSheetLayoutData()));
		createBottomSheetDialog();
	}

	private void toggleBottomSheetLayout(BottomSheetBehavior behavior) {
		if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
			behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
		} else {
			behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
		}
	}

	private List<String> obtainSheetLayoutData() {
		List<String> data = new ArrayList<>();
		for (int index = 0; index < 20; index++) {
			data.add("Bottom Sheet Layout " + index);
		}
		return data;
	}

	private List<String> obtainSheetLayoutDialog() {
		List<String> data = new ArrayList<>();
		for (int index = 0; index < 20; index++) {
			data.add("Bottom Sheet Dialog " + index);
		}
		return data;
	}

	private void createBottomSheetDialog() {
		if (mBottomSheetDialog == null) {
			mBottomSheetDialog = new BottomSheetDialog(this, R.style.Theme_Design_BottomSheetDialog2);
			View view = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_sheet, null, false);
			mBottomSheetDialog.setContentView(view);
			RecyclerView recyclerView = view.findViewById(R.id.recycler_sheet_dialog_content);
			recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
			recyclerView.setAdapter(new BottomSheetAdapter(obtainSheetLayoutDialog()));
//			setBehaviorCallback();
		}
	}

	private void setBehaviorCallback() {
		View view = mBottomSheetDialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
		final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(view);
		bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
			@Override
			public void onStateChanged(@NonNull View bottomSheet, int newState) {
				if (newState == BottomSheetBehavior.STATE_HIDDEN) {
					mBottomSheetDialog.dismiss();
					bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
				}
			}

			@Override
			public void onSlide(@NonNull View bottomSheet, float slideOffset) {
			}
		});
	}

}
