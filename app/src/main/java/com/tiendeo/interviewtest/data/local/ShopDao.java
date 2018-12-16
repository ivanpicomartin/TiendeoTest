package com.tiendeo.interviewtest.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tiendeo.interviewtest.model.Shop;

import java.util.List;

@Dao
public interface ShopDao {

	@Query("SELECT * FROM shop")
	List<Shop> getAll();

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	public void insertShops(List<Shop> shopList);

}
