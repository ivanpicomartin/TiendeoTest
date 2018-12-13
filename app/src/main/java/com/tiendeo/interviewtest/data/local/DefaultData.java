package com.tiendeo.interviewtest.data.local;

import com.google.android.gms.maps.model.LatLng;

public class DefaultData {

    private static final String TIENDEO_NAME_OFFICE = "Tiendeo Office";
    private static final float TIENDEO_MAP_DEFAULT_ZOOM = 16;
    private static final Double TIENDEO_LATITUDE = 41.380968;
    private static final Double TIENDEO_LONGITUDE = 2.185584;
    private static final LatLng TIENDEO = new LatLng(TIENDEO_LATITUDE, TIENDEO_LONGITUDE);

    public static String getTiendeoNameOffice() {
        return TIENDEO_NAME_OFFICE;
    }

    public static float getTiendeoMapDefaultZoom() {
        return TIENDEO_MAP_DEFAULT_ZOOM;
    }

    public static Double getTiendeoLatitude() {
        return TIENDEO_LATITUDE;
    }

    public static Double getTiendeoLongitude() {
        return TIENDEO_LONGITUDE;
    }

    public static LatLng getTiendeoPosition() {
        return TIENDEO;
    }
}
