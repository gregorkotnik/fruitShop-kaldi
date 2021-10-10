package com.kaldi.kaldiFruitsShop;

import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;

import com.kaldi.kaldiFruitsShop.configuration.KaldiConfiguration;
import com.kaldi.kaldiFruitsShop.health.KaldiDbHealthCheck;
import com.kaldi.kaldiFruitsShop.resource.FruitsResource;
import com.kaldi.kaldiFruitsShop.service.FruitsService;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class KaldiFruitsShopApplication extends Application<KaldiConfiguration> {
	public static void main(String[] args) throws Exception {
		new KaldiFruitsShopApplication().run(args);
	}

	@Override
	public void run(KaldiConfiguration configuration, Environment environment) throws Exception {
		final DataSource dataSource = configuration.getDataSourceFactory().build(environment.metrics(), "sql");
		DBI dbi = new DBI(dataSource);

		// Application health check
		environment.healthChecks().register("health check", new KaldiDbHealthCheck(dbi.onDemand(FruitsService.class)));

		// Datasource
		environment.jersey().register(new FruitsResource(dbi.onDemand(FruitsService.class)));
	}

}
