package com.tuacy.designwidget.widget.chart;


import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.pilot.common.utils.ResourceUtils;
import com.tuacy.designwidget.R;

import java.util.List;

/**
 * 用于Line Chart 的一些设置
 */

public class LineChartBuilder {

	private LineChart mLineChart;

	public LineChartBuilder(Context context, LineChart lineChart) {
		defaultSettings(context, lineChart);
		mLineChart = lineChart;
	}

	/**
	 * 对line chart 做一些默认的设置
	 */
	private void defaultSettings(Context context, LineChart lineChart) {
		/**
		 * 清空之前的数据
		 */
		lineChart.clear();

		/**
		 * 设置LineChart的描述信息
		 */
		lineChart.setDescription(null);
		lineChart.setNoDataText(context.getString(R.string.empty));
		lineChart.setNoDataTextDescription("");

		/**
		 * 设置LineChart的表现信息如表格 颜色等
		 */
		lineChart.setDrawBorders(false);//是否在折线上添加边框
		lineChart.setDrawGridBackground(false);//是否显示表格颜色

		/**
		 * 设置LineChart缩放信息
		 */
		lineChart.setPinchZoom(true);//设置是否能放大、缩小
		lineChart.setTouchEnabled(true);//设置是否可以触摸，如为false，则不能拖动，缩放等
		lineChart.setDragEnabled(true);//设置是否可以拖拽
		lineChart.setScaleEnabled(true);//设置是否可以缩放
		lineChart.setScaleXEnabled(true);
		lineChart.setScaleYEnabled(false);

		/**
		 * 设置比例图标示，就是那个一组y的value的
		 */
		Legend mLegend = lineChart.getLegend();
		mLegend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
		mLegend.setForm(Legend.LegendForm.LINE);
		mLegend.setFormSize(6f);
		mLegend.setTextColor(Color.BLACK);

		/**
		 * 设置LineChart X Y轴坐标信息
		 */
		XAxis xAxis = lineChart.getXAxis();
		xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴的显示位置
		xAxis.setDrawAxisLine(true);           //设置显示x轴
		xAxis.setDrawGridLines(false);  //设置是否显示X轴表格
		xAxis.setAvoidFirstLastClipping(false); //设置x轴起点和终点label不超出屏幕
		xAxis.setSpaceBetweenLabels(0); // 设置x轴label不间隔
		xAxis.setTextColor(ResourceUtils.getColor(context, R.color.colorPrimaryText));
		xAxis.setAxisLineColor(ResourceUtils.getColor(context, R.color.colorPrimaryText));

		/**
		 * 得到图表的左侧Y轴实例
		 */
		YAxis leftYAxis = lineChart.getAxisLeft();
		leftYAxis.setEnabled(true);
		leftYAxis.setDrawAxisLine(true);//设置显示左侧Y轴(左侧Y轴的线是否显示)
		leftYAxis.setDrawGridLines(true);//设置是否显示左侧Y轴表格(平行X轴的线)
		//		leftYAxis.setAxisMinValue(0f);// 设置左侧Y轴最小值。
		leftYAxis.setShowOnlyMinMax(true);//设置Y轴数据显示格式
		leftYAxis.setLabelCount(6, true);
		leftYAxis.enableGridDashedLine(10f, 10f, 0f); //设置左侧Y轴表格虚线
		leftYAxis.setZeroLineColor(ResourceUtils.getColor(context, android.R.color.holo_red_dark));
		leftYAxis.setDrawZeroLine(false);
		leftYAxis.setTextColor(ResourceUtils.getColor(context, R.color.colorPrimaryText));
		leftYAxis.setAxisLineColor(ResourceUtils.getColor(context, R.color.colorPrimaryText));
		leftYAxis.setGridColor(ResourceUtils.getColor(context, R.color.colorPrimaryText));

		/**
		 * 得到图表的右侧Y轴实例
		 */
		YAxis rightYAxis = lineChart.getAxisRight();
		rightYAxis.setEnabled(false);
		rightYAxis.setDrawAxisLine(true);
		rightYAxis.setDrawGridLines(true);

//		/**
//		 * 点击标记
//		 */
//		MarkerView markView = new LineMarkView(context);
//		lineChart.setMarkerView(markView);

	}

	/**
	 * 设置缩放信息
	 */
	public LineChartBuilder setZoomEnabled(boolean enabled) {
		mLineChart.setPinchZoom(enabled);//设置是否能放大、缩小
		mLineChart.setScaleEnabled(enabled);//设置是否可以缩放
		mLineChart.setScaleXEnabled(enabled);
		mLineChart.setScaleYEnabled(enabled);
		return this;
	}

	/**
	 * 设置是否可以点击
	 */
	public LineChartBuilder setTouchEnabled(boolean clickable) {
		mLineChart.setTouchEnabled(clickable);
		return this;
	}

	/**
	 * 是否显示设置比例图标示
	 */
	public LineChartBuilder setLegendEnable(boolean isEnable) {
		Legend legend = mLineChart.getLegend();
		legend.setEnabled(isEnable);
		return this;
	}

