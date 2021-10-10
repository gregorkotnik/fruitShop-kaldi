package com.kaldi.kaldiFruitsShop.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.jetty.http.HttpStatus;

import com.codahale.metrics.annotation.Timed;
import com.kaldi.kaldiFruitsShop.model.Fruit;
import com.kaldi.kaldiFruitsShop.representation.FruitRepresentation;
import com.kaldi.kaldiFruitsShop.service.FruitsService;

@Path("/fruits")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("ADMIN")
public class FruitsResource {

	private final FruitsService fruitService;;

	public FruitsResource(final FruitsService fruitService) {
		this.fruitService = fruitService;
	}

	@GET
	@Timed
	public FruitRepresentation<List<Fruit>> getAllFruits() {
		return new FruitRepresentation<List<Fruit>>(HttpStatus.OK_200, fruitService.getAllFruits());
	}

	@GET
	@Timed
	@Path("{id}")
	public FruitRepresentation<Fruit> getFruitById(@PathParam("id") final int id) {
		return new FruitRepresentation<Fruit>(HttpStatus.OK_200, fruitService.getFruit(id));
	}

	@POST
	@Timed
	public FruitRepresentation<Fruit> createFruit(@NotNull @Valid final Fruit fruit) {
		return new FruitRepresentation<Fruit>(HttpStatus.OK_200, fruitService.createFruit(fruit));
	}

	@PUT
	@Timed
	@Path("{id}")
	public FruitRepresentation<Fruit> editFruit(@NotNull @Valid final Fruit fruit, @PathParam("id") final int id) {
		fruit.setId(id);
		return new FruitRepresentation<Fruit>(HttpStatus.OK_200, fruitService.editFruit(fruit));
	}

	@DELETE
	@Timed
	@Path("{id}")
	public FruitRepresentation<String> deleteFruit(@PathParam("id") final int id) {
		return new FruitRepresentation<String>(HttpStatus.OK_200, fruitService.deleteFruit(id));
	}

}
