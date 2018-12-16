package com.tiendeo.interviewtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiendeo.interviewtest.R;
import com.tiendeo.interviewtest.model.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for a list shops.
 */
public class ShopsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	List<Shop> shops = new ArrayList<Shop>();

	public void setShops(List<Shop> shops) {
		this.shops.clear();
		this.shops.addAll(shops);
		notifyDataSetChanged();
	}

	@Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ShopViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop, parent, false));
	}

	@Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		((ShopViewHolder) holder).bind(shops.get(position));
	}

	@Override public int getItemCount() {
		return shops.size();
	}

	class ShopViewHolder extends RecyclerView.ViewHolder {
		TextView shopNameView;
		TextView shopAddressView;

		public ShopViewHolder(View itemView) {
			super(itemView);
			shopNameView = (TextView) itemView.findViewById(R.id.shop_name_view);
			shopAddressView = (TextView) itemView.findViewById(R.id.shop_address_view);
		}

		public void bind(Shop shop) {
			shopNameView.setText(shop.getShopName());
			shopAddressView.setText(shop.getAddressStreet() + " " + shop.getAddressCity() + " " + shop.getAddressPostalCode());
		}
	}
}