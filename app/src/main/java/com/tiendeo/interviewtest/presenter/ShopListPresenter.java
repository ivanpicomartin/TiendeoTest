package com.tiendeo.interviewtest.presenter;

import android.os.AsyncTask;

import com.tiendeo.interviewtest.data.local.AppDatabase;
import com.tiendeo.interviewtest.data.local.LocalDatabase;
import com.tiendeo.interviewtest.data.remote.ShopApi;
import com.tiendeo.interviewtest.model.ErrorEvent;
import com.tiendeo.interviewtest.model.Shop;
import com.tiendeo.interviewtest.view.fragment.ShopListFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Listfragment presenter.
 *
 */
public class ShopListPresenter extends BasePresenter implements ShopContract.Presenter {

	private static ShopListPresenter shopListPresenter;
	// shop list view
	private static ShopListFragment shopListFragment;

	public ShopListPresenter() {
		super();
	}

	public static ShopListPresenter getInstance(ShopListFragment slFragment) {
		if (shopListPresenter == null) {
			shopListPresenter = new ShopListPresenter();
			shopListFragment = slFragment;
		}
		return shopListPresenter;
	}

	@Override
	public void load() {
		shopListFragment.hideContentError();
		shopListFragment.showListLoading();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				AppDatabase db = LocalDatabase
						.getInstance(shopListFragment.getContext())
						.getDb();
				List<Shop> list = db.shopDao().getAll();
				showShops(list);
			}
		};
		AsyncTask.execute(runnable);

		ShopApi shopApi = ShopApi.getInstance();
		shopApi.getShops();
	}

	@Override
	public void loadMore() {

	}

	@Override
	public void shopClick(Shop shop) {

	}

	@Override
	public void attach() {
		EventBus.getDefault().register(this);
	}

	@Override
	public void detach() {
		EventBus.getDefault().unregister(this);
	}

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onMessageEvent(final List<Shop> shopList) {
		showShops(shopList);
	}

	;

	@Subscribe(threadMode = ThreadMode.MAIN)
	public void onMessageEvent(ErrorEvent errorEvent) {
		if (errorEvent.getType() == ShopApi.ERROR_CONNECTION_TYPE) {
			shopListFragment.hideListLoading();
			shopListFragment.showContentError();
		}
	}

	// save and show shops on list.
	private void showShops(final List<Shop> shopList) {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				AppDatabase db = LocalDatabase
						.getInstance(shopListFragment.getContext())
						.getDb();
				db.shopDao().insertShops(shopList);
			}
		};
		AsyncTask.execute(runnable);
		shopListFragment.hideListLoading();
		shopListFragment.addResults(shopList);
	}
}
