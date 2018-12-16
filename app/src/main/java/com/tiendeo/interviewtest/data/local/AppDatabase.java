package com.tiendeo.interviewtest.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tiendeo.interviewtest.model.Shop;

/**
 * Daos declarations.
 */
@Database(entities = {Shop.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

	// manage to get shop daos.
	public abstract ShopDao shopDao();

}
