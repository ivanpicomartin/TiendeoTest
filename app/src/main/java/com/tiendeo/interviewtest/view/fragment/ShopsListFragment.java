package com.tiendeo.interviewtest.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tiendeo.interviewtest.R;
import com.tiendeo.interviewtest.adapter.ShopsAdapter;
import com.tiendeo.interviewtest.view.activity.ShopsActivity;

public class ShopsListFragment extends Fragment {
	private RecyclerView shopsView;
	private ShopsAdapter adapter;
	private ShopsActivity activity;

	public ShopsListFragment() {
		super();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_shops_list, container, false);
		shopsView = (RecyclerView) view.findViewById(R.id.shops_view);
		adapter = new ShopsAdapter();
		shopsView.setAdapter(adapter);
		shopsView.setLayoutManager(new LinearLayoutManager(container.getContext()));
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Call remote data service
		// populate list

	}

}