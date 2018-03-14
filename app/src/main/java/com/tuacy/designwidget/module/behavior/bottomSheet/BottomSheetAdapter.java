package com.tuacy.designwidget.module.behavior.bottomSheet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuacy.designwidget.R;

import java.util.List;


public class BottomSheetAdapter extends RecyclerView.Adapter<BottomSheetAdapter.ItemHolder> {

	private List<String> mDataList;

	BottomSheetAdapter(List<String> dataList) {
		mDataList = dataList;
	}

	@Override
	public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sheet, parent, false));
	}

	@Override
	public void onBindViewHolder(ItemHolder holder, int position) {
		holder.mTextItem.setText(mDataList.get(position));
		holder.itemView.setBackgroundResource(position % 2 == 0 ? R.color.colorEven : R.color.colorOdd);
	}

	@Override
	public int getItemCount() {
		return mDataList == null ? 0 : mDataList.size();
	}

	static class ItemHolder extends RecyclerView.ViewHolder {

		TextView mTextItem;

		ItemHolder(View itemView) {
			super(itemView);
			mTextItem = itemView.findViewById(R.id.text_item_text);
		}
	}

}
