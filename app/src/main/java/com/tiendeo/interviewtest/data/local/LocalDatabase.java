package com.tiendeo.interviewtest.data.local;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * local database instance
 */
public class LocalDatabase {

	private static AppDatabase db;
	private static LocalDatabase localDatabase;

	public static LocalDatabase getInstance(Context context) {
		if (localDatabase == null) {
			localDatabase = new LocalDatabase();
			db = Room.databaseBuilder(context,
					AppDatabase.class,
					DefaultData.getDatabaseName()).build();
		}
		return localDatabase;
	}

	public static AppDatabase getDb() {
		return db;
	}

	public static LocalDatabase getLocalDatabase() {
		return localDatabase;
	}
}
