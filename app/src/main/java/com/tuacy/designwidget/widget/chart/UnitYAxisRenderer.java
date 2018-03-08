package com.tuacy.designwidget.widget.chart;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class UnitYAxisRenderer extends YAxisRenderer {

	private Paint  mAxisUnitPaint;
	private String mUnit;

	public UnitYAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer trans, String unit) {
		super(viewPortHandler, yAxis, trans);
		mAxisUnitPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mUnit = unit;
	}

	@Override
	protected void drawYLabels(Canvas c, float fixedPosition, float[] positions, float offset) {
		super.drawYLabels(c, fixedPosition, positions, offset);
		if (mUnit != null && !mUnit.isEmpty() && mYAxis.mEntryCount >= 0) {
			Paint.FontMetrics fontMetrics = mAxisLabelPaint.getFontMetrics();
			float height = fontMetrics.bottom - fontMetrics.top;
			float unitY = positions[(mYAxis.mEntryCount - 1) * 2 + 1] + offset - height;

			mAxisUnitPaint.setTypeface(mYAxis.getTypeface());
			mAxisUnitPaint.setTextSize(mYAxis.getTextSize());
			mAxisUnitPaint.setColor(mYAxis.getTextColor());
			if (mAxisUnitPaint.measureText(mUnit) > fixedPosition) {
				mAxisUnitPaint.setTextAlign(Paint.Align.LEFT);
				c.drawText(mUnit, 0, unitY, mAxisUnitPaint);
			} else {
				mAxisUnitPaint.setTextAlign(Paint.Align.RIGHT);
				c.drawText(mUnit, fixedPosition, unitY, mAxisUnitPaint);
			}
		}

	}
}
