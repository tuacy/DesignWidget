package com.tuacy.designwidget.module.Snackbar;


import android.support.annotation.ColorInt;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.tuacy.designwidget.R;

public class SnackBarPackage {

	public enum SnackBarType {
		INFO(0),
		CONFIRM(1),
		WARNING(2),
		ERROR(3);

		private int mType;

		private SnackBarType(int type) {
			mType = type;
		}

		public int type() {
			return mType;
		}
	}

	private static final int WHITE  = 0xffffffff;
	private static final int RED    = 0xfff44336;
	private static final int GREEN  = 0xff4caf50;
	private static final int BLUE   = 0xff2195f3;
	private static final int ORANGE = 0xffffc107;

	public static final class Builder {

		@ColorInt
		int mInfoMessageColor;
		@ColorInt
		int mInfoBackgroundColor;
		@ColorInt
		int mConfirmMessageColor;
		@ColorInt
		int mConfirmBackgroundColor;
		@ColorInt
		int mWarningMessageColor;
		@ColorInt
		int mWarningBackgroundColor;
		@ColorInt
		int mErrorMessageColor;
		@ColorInt
		int mErrorBackgroundColor;

		Builder() {
			this.mInfoMessageColor = WHITE;
			this.mInfoBackgroundColor = BLUE;
			this.mConfirmMessageColor = WHITE;
			this.mConfirmBackgroundColor = GREEN;
			this.mWarningMessageColor = WHITE;
			this.mWarningBackgroundColor = ORANGE;
			this.mErrorMessageColor = WHITE;
			this.mErrorBackgroundColor = RED;
		}
	}

	private static Builder mBuilder = new Builder();

	public static void setInfoMessageColor(@ColorInt int color) {
		mBuilder.mInfoMessageColor = color;
	}

	public static void setInfoBackgroundColor(@ColorInt int color) {
		mBuilder.mInfoBackgroundColor = color;
	}

	public static void setConfirmMessageColor(@ColorInt int color) {
		mBuilder.mConfirmMessageColor = color;
	}

	public static void setConfirmBackgroundColor(@ColorInt int color) {
		mBuilder.mConfirmBackgroundColor = color;
	}

	public static void setWarningMessageColor(@ColorInt int color) {
		mBuilder.mWarningMessageColor = color;
	}

	public static void setWarningBackgroundColor(@ColorInt int color) {
		mBuilder.mWarningBackgroundColor = color;
	}

	public static void setErrorMessageColor(@ColorInt int color) {
		mBuilder.mErrorMessageColor = color;
	}

	public static void setErrorBackgroundColor(@ColorInt int color) {
		mBuilder.mErrorBackgroundColor = color;
	}

	public static Snackbar snackBar(View view, @StringRes int messageResId, int duration) {
		return Snackbar.make(view, messageResId, duration);
	}

	public static Snackbar snackBar(View view, String message, int duration) {
		return Snackbar.make(view, message, duration);
	}

	public static Snackbar snackBar(View view, @StringRes int messageResId, int duration, int backgroundColor) {
		Snackbar snackbar = Snackbar.make(view, messageResId, duration);
		snackbar.getView().setBackgroundColor(backgroundColor);
		return snackbar;
	}

	public static Snackbar snackBar(View view, String message, int duration, int backgroundColor) {
		Snackbar snackbar = Snackbar.make(view, message, duration);
		snackbar.getView().setBackgroundColor(backgroundColor);
		return snackbar;
	}

	public static Snackbar snackBar(View view, @StringRes int messageResId, int duration, int messageColor, int backgroundColor) {
		Snackbar snackbar = Snackbar.make(view, messageResId, duration);
		View contentView = snackbar.getView();
		contentView.setBackgroundColor(backgroundColor);
		((TextView) contentView.findViewById(R.id.snackbar_text)).setTextColor(messageColor);
		return snackbar;
	}

	public static Snackbar snackBar(View view, String message, int duration, int messageColor, int backgroundColor) {
		Snackbar snackbar = Snackbar.make(view, message, duration);
		View contentView = snackbar.getView();
		contentView.setBackgroundColor(backgroundColor);
		((TextView) contentView.findViewById(R.id.snackbar_text)).setTextColor(messageColor);
		return snackbar;
	}

	public static Snackbar indefiniteSnackBar(View view, @StringRes int messageResId, int messageColor, int backgroundColor) {
		return snackBar(view, messageResId, Snackbar.LENGTH_INDEFINITE, messageColor, backgroundColor);
	}

	public static Snackbar indefiniteSnackBar(View view, String message, int messageColor, int backgroundColor) {
		return snackBar(view, message, Snackbar.LENGTH_INDEFINITE, messageColor, backgroundColor);
	}

	public static Snackbar indefiniteSnackBar(View view, @StringRes int messageResId) {
		return snackBar(view, messageResId, Snackbar.LENGTH_INDEFINITE);
	}

