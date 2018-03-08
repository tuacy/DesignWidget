package com.tuacy.designwidget.widget.chart;


import android.graphics.Canvas;
import android.graphics.PointF;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 支持三种格式 x月 -> 02月，04月，x日, hh:mm
 * 规定x轴格式hh:mm
 */
public class LabelsSkipXAxisRenderer extends XAxisRenderer {

	private static final int TYPE_UNKNOWN = 0;
	private static final int TYPE_MOTH    = 1;
	private static final int TYPE_DAY     = 2;
	private static final int TYPE_TIME    = 3;

	private int mCurrentXAxisType;

	public LabelsSkipXAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer trans) {
		super(viewPortHandler, xAxis, trans);
		mCurrentXAxisType = TYPE_UNKNOWN;
	}

	@Override
	protected void drawLabels(Canvas c, float pos, PointF anchor) {
		if (mViewPortHandler.getScaleX() == 1.0f) {
			updateXAxisType(0);
			if (mCurrentXAxisType == TYPE_UNKNOWN) {
				super.drawLabels(c, pos, anchor);
			} else {
				drawLabelsLabelSkip(c, pos, anchor);
			}
		} else {
			super.drawLabels(c, pos, anchor);
		}
	}

	/**
	 * draws the x-labels on the specified y-position
	 */
	private void drawLabelsLabelSkip(Canvas c, float pos, PointF anchor) {

		final float labelRotationAngleDegrees = mXAxis.getLabelRotationAngle();

		// pre allocate to save performance (dont allocate in loop)
		float[] position = new float[]{0f,
									   0f};

		for (int i = mMinX; i <= mMaxX; i++) {

			position[0] = i;

			mTrans.pointValuesToPixel(position);

			if (mViewPortHandler.isInBoundsX(position[0]) && isValidData(i)) {

				String label = mXAxis.getValues().get(i);

				if (mXAxis.isAvoidFirstLastClippingEnabled()) {

					// avoid clipping of the last
					if (i == mXAxis.getValues().size() - 1 && mXAxis.getValues().size() > 1) {
						float width = Utils.calcTextWidth(mAxisLabelPaint, label);

						if (width > mViewPortHandler.offsetRight() * 2 && position[0] + width > mViewPortHandler.getChartWidth()) {
							position[0] -= width / 2;
						}

						// avoid clipping of the first
					} else if (i == 0) {

						float width = Utils.calcTextWidth(mAxisLabelPaint, label);
						position[0] += width / 2;
					}
				}

				drawLabel(c, label, i, position[0], pos, anchor, labelRotationAngleDegrees);
			}
		}
	}

	private boolean isValidData(int index) {
		String label = mXAxis.getValues().get(index);
		switch (mCurrentXAxisType) {
			case TYPE_TIME:
				SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
				Calendar calendar = Calendar.getInstance();
				try {
					calendar.setTime(dataFormat.parse(label));
					return calendar.get(Calendar.HOUR_OF_DAY) % 4 == 0 && calendar.get(Calendar.MINUTE) == 0;
				} catch (ParseException e) {
					e.printStackTrace();
					return false;
				}
			case TYPE_DAY: {
				Pattern pattern1 = Pattern.compile("0(.)日");
				Pattern pattern2 = Pattern.compile("([0-9]*)日");
				Matcher matcher1 = pattern1.matcher(label);
				Matcher matcher2 = pattern2.matcher(label);
				if (matcher1.find()) {
					return dayValid(Integer.valueOf(matcher1.group(1)));
				} else if (matcher2.find()) {
					return dayValid(Integer.valueOf(matcher2.group(1)));
				}
				break;
			}
			case TYPE_MOTH: {
				Pattern pattern1 = Pattern.compile("0(.)月");
				Pattern pattern2 = Pattern.compile("([0-9]*)月");
				Matcher matcher1 = pattern1.matcher(label);
				Matcher matcher2 = pattern2.matcher(label);
				if (matcher1.find()) {
					int month = Integer.valueOf(matcher1.group(1));
					return month % 2 == 0;
				} else if (matcher2.find()) {
					int month = Integer.valueOf(matcher2.group(1));
					return month % 2 == 0;
				}
				break;
			}
		}
		return false;
	}


	private void updateXAxisType(int index) {
		if (mXAxis.getValues() == null || mXAxis.getValues().isEmpty()) {
			return;
		}
		if (mXAxis.getValues().size() > index) {
			String label = mXAxis.getValues().get(index);
			if (label == null || label.isEmpty()) {
				updateXAxisType(index + 1);
			} else {
				SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
				Calendar calendar = Calendar.getInstance();
				try {
					calendar.setTime(dataFormat.parse(label));
					mCurrentXAxisType = TYPE_TIME;
				} catch (ParseException e) {
					e.printStackTrace();
				}

				if (label.contains("月")) {
					mCurrentXAxisType = TYPE_MOTH;
				}

				if (label.contains("日")) {
					mCurrentXAxisType = TYPE_DAY;
				}

			}
		}
	}

	private int getMonthLastDay() {
		if (mXAxis.getValues() == null || mXAxis.getValues().isEmpty()) {
			return 0;
		}
		for (int index = mXAxis.getValues().size() - 1; index >= 0; index--) {
			String label = mXAxis.getValues().get(index);
			if (label != null && !label.isEmpty() && label.contains("日")) {
				Pattern pattern1 = Pattern.compile("0(.)日");
				Pattern pattern2 = Pattern.compile("([0-9]*)日");
				Matcher matcher1 = pattern1.matcher(label);
				Matcher matcher2 = pattern2.matcher(label);
				if (matcher1.find()) {
					return Integer.valueOf(matcher1.group(1));
				} else if (matcher2.find()) {
					return Integer.valueOf(matcher2.group(1));
				}
			}

		}
		return 0;
	}

	private boolean dayValid(int day) {
		switch (getMonthLastDay()) {
			case 28:
				return day % 5 == 3;
			case 29:
				return day % 5 == 4;
			case 30:
				return day % 5 == 0;
			case 31:
				return day % 5 == 1;
		}
		return false;
	}


}
