package com.tiendeo.interviewtest.presenter;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tiendeo.interviewtest.data.remote.ShopApi;
import com.tiendeo.interviewtest.model.ErrorEvent;
import com.tiendeo.interviewtest.model.Shop;
import com.tiendeo.interviewtest.view.fragment.ShopListFragment;
import com.tiendeo.interviewtest.view.fragment.ShopsMapFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class ShopsMapPresenter extends BasePresenter implements ShopContract.Presenter {


    private static ShopsMapPresenter shopsMapPresenter;
    private static ShopsMapFragment shopsMapFragment;

    public static ShopsMapPresenter getInstance(ShopsMapFragment smFragment) {
        if (shopsMapPresenter == null) {
            shopsMapPresenter = new ShopsMapPresenter();
            shopsMapFragment = smFragment;
        }
        return shopsMapPresenter;
    }

    @Override
    public void load() {
        ShopApi shopApi = ShopApi.getInstance();
        shopApi.getShops();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(List<Shop> shopList) {
        shopsMapFragment.addResults(shopList);

    };

    @Override
    public void loadMore() {

    }

    @Override
    public void shopClick(Shop shop) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ErrorEvent errorEvent) {
        if(errorEvent.getType() == ShopApi.ERROR_CONNECTION_TYPE) {
            shopsMapFragment.showContentError();
        }
    };

    @Override
    public void attach() {
        Log.d("TAGTAG", "attach");
        EventBus.getDefault().register(this);
    }

    @Override
    public void detach() {
        Log.d("TAGTAG", "detach");
        EventBus.getDefault().unregister(this);
    }
}
