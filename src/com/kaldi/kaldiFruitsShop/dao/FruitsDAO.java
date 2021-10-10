package com.kaldi.kaldiFruitsShop.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.kaldi.kaldiFruitsShop.mapper.FruitsMapper;
import com.kaldi.kaldiFruitsShop.model.Fruit;

@RegisterMapper(FruitsMapper.class)
public interface FruitsDAO {

	@SqlQuery("Select * from kaldi_fruits_shop")
	public List<Fruit> getAllFruits();

	@SqlQuery("Select * from kaldi_fruits_shop where fruit_id = :id")
	public Fruit getFruit(@Bind("id") final int id);

	@SqlUpdate("insert into kaldi_fruits_shop(fruit_type,fruit_quantity) values(:fruitName, :quantity)")
	public void insertFurit(@BindBean final Fruit fruit);

	@SqlUpdate("update kaldi_fruits_shop set fruit_type = coalesce(:fruitName , fruit_type), fruit_quantity = coalesce(:quantity,fruit_quantity) where fruit_id = :id")
	public void editFruit(@BindBean final Fruit fruit);

	@SqlUpdate("delete from kaldi_fruits_shop where fruit_id = :id")
	public int deleteFruit(@Bind("id") final int id);

	@SqlQuery("select last_insert_id();")
	public int getLastInserFruitId();

}
