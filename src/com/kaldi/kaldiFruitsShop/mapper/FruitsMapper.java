package com.kaldi.kaldiFruitsShop.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.kaldi.kaldiFruitsShop.model.Fruit;

public class FruitsMapper implements ResultSetMapper<Fruit> {

	private static final String ID = "fruit_id";
	private static final String FRUIT_TYPE = "fruit_type";
	private static final String QUANTITY = "fruit_quantity";

	public Fruit map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Fruit(r.getInt(ID), r.getString(FRUIT_TYPE), r.getDouble(QUANTITY));
	}

}
