package com.tuacy.designwidget.widget.chart;


import java.util.List;

public class LineChartDataSingle {

	private Float[]       mValue;
	private List<Integer> mColor;
	private String        mUnit;
	private List<String>  mXValues;
	private List<String>  mLineName;

	public LineChartDataSingle(Float[] value, List<Integer> color, String unit, List<String> xValues, List<String> lineName) {
		this.mValue = value;
		this.mColor = color;
		this.mUnit = unit;
		this.mXValues = xValues;
		this.mLineName = lineName;
	}

	public Float[] getValue() {
		return mValue;
	}

	public List<Integer> getColor() {
		return mColor;
	}

	public String getUnit() {
		return mUnit;
	}

	public List<String> getXValues() {
		return mXValues;
	}

	public List<String> getLineName() {
		return mLineName;
	}
}