	public static Snackbar indefiniteSnackBar(View view, String message) {
		return snackBar(view, message, Snackbar.LENGTH_INDEFINITE);
	}

	public static Snackbar shortSnackBar(View view, @StringRes int messageResId, int messageColor, int backgroundColor) {
		return snackBar(view, messageResId, Snackbar.LENGTH_SHORT, messageColor, backgroundColor);
	}

	public static Snackbar shortSnackBar(View view, String message, int messageColor, int backgroundColor) {
		return snackBar(view, message, Snackbar.LENGTH_SHORT, messageColor, backgroundColor);
	}

	public static Snackbar shortSnackBar(View view, @StringRes int messageResId) {
		return snackBar(view, messageResId, Snackbar.LENGTH_SHORT);
	}

	public static Snackbar shortSnackBar(View view, String message) {
		return snackBar(view, message, Snackbar.LENGTH_SHORT);
	}

	public static Snackbar longSnackBar(View view, @StringRes int messageResId, int messageColor, int backgroundColor) {
		return snackBar(view, messageResId, Snackbar.LENGTH_LONG, messageColor, backgroundColor);
	}

	public static Snackbar longSnackBar(View view, String message, int messageColor, int backgroundColor) {
		return snackBar(view, message, Snackbar.LENGTH_LONG, messageColor, backgroundColor);
	}

	public static Snackbar longSnackBar(View view, @StringRes int messageResId) {
		return snackBar(view, messageResId, Snackbar.LENGTH_LONG);
	}

	public static Snackbar longSnackBar(View view, String message) {
		return snackBar(view, message, Snackbar.LENGTH_LONG);
	}

	public static void showInfoIndefiniteSnackBar(View view, @StringRes int messageResId) {
		indefiniteSnackBar(view, messageResId, mBuilder.mInfoMessageColor, mBuilder.mInfoBackgroundColor).show();
	}

	public static void showInfoIndefiniteSnackBar(View view, String message) {
		indefiniteSnackBar(view, message, mBuilder.mInfoMessageColor, mBuilder.mInfoBackgroundColor).show();
	}

	public static void showInfoShortSnackBar(View view, @StringRes int messageResId) {
		shortSnackBar(view, messageResId, mBuilder.mInfoMessageColor, mBuilder.mInfoBackgroundColor).show();
	}

	public static void showInfoShortSnackBar(View view, String message) {
		shortSnackBar(view, message, mBuilder.mInfoMessageColor, mBuilder.mInfoBackgroundColor).show();
	}

	public static void showInfoLongSnackBar(View view, @StringRes int messageResId) {
		longSnackBar(view, messageResId, mBuilder.mInfoMessageColor, mBuilder.mInfoBackgroundColor).show();
	}

	public static void showInfoLongSnackBar(View view, String message) {
		longSnackBar(view, message, mBuilder.mInfoMessageColor, mBuilder.mInfoBackgroundColor).show();
	}

	public static void showConfirmIndefiniteSnackBar(View view, @StringRes int messageResId) {
		indefiniteSnackBar(view, messageResId, mBuilder.mConfirmMessageColor, mBuilder.mConfirmBackgroundColor).show();
	}

	public static void showConfirmIndefiniteSnackBar(View view, String message) {
		indefiniteSnackBar(view, message, mBuilder.mConfirmMessageColor, mBuilder.mConfirmBackgroundColor).show();
	}

	public static void showConfirmShortSnackBar(View view, @StringRes int messageResId) {
		shortSnackBar(view, messageResId, mBuilder.mConfirmMessageColor, mBuilder.mConfirmBackgroundColor).show();
	}

	public static void showConfirmShortSnackBar(View view, String message) {
		shortSnackBar(view, message, mBuilder.mConfirmMessageColor, mBuilder.mConfirmBackgroundColor).show();
	}

	public static void showConfirmLongSnackBar(View view, @StringRes int messageResId) {
		longSnackBar(view, messageResId, mBuilder.mConfirmMessageColor, mBuilder.mConfirmBackgroundColor).show();
	}

	public static void showConfirmLongSnackBar(View view, String message) {
		longSnackBar(view, message, mBuilder.mConfirmMessageColor, mBuilder.mConfirmBackgroundColor).show();
	}

	public static void showWarningIndefiniteSnackBar(View view, @StringRes int messageResId) {
		indefiniteSnackBar(view, messageResId, mBuilder.mWarningMessageColor, mBuilder.mWarningBackgroundColor).show();
	}

	public static void showWarningIndefiniteSnackBar(View view, String message) {
		indefiniteSnackBar(view, message, mBuilder.mWarningMessageColor, mBuilder.mWarningBackgroundColor).show();
	}

