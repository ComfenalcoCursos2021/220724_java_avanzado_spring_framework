package com.ecosistema.login.globalconfiguration;



import java.time.Duration;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class GlobalConfiguration {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer(){
		return factory -> factory.configureDefault(id -> 
		new Resilience4JConfigBuilder(id)
		.timeLimiterConfig(TimeLimiterConfig.custom()
				.timeoutDuration(Duration.ofSeconds(30)).build())
		.circuitBreakerConfig(
				CircuitBreakerConfig.custom()
					.slidingWindowSize(30)
					.slidingWindowType(CircuitBreakerConfig.SlidingWindowType.TIME_BASED)
					.minimumNumberOfCalls(5)
					.failureRateThreshold(25).build()
				).build());				
	}
}
