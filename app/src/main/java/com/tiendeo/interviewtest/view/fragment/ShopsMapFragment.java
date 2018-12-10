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
import com.tiendeo.interviewtest.data.remote.ShopApi;
import com.tiendeo.interviewtest.model.Shop;
import com.tiendeo.interviewtest.view.activity.ShopsActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopsMapFragment extends SupportMapFragment implements OnMapReadyCallback, Callback<List<Shop>> {
	private GoogleMap map;

	public ShopsMapFragment() {
		super();
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
		map.addMarker(new MarkerOptions().position(ShopApi.getTiendeoPosition()).title(ShopApi.getTiendeoNameOffice()));
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(ShopApi.getTiendeoPosition(), ShopApi.getTiendeoMapDefaultZoom()));

		ShopApi shopApi = ShopApi.getInstance();
		shopApi.getShops(this);
	}

	@Override
	public void onResponse(Call<List<Shop>> call, Response<List<Shop>> response) {

		for (final Shop shop : response.body()) {
			final LatLng location =
					new LatLng(Float.valueOf(shop.getLatitude().replace(",", ".")), Float.valueOf(shop.getLongitude().replace(",", ".")));
			this.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					map.addMarker(new MarkerOptions().position(location).title(shop.getRetailerName()).snippet(shop.getAddressStreet()));
				}
			});
		}
	}

	@Override
	public void onFailure(Call<List<Shop>> call, Throwable t) {
		// Manage the error
	}
}