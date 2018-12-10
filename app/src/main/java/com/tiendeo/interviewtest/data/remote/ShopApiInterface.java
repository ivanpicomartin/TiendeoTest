package com.tiendeo.interviewtest.data.remote;

import com.tiendeo.interviewtest.model.Shop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShopApiInterface {

        @GET("shops.json")
        Call<List<Shop>> getShops();
}