	/**
	 * 设置比例图标示位置
	 */
	public LineChartBuilder setLegendPosition(Legend.LegendPosition position) {
		Legend legend = mLineChart.getLegend();
		legend.setEnabled(true);
		legend.setPosition(position);
		return this;
	}

	/**
	 * 设置比例图标示的形式
	 */
	public LineChartBuilder setLegendForm(Legend.LegendForm form) {
		Legend legend = mLineChart.getLegend();
		legend.setEnabled(true);
		legend.setForm(form);
		return this;
	}

	/**
	 * 设置比例图标示的文字的大小
	 */
	public LineChartBuilder setLegendFormSize(float size) {
		Legend legend = mLineChart.getLegend();
		legend.setFormSize(size);
		return this;
	}

	/**
	 * 设置比例图标示的位置的颜色
	 */
	public LineChartBuilder setLegendTextColor(int color) {
		Legend legend = mLineChart.getLegend();
		legend.setTextColor(color);
		return this;
	}

	/**
	 * 设置X轴是否显示
	 */
	public LineChartBuilder setXAxisEnable(boolean enable) {
		XAxis xAxis = mLineChart.getXAxis();
		xAxis.setEnabled(enable);
		return this;
	}

	/**
	 * 设置X轴的位置
	 */
	public LineChartBuilder setXAxisPosition(XAxis.XAxisPosition position) {
		XAxis xAxis = mLineChart.getXAxis();
		xAxis.setEnabled(true);
		xAxis.setPosition(position);
		return this;
	}

	/**
	 * 设置X轴的跳跃间隔
	 */
	public LineChartBuilder setXAxisLabelsToSkip(int count) {
		XAxis xAxis = mLineChart.getXAxis();
		xAxis.setEnabled(true);
		xAxis.setLabelsToSkip(count);
		return this;
	}

	/**
	 * 设置X轴的跳跃间隔
	 */
	public LineChartBuilder resetXAxisLabelsToSkip() {
		XAxis xAxis = mLineChart.getXAxis();
		xAxis.setEnabled(true);
		xAxis.resetLabelsToSkip();
		return this;
	}

	/**
	 * 设置左侧y轴，formatter
	 */
	public LineChartBuilder setAxisLeftValueFormatter(YAxisValueFormatter f) {
		YAxis leftYAxis = mLineChart.getAxisLeft();
		leftYAxis.setEnabled(true);
		leftYAxis.setValueFormatter(f);
		return this;
	}

	/**
	 * 设置左侧y轴，最小值
	 */
	public LineChartBuilder setAxisLeftMinValue(float min) {
		YAxis leftYAxis = mLineChart.getAxisLeft();
		leftYAxis.setEnabled(true);
		leftYAxis.setAxisMinValue(min);
		return this;
	}

	/**
	 * 设置左侧y轴，最小值
	 */
	public LineChartBuilder setAxisLeftMaxValue(float max) {
		YAxis leftYAxis = mLineChart.getAxisLeft();
		leftYAxis.setEnabled(true);
		leftYAxis.setAxisMaxValue(max);
		return this;
	}

	/**
	 *
	 * @param v
	 * @return
	 */
	public LineChartBuilder setMarkerView(MarkerView v) {
		mLineChart.setMarkerView(v);
		return this;
	}

	/**
	 * 设置限制线
	 */
	public LineChartBuilder setLimitLine(LimitLine limitLine) {
		YAxis leftAxis = mLineChart.getAxisLeft();// Y轴对象设置
		leftAxis.removeAllLimitLines();
		leftAxis.addLimitLine(limitLine);// 把线添加到轴上
		return this;
	}

	/**
	 * 设置限制线
	 */
	public LineChartBuilder setLimitLine(List<LimitLine> limitLines) {
		YAxis leftAxis = mLineChart.getAxisLeft();// Y轴对象设置
		leftAxis.removeAllLimitLines();
		for (LimitLine limitLine : limitLines) {
			leftAxis.addLimitLine(limitLine);// 把线添加到轴上
		}
		return this;
	}

	/**
	 * 设置x轴标签之间的空间字符数，默认是4个
	 */
	public LineChartBuilder setSpaceBetweenLabels(int spaceCharacters) {
		XAxis xAxis = mLineChart.getXAxis();
		xAxis.setSpaceBetweenLabels(spaceCharacters);
		return this;
	}

	public void build(LineData lineData, float maxXRange) {
		mLineChart.setData(lineData);

		/**
		 * 设置LineChart默认显示元素个数
		 */
		mLineChart.setVisibleXRangeMaximum(maxXRange);
		mLineChart.setVisibleXRangeMinimum(maxXRange);

		/**
		 * 设置LineChart重绘
		 */
		mLineChart.invalidate();
	}

	public void build(LineData lineData) {
		mLineChart.setData(lineData);

		/**
		 * 设置LineChart重绘
		 */
		mLineChart.invalidate();
	}
}
