package com.tiendeo.interviewtest.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.tiendeo.interviewtest.R;
import com.tiendeo.interviewtest.adapter.ShopsPagerAdapter;
import com.tiendeo.interviewtest.model.Shop;
import com.tiendeo.interviewtest.presenter.ShopContract;

import java.util.List;

public class ShopsActivity extends BaseActivity implements OnMapReadyCallback, ShopContract.View {

	private ViewPager viewPager;
	private ShopsPagerAdapter pagerAdapter;
	private Toolbar toolbar;
	private TabLayout tabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shops);

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		pagerAdapter = new ShopsPagerAdapter(getSupportFragmentManager());
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(pagerAdapter);

		tabLayout = (TabLayout) findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(viewPager);


	}

	@Override
	public void onMapReady(GoogleMap googleMap) {

	}

	@Override
	public void showEmptyResultsView() {

	}

	@Override
	public void hideEmptyResultsView() {

	}

	@Override
	public void addResults(List<Shop> shopList) {

	}

	@Override
	public void showList() {

	}

	@Override
	public void clearList() {

	}

	@Override
	public void showListLoading() {

	}

	@Override
	public void hideListLoading() {

	}

	@Override
	public void showContentError() {

	}

	@Override
	public void hideContentError() {

	}

}
