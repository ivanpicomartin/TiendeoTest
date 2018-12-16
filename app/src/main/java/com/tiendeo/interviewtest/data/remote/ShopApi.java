package com.tiendeo.interviewtest.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tiendeo.interviewtest.model.ErrorEvent;
import com.tiendeo.interviewtest.model.Shop;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class to access to remote data.
 */
public class ShopApi {

	private static final String API_URL = "https://interview-test-45073.firebaseio.com/";
	public static final int ERROR_CONNECTION_TYPE = -1;

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
			// dependency
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

	public void getShops() {
		ShopApiInterface shopApiInterface = getService();

		Call<List<Shop>> call = shopApiInterface.getShops();
		call.enqueue(new Callback<List<Shop>>() {
			@Override
			public void onResponse(Call<List<Shop>> call, Response<List<Shop>> response) {
				EventBus.getDefault().post(response.body());
			}

			@Override
			public void onFailure(Call<List<Shop>> call, Throwable t) {

				EventBus.getDefault().post(new ErrorEvent(ERROR_CONNECTION_TYPE));
			}
		});
	}

}
