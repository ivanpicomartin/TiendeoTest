package com.tiendeo.interviewtest.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tiendeo.interviewtest.model.Shop;

@Database(entities = {Shop.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

	public abstract ShopDao shopDao();

}
