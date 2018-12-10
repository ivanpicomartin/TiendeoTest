package com.tiendeo.interviewtest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by juanlu on 3/8/16.
 */
public class Shop {
  @SerializedName("address_city") String addressCity;
  @SerializedName("address_postal_code") String addressPostalCode;
  @SerializedName("address_street") String addressStreet;
  @SerializedName("has_catalogs") boolean hasCatalogs;
  @SerializedName("latitude") String latitude;
  @SerializedName("longitude") String longitude;
  @SerializedName("phone_number") String phoneNumber;
  @SerializedName("retailer_id") String retailerId;
  @SerializedName("retailer_name") String retailerName;
  @SerializedName("shop_id") String shopId;
  @SerializedName("shop_name") String shopName;
  @SerializedName("web") String web;

  public String getAddressCity() {
    return addressCity;
  }

  public void setAddressCity(String addressCity) {
    this.addressCity = addressCity;
  }

  public String getAddressPostalCode() {
    return addressPostalCode;
  }

  public void setAddressPostalCode(String addressPostalCode) {
    this.addressPostalCode = addressPostalCode;
  }

  public String getAddressStreet() {
    return addressStreet;
  }

  public void setAddressStreet(String addressStreet) {
    this.addressStreet = addressStreet;
  }

  public boolean isHasCatalogs() {
    return hasCatalogs;
  }

  public void setHasCatalogs(boolean hasCatalogs) {
    this.hasCatalogs = hasCatalogs;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getRetailerId() {
    return retailerId;
  }

  public void setRetailerId(String retailerId) {
    this.retailerId = retailerId;
  }

  public String getRetailerName() {
    return retailerName;
  }

  public void setRetailerName(String retailerName) {
    this.retailerName = retailerName;
  }

  public String getShopId() {
    return shopId;
  }

  public void setShopId(String shopId) {
    this.shopId = shopId;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public String getWeb() {
    return web;
  }

  public void setWeb(String web) {
    this.web = web;
  }
}
