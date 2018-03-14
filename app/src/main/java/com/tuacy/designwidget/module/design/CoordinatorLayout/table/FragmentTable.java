package com.tuacy.designwidget.module.design.CoordinatorLayout.table;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.pilot.common.utils.DensityUtils;
import com.pilot.common.utils.ResourceUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileFragment;
import com.tuacy.designwidget.widget.chart.LineChartBuilder;
import com.tuacy.designwidget.widget.chart.LineDataSetBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.github.mikephil.charting.components.Legend.LegendPosition.ABOVE_CHART_CENTER;


public class FragmentTable extends BaseMobileFragment {

	public static FragmentTable instance() {
		return new FragmentTable();
	}

	private LineChart          mLineChart;
	private RecyclerView       mRecyclerTable;
	private SmartRefreshLayout mSmartRefreshLayout;

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_table;
	}

	@Override
	protected void initViews(View root) {
		mLineChart = root.findViewById(R.id.chart_detail);
		mRecyclerTable = root.findViewById(R.id.recycler_table);
		TableLayoutManager layoutManager = new TableLayoutManager.Build(mContext).setColumnCount(6)
																				 .setFixColumnCount(1)
																				 .setFixHeader(true)
																				 .setHeadHeight(DensityUtils.dp2px(mContext, 32))
																				 .setRowHeight(DensityUtils.dp2px(mContext, 40))
																				 .setWidgetCount(3)
																				 .build();
		mRecyclerTable.setLayoutManager(layoutManager);
		mRecyclerTable.addItemDecoration(new TableItemDecoration(mContext));
		mSmartRefreshLayout = root.findViewById(R.id.refreshLayout);
		mSmartRefreshLayout.setRefreshHeader(new ClassicsHeader(mContext));
	}

	@Override
	protected void initListeners() {
		mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh(RefreshLayout refreshlayout) {
				refreshlayout.finishRefresh(2000);
			}
		});
		mSmartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
			@Override
			public void onLoadmore(RefreshLayout refreshlayout) {
				refreshlayout.finishLoadmore(2000);
			}
		});
	}

	@Override
	protected void initData() {

		//line chart data
		List<String> xValues = new ArrayList<>();
		for (int index = 0; index < 24; index++) {
			xValues.add(String.format(Locale.getDefault(), "%02d:00", index));
		}
		//曲线描述
		List<String> lineName = new ArrayList<>();
		lineName.add("A相电压");
		lineName.add("B相电压");
		lineName.add("C相电压");
		lineName.add("A相电流");
		lineName.add("B相电流");
		List<ILineDataSet> lineDataSets = new ArrayList<>();
		for (int index = 0; index < 5; index++) {
			ArrayList<Entry> entryList = new ArrayList<>();
			for (int loop = 0; loop < 24; loop++) {
				entryList.add(new Entry(index * 10 + loop, loop));
			}
			LineDataSetBuilder setBuilder = new LineDataSetBuilder(entryList, lineName.get(index),
																   getLineChartColor(index)).setCircleRadius(1.5f / 2);
			lineDataSets.add(setBuilder.build());
		}
		LineChartBuilder builder = new LineChartBuilder(mContext, mLineChart).setLegendPosition(ABOVE_CHART_CENTER)
																			 .setAxisLeftValueFormatter(new YAxisValueFormatter() {
																				 @Override
																				 public String getFormattedValue(float value, YAxis yAxis) {
																					 return String.format(Locale.getDefault(), "%.02f",
																										  value);
																				 }
																			 })
																			 .setSpaceBetweenLabels(4);
		if (lineDataSets.isEmpty()) {
			mLineChart.clear();
		} else {
			builder.build(new LineData(xValues, lineDataSets));
		}

		//table 25*6
		List<String> tableDataList = new ArrayList<>();
		tableDataList.add("时间");
		tableDataList.add("A相电压");
		tableDataList.add("B相电压");
		tableDataList.add("C相电压");
		tableDataList.add("A相电流");
		tableDataList.add("B相电流");
		for (int row = 1; row < 25; row++) {
			for (int column = 0; column < 6; column++) {
				if (column == 0) {
					tableDataList.add(String.format(Locale.getDefault(), "%02d:00", row - 1));
				} else {
					tableDataList.add(((row - 1) * 10 + (column - 1)) + "");
				}
			}
		}
		mRecyclerTable.setAdapter(new TableAdapter(mContext, tableDataList));


	}

	private int getLineChartColor(int index) {
		int[] colors = {R.color.curve_line_color_1,
						R.color.curve_line_color_2,
						R.color.curve_line_color_3,
						R.color.curve_line_color_4,
						R.color.curve_line_color_5,
						R.color.curve_line_color_6,
						R.color.curve_line_color_7,
						R.color.curve_line_color_8,
						R.color.curve_line_color_9,
						R.color.curve_line_color_10,
						R.color.curve_line_color_11,
						R.color.curve_line_color_12,
						R.color.curve_line_color_13};
		return ResourceUtils.getColor(mContext, colors[index % colors.length]);
	}

}
