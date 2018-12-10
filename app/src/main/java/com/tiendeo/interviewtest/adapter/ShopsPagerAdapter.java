package com.tiendeo.interviewtest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tiendeo.interviewtest.view.activity.ShopsActivity;
import com.tiendeo.interviewtest.view.fragment.ShopsListFragment;
import com.tiendeo.interviewtest.view.fragment.ShopsMapFragment;

public class ShopsPagerAdapter extends FragmentPagerAdapter {

	public ShopsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		if (position == 0) return new ShopsListFragment();
		return new ShopsMapFragment();
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
			case 0:
				return "List";
			case 1:
				return "Map";
		}
		return null;
	}
}
