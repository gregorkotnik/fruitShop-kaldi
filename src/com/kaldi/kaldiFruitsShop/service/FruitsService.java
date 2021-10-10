package com.kaldi.kaldiFruitsShop.service;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.skife.jdbi.v2.exceptions.UnableToExecuteStatementException;
import org.skife.jdbi.v2.exceptions.UnableToObtainConnectionException;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;

import com.kaldi.kaldiFruitsShop.dao.FruitsDAO;
import com.kaldi.kaldiFruitsShop.model.Fruit;

public abstract class FruitsService {

	@CreateSqlObject
	abstract FruitsDAO fruitsDAO();

	public List<Fruit> getAllFruits() {
		return fruitsDAO().getAllFruits();
	}

	public Fruit getFruit(final int id) {
		final Fruit fruit = fruitsDAO().getFruit(id);
		if (fruit == null) {
			throw new WebApplicationException(String.format("Fruit id %s not found.", id), Status.NOT_FOUND);
		}
		return fruit;
	}

	public Fruit createFruit(final Fruit fruit) {
		fruitsDAO().insertFurit(fruit);
		return fruitsDAO().getFruit(fruitsDAO().getLastInserFruitId());
	}

	public Fruit editFruit(final Fruit fruit) {
		if (fruitsDAO().getFruit(fruit.getId()) == null) {
			throw new WebApplicationException(String.format("Fruit id %s not found.", fruit.getId()), Status.NOT_FOUND);
		}
		fruitsDAO().editFruit(fruit);
		return fruitsDAO().getFruit(fruit.getId());
	}

	public String deleteFruit(final int id) {
		final int result = fruitsDAO().deleteFruit(id);
		switch (result) {
		case 1:
			return "Deleted success.";
		case 0:
			throw new WebApplicationException(String.format("Fruit id %s not found.", id), Status.NOT_FOUND);
		default:
			throw new WebApplicationException("An unexpected error occured while deleting...",
					Status.INTERNAL_SERVER_ERROR);
		}
	}

	public String HealthCheck() {
		try {
			fruitsDAO().getAllFruits();
		} catch (UnableToObtainConnectionException e) {
			return e.getLocalizedMessage();
		} catch (UnableToExecuteStatementException e) {
			return e.getLocalizedMessage();
		} catch (Exception e) {
			e.getCause().getLocalizedMessage();
		}
		return null;
	}
}
