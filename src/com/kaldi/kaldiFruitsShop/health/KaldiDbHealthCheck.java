package com.kaldi.kaldiFruitsShop.health;

import com.codahale.metrics.health.HealthCheck;
import com.kaldi.kaldiFruitsShop.service.FruitsService;

public class KaldiDbHealthCheck extends HealthCheck {

	private final FruitsService fruitsService;

	public KaldiDbHealthCheck(final FruitsService fruitsService) {
		this.fruitsService = fruitsService;
	}

	@Override
	protected Result check() throws Exception {
		final String healthStatus = fruitsService.HealthCheck();
		if (healthStatus == null) {
			return Result.healthy("Service is healthy");
		} else {
			return Result.unhealthy(String.format("Service is not healthy %s", healthStatus));
		}
	}

}