	public static void showWarningShortSnackBar(View view, @StringRes int messageResId) {
		shortSnackBar(view, messageResId, mBuilder.mWarningMessageColor, mBuilder.mWarningBackgroundColor).show();
	}

	public static void showWarningShortSnackBar(View view, String message) {
		shortSnackBar(view, message, mBuilder.mWarningMessageColor, mBuilder.mWarningBackgroundColor).show();
	}

	public static void showWarningLongSnackBar(View view, @StringRes int messageResId) {
		longSnackBar(view, messageResId, mBuilder.mWarningMessageColor, mBuilder.mWarningBackgroundColor).show();
	}

	public static void showWarningLongSnackBar(View view, String message) {
		longSnackBar(view, message, mBuilder.mWarningMessageColor, mBuilder.mWarningBackgroundColor).show();
	}

	public static void showErrorIndefiniteSnackBar(View view, @StringRes int messageResId) {
		indefiniteSnackBar(view, messageResId, mBuilder.mErrorMessageColor, mBuilder.mErrorBackgroundColor).show();
	}

	public static void showErrorIndefiniteSnackBar(View view, String message) {
		indefiniteSnackBar(view, message, mBuilder.mErrorMessageColor, mBuilder.mErrorBackgroundColor).show();
	}

	public static void showErrorShortSnackBar(View view, @StringRes int messageResId) {
		shortSnackBar(view, messageResId, mBuilder.mErrorMessageColor, mBuilder.mErrorBackgroundColor).show();
	}

	public static void showErrorShortSnackBar(View view, String message) {
		shortSnackBar(view, message, mBuilder.mErrorMessageColor, mBuilder.mErrorBackgroundColor).show();
	}

	public static void showErrorLongSnackBar(View view, @StringRes int messageResId) {
		longSnackBar(view, messageResId, mBuilder.mErrorMessageColor, mBuilder.mErrorBackgroundColor).show();
	}

	public static void showErrorLongSnackBar(View view, String message) {
		longSnackBar(view, message, mBuilder.mErrorMessageColor, mBuilder.mErrorBackgroundColor).show();
	}

	public static void showIndefinitSnackBar(View view, SnackBarType type, @StringRes int messageResId) {
		switch (type) {
			case INFO:
				showInfoIndefiniteSnackBar(view, messageResId);
				break;
			case CONFIRM:
				showConfirmIndefiniteSnackBar(view, messageResId);
				break;
			case WARNING:
				showWarningIndefiniteSnackBar(view, messageResId);
				break;
			case ERROR:
				showErrorIndefiniteSnackBar(view, messageResId);
				break;
		}
	}

	public static void showIndefinitSnackBar(View view, SnackBarType type, String message) {
		switch (type) {
			case INFO:
				showInfoIndefiniteSnackBar(view, message);
				break;
			case CONFIRM:
				showConfirmIndefiniteSnackBar(view, message);
				break;
			case WARNING:
				showWarningIndefiniteSnackBar(view, message);
				break;
			case ERROR:
				showErrorIndefiniteSnackBar(view, message);
				break;
		}
	}

	public static void showShortSnackBar(View view, SnackBarType type, @StringRes int messageResId) {
		switch (type) {
			case INFO:
				showInfoShortSnackBar(view, messageResId);
				break;
			case CONFIRM:
				showConfirmShortSnackBar(view, messageResId);
				break;
			case WARNING:
				showWarningShortSnackBar(view, messageResId);
				break;
			case ERROR:
				showErrorShortSnackBar(view, messageResId);
				break;
		}
	}

	public static void showShortSnackBar(View view, SnackBarType type, String message) {
		switch (type) {
			case INFO:
				showInfoShortSnackBar(view, message);
				break;
			case CONFIRM:
				showConfirmShortSnackBar(view, message);
				break;
			case WARNING:
				showWarningShortSnackBar(view, message);
				break;
			case ERROR:
				showErrorShortSnackBar(view, message);
				break;
		}
	}

	public static void showLongSnackBar(View view, SnackBarType type, @StringRes int messageResId) {
		switch (type) {
			case INFO:
				showInfoLongSnackBar(view, messageResId);
				break;
			case CONFIRM:
				showConfirmLongSnackBar(view, messageResId);
				break;
			case WARNING:
				showWarningLongSnackBar(view, messageResId);
				break;
			case ERROR:
				showErrorLongSnackBar(view, messageResId);
				break;
		}
	}

	public static void showLongSnackBar(View view, SnackBarType type, String message) {
		switch (type) {
			case INFO:
				showInfoLongSnackBar(view, message);
				break;
			case CONFIRM:
				showConfirmLongSnackBar(view, message);
				break;
			case WARNING:
				showWarningLongSnackBar(view, message);
				break;
			case ERROR:
				showErrorLongSnackBar(view, message);
				break;
		}
	}

}
