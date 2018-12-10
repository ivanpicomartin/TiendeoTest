package com.tiendeo.interviewtest.data.remote;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tiendeo.interviewtest.model.Shop;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShopApi {

	private static final String API_URL = "https://interview-test-45073.firebaseio.com/";
	private static final String TIENDEO_NAME_OFFICE = "Tiendeo Office";
	private static final float TIENDEO_MAP_DEFAULT_ZOOM = 16;
	private static final Double TIENDEO_LATITUDE = 41.380968;
	private static final Double TIENDEO_LONGITUDE = 2.185584;
	private static final LatLng TIENDEO = new LatLng(TIENDEO_LATITUDE, TIENDEO_LONGITUDE);
	private static Retrofit retrofit = null;

	private static ShopApi shopApi;

	public static ShopApi getInstance() {
		if (shopApi == null) {
			shopApi = new ShopApi();
		}
		return shopApi;
	}

	private Retrofit startRetrofit() {
		if (ShopApi.retrofit == null) {
			Gson gson = new GsonBuilder()
					.setLenient()
					.create();

			ShopApi.retrofit = new Retrofit.Builder()
					.baseUrl(API_URL)
					.addConverterFactory(GsonConverterFactory.create(gson))
					.build();

		}
		return ShopApi.retrofit;
	}

	private ShopApiInterface getService() {
		return startRetrofit().create(ShopApiInterface.class);
	}

	public void getShops(Callback<List<Shop>> callback) {
		ShopApiInterface shopApiInterface = getService();

		Call<List<Shop>> call = shopApiInterface.getShops();
		call.enqueue(callback);
	}

	public static LatLng getTiendeoPosition() {
		return TIENDEO;
	}

	public static String getTiendeoNameOffice() {
		return TIENDEO_NAME_OFFICE;
	}

	public static float getTiendeoMapDefaultZoom() {
		return TIENDEO_MAP_DEFAULT_ZOOM;
	}

}
