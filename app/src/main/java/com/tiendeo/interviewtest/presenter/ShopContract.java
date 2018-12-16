package com.tiendeo.interviewtest.presenter;

import com.tiendeo.interviewtest.model.Shop;

import java.util.List;

/**
 * The contract describes the communication between shops view and presenter.
 */
public interface ShopContract {

    interface View {
        // ad shops on list.
        void addResults(List<Shop> shopList);
        // show list.
        void showList();
        // remove content of list.
        void clearList();
        // show list is loading.
        void showListLoading();
        // hide list is loading view or whatever.
        void hideListLoading();
        // show something if there is an error.
        void showContentError();
        // hide the error.
        void hideContentError();
        // show that there is no content to show.
        void showEmptyResultsView();
        // hide empty result view
        void hideEmptyResultsView();
    }
    // Describes interactions between View and Presenter
    interface Presenter {
        // actions
        // load data from local o remote source.
        void load();
        // Load more data.
        void loadMore();
        // user events
        // do whatever when user click a list item.
        void shopClick(Shop shop);
        // attach the view.
        void attach();
        // detach the view.
        void detach();
        
    }
}
