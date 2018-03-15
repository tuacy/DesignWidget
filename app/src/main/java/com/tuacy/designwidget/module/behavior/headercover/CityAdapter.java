package com.tuacy.designwidget.module.behavior.headercover;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuacy.designwidget.R;

import java.util.List;


public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ItemHolder> {

	private List<String> mData;

	public CityAdapter(List<String> data) {
		mData = data;
	}

	@Override
	public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city, parent, false));
	}

	@Override
	public void onBindViewHolder(ItemHolder holder, int position) {
		holder.mTextCityInfo.setText(mData.get(position));
	}

	@Override
	public int getItemCount() {
		return mData == null ? 0 : mData.size();
	}

	static class ItemHolder extends RecyclerView.ViewHolder {

		TextView mTextCityInfo;

		ItemHolder(View itemView) {
			super(itemView);
			mTextCityInfo = itemView.findViewById(R.id.text_city_info);
		}
	}

}
