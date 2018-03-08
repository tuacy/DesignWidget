package com.tuacy.designwidget.widget.chart;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.pilot.common.utils.DensityUtils;
import com.pilot.common.utils.ResourceUtils;
import com.tuacy.designwidget.R;

import java.util.Locale;

import static android.graphics.drawable.GradientDrawable.OVAL;

public class LineMarkView extends MarkerView {

	private LinearLayout mLayoutDes;
	private TextView     mViewTime;
	private TextView     mViewUnit;
	private Context      mContext;


	/**
	 * Constructor. Sets up the MarkerView with a custom layout resource.
	 */
	public LineMarkView(Context context) {
		super(context, R.layout.view_line_mark_view);
		mContext = context;
		mViewTime = findViewById(R.id.text_view_line_mark_time);
		mViewUnit = findViewById(R.id.text_view_line_unit);
		mLayoutDes = findViewById(R.id.layout_line_chart_des);
	}

	@Override
	public void refreshContent(Entry e, Highlight highlight) {
		if (e.getData() instanceof LineChartDataSingle) {
			LineChartDataSingle dataSingle = (LineChartDataSingle) e.getData();
			String timeValue = dataSingle.getXValues().get(e.getXIndex());
			mViewTime.setText(timeValue);
			mViewUnit.setText(String.format(Locale.getDefault(), "(%s)", dataSingle.getUnit()));
			mLayoutDes.removeAllViews();
			if (dataSingle.getValue() != null && dataSingle.getValue().length > 0) {
				for (int index = 0; index < dataSingle.getValue().length; index++) {
					if (dataSingle.getValue()[index] != null) {
						View itemLayout = LayoutInflater.from(getContext()).inflate(R.layout.item_mark_line, mLayoutDes, false);
						ImageView lineColorFlag = itemLayout.findViewById(R.id.image_line_color);
						TextView lineText = itemLayout.findViewById(R.id.text_line_title);
						TextView lineValue = itemLayout.findViewById(R.id.text_line_value);
						GradientDrawable flagSrc = new GradientDrawable();
						flagSrc.setShape(OVAL);
						flagSrc.setStroke(DensityUtils.dp2px(mContext, 0.5f), ResourceUtils.getColor(getContext(), android.R.color.white));
						flagSrc.setColor(dataSingle.getColor().get(index));
						flagSrc.setSize(DensityUtils.dp2px(mContext, 8), DensityUtils.dp2px(mContext, 8));
						lineColorFlag.setImageDrawable(flagSrc);
						lineValue.setText(String.format(Locale.getDefault(), "%.02f", dataSingle.getValue()[index]));
						lineText.setText(String.format(Locale.getDefault(), "%s:", dataSingle.getLineName().get(index)));
						mLayoutDes.addView(itemLayout);
					}
				}
			}
		}

	}

	@Override
	public int getXOffset(float xpos) {
		return -(getWidth() / 2);
	}

	@Override
	public int getYOffset(float ypos) {
		return -getHeight();
	}
}
