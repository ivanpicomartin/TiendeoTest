package com.tiendeo.interviewtest.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShopApi {

    private static final String API_URL = "https://interview-test-45073.firebaseio.com/";

    public ShopApi getService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(ShopApi.class);
    }

}
