package com.tuacy.designwidget.app;

import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;

import com.pilot.common.base.activity.BaseAppActivity;


public abstract class BaseMobileActivity extends BaseAppActivity {
	public void showSnackBar(int strId) {
		showSnackBar(getResources().getString(strId), Snackbar.LENGTH_SHORT);
	}

	public void showSnackBar(int strId, int duration) {
		showSnackBar(getResources().getString(strId), duration);
	}

	public void showSnackBar(String str) {
		showSnackBar(str, Snackbar.LENGTH_SHORT);
	}

	public void showSnackBar(String str, int duration) {
		Snackbar.make(findViewById(android.R.id.content), str, duration).show();
	}


	public void showSnackBar(int strId, int actionStrId, View.OnClickListener listener) {
		showSnackBar(getResources().getString(strId), getResources().getString(actionStrId), listener, Snackbar.LENGTH_SHORT);
	}

	public void showSnackBar(int strId, int actionStrId, View.OnClickListener listener, int duration) {
		showSnackBar(getResources().getString(strId), getResources().getString(actionStrId), listener, duration);
	}

	public void showSnackBar(String str, String action, View.OnClickListener listener, int duration) {
		Snackbar.make(findViewById(android.R.id.content), str, duration).setAction(action, listener).show();
	}

	public class SnackBarBuilder {

		private int mDuration = Snackbar.LENGTH_SHORT;
		private View                 mParentView;
		private String               mText;
		private String               mActionText;
		private View.OnClickListener mOnClickListener;

		public SnackBarBuilder() {
			mParentView = findViewById(android.R.id.content);
		}

		public SnackBarBuilder setParentView(View view) {
			mParentView = view;
			return this;
		}

		public SnackBarBuilder setText(int strId) {
			setText(getString(strId));
			return this;
		}

		public SnackBarBuilder setText(String str) {
			mText = str;
			return this;
		}

		public SnackBarBuilder setAction(int actionId, View.OnClickListener listener) {
			return setAction(getString(actionId), listener);
		}

		public SnackBarBuilder setAction(String action, View.OnClickListener listener) {
			mActionText = action;
			mOnClickListener = listener;
			return this;
		}

		public SnackBarBuilder setDuration(int duration) {
			mDuration = duration;
			return this;
		}

		public Snackbar build() {
			if (!TextUtils.isEmpty(mActionText) && mOnClickListener != null) {
				return Snackbar.make(mParentView, mText, mDuration).setAction(mActionText, mOnClickListener);
			} else {
				return Snackbar.make(mParentView, mText, mDuration);
			}
		}
	}
}
