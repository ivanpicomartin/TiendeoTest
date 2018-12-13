package com.tiendeo.interviewtest.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tiendeo.interviewtest.data.local.DefaultData;
import com.tiendeo.interviewtest.model.Shop;
import com.tiendeo.interviewtest.presenter.DialogFactory;
import com.tiendeo.interviewtest.presenter.ShopContract;
import com.tiendeo.interviewtest.presenter.ShopsMapPresenter;

import java.util.List;

public class ShopsMapFragment extends SupportMapFragment implements OnMapReadyCallback, ShopContract.View {
    private GoogleMap map;
    private ShopsMapPresenter shopMapPresenter;

    public ShopsMapFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shopMapPresenter = ShopsMapPresenter.getInstance(this);
    }
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle bundle) {
        View view = super.onCreateView(layoutInflater, container, bundle);
        getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(new MarkerOptions()
            .position(DefaultData.getTiendeoPosition())
            .title(DefaultData.getTiendeoNameOffice()));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
            DefaultData.getTiendeoPosition(),
            DefaultData.getTiendeoMapDefaultZoom()));

        shopMapPresenter.load();

    }

	@Override
	public void onResume() {
		super.onResume();
		shopMapPresenter.attach();
	}

	@Override
	public void onPause() {
		super.onPause();
		shopMapPresenter.detach();
	}

    @Override
    public void addResults(List<Shop> shopList) {
        for (final Shop shop : shopList) {
            final LatLng location =
                    new LatLng(Float.valueOf(shop.getLatitude().replace(",", ".")),
                            Float.valueOf(shop.getLongitude().replace(",", ".")));
            this.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    map.addMarker(new MarkerOptions()
                            .position(location)
                            .title(shop.getRetailerName())
                            .snippet(shop.getAddressStreet()));
                }
            });
        }
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
        DialogFactory.createErrorConnectionAlert(getContext());
    }

    @Override
    public void hideContentError() {

    }

    @Override
    public void showEmptyResultsView() {

    }

    @Override
    public void hideEmptyResultsView() {

    }
}