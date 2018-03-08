package com.tuacy.designwidget.widget.chart;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 * LineDataSet 的构建
 */

public class LineDataSetBuilder {

	// 线宽
	private static final float LINE_CHART_LINE_WIDTH      = 1.0f;
	// 显示的圆形大小
	private static final float LINE_CHART_CIRCLE_RADIUS   = 2.5f;
	//折线的平滑度
	private static final float LINE_CHART_CUBIC_INTENSITY = 0.2f;

	private LineDataSet mLineDataSet;

	public LineDataSetBuilder(ArrayList<Entry> yValueEntry, String label, int lineColor) {
		mLineDataSet = new LineDataSet(yValueEntry, label);
		mLineDataSet.setLineWidth(LINE_CHART_LINE_WIDTH); // 线宽
		mLineDataSet.setCircleRadius(LINE_CHART_CIRCLE_RADIUS);// 显示的圆形大小
		mLineDataSet.setColor(lineColor);// 显示颜色
		mLineDataSet.setCircleColor(lineColor);// 圆形的颜色
		mLineDataSet.setHighLightColor(Color.rgb(180, 184, 185)); // 高亮的线的颜色
		mLineDataSet.setDrawHorizontalHighlightIndicator(false);//不画横线
		mLineDataSet.setDrawCircleHole(false);//设置圆点是否空心 false:为实心，true:为空心
		mLineDataSet.setDrawValues(false);//不在曲线的点上显示数据内容
		mLineDataSet.setDrawCircles(true);
		mLineDataSet.setCubicIntensity(LINE_CHART_CUBIC_INTENSITY);//设置折线的平滑度
		mLineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
	}

	public LineDataSetBuilder setFillColor(int color) {
		if (Build.VERSION.SDK_INT >= 18) {
			mLineDataSet.setFillDrawable(new ColorDrawable(color));
		} else {
			mLineDataSet.setFillColor(color);
		}
		return this;
	}

	public LineDataSetBuilder setDrawFilled(boolean filled) {
		mLineDataSet.setDrawFilled(filled);
		return this;
	}

	public LineDataSetBuilder setCircleRadius(float radius) {
		mLineDataSet.setCircleRadius(radius);
		return this;
	}

	public LineDataSet build() {
		return mLineDataSet;
	}

}
