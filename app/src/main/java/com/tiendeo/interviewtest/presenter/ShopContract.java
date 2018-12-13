package com.tiendeo.interviewtest.presenter;

import com.tiendeo.interviewtest.model.Shop;

import java.util.List;

/**
 * The contract describes the communication between shops view and presenter
 */
public interface ShopContract {

    interface View {
        void addResults(List<Shop> shopList);
        void showList();
        void clearList();
        void showListLoading();
        void hideListLoading();
        void showContentError();
        void hideContentError();
        void showEmptyResultsView();
        void hideEmptyResultsView();
    }
    // Describes interactions between View and Presenter
    interface Presenter {
        // actions
        void load();
        void loadMore();
        // user events
        void shopClick(Shop shop);
        void attach();
        void detach();
        
    }
}
