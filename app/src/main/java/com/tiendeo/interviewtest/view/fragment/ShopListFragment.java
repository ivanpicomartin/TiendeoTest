package com.tiendeo.interviewtest.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tiendeo.interviewtest.R;
import com.tiendeo.interviewtest.adapter.ShopsAdapter;
import com.tiendeo.interviewtest.model.Shop;
import com.tiendeo.interviewtest.presenter.ShopContract;
import com.tiendeo.interviewtest.presenter.ShopListPresenter;

import java.util.List;

/**
 * Show a shop list.
 */
public class ShopListFragment extends Fragment implements ShopContract.View {
    private RecyclerView shopsView;
    private ShopsAdapter adapter;
    private ShopListPresenter shopListPresenter;

//    ButterKnife
//    @BindView(R.id.shop_list_error_connection)
    private TextView tvErrorConnection;

    public ShopListFragment() {
        super();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shopListPresenter = ShopListPresenter.getInstance(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shops_list, container, false);
        shopsView = (RecyclerView) view.findViewById(R.id.shops_view);
        adapter = new ShopsAdapter();
        shopsView.setAdapter(adapter);
        shopsView.setLayoutManager(new LinearLayoutManager(container.getContext()));

	    tvErrorConnection = (TextView) view.findViewById(R.id.shop_list_error_connection);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Call get data
        shopListPresenter.load();

    }

    @Override
    public void onResume() {
        super.onResume();
        shopListPresenter.attach();
    }

    @Override
    public void onPause() {
        super.onPause();
        shopListPresenter.detach();
    }

    @Override
    public void addResults(List<Shop> shopList) {
        adapter.setShops(shopList);
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
        tvErrorConnection.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideContentError() {
        tvErrorConnection.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showEmptyResultsView() {

    }

    @Override
    public void hideEmptyResultsView() {

    }
}
