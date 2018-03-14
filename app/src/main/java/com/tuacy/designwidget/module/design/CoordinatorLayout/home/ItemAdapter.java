package com.tuacy.designwidget.module.design.CoordinatorLayout.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuacy.designwidget.R;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

	private int    mCount;
	private String mTitle;

	ItemAdapter(int count, String title) {
		mCount = count;
		mTitle = title;
	}

	@Override
	public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_content, parent, false));
	}

	@Override
	public void onBindViewHolder(ItemHolder holder, int position) {
		holder.mTextItem.setText(mTitle + " " + position);
		holder.mTextItem.setBackgroundResource(position % 2 == 0 ? R.color.colorOdd : R.color.colorEven);
	}

	@Override
	public int getItemCount() {
		return mCount;
	}

	static class ItemHolder extends RecyclerView.ViewHolder {

		TextView mTextItem;

		ItemHolder(View itemView) {
			super(itemView);
			mTextItem = itemView.findViewById(R.id.text_item_text);
		}
	}

}
