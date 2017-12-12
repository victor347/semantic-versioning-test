package com.banistmo.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author anders.barrios
 *
 */
public class AdminChannelRestClient {

	private static RestTemplate restTemplate  = new RestTemplate();
	private static Logger logger = LoggerFactory.getLogger(AdminChannelRestClient.class);
	private static AdminChannelRestClient instance;

	private AdminChannelRestClient() {

	}

	public static AdminChannelRestClient getInstance() {
		if (null == instance) {
			instance = new AdminChannelRestClient();
		}
		return instance;
	}

	public <T> T request(String url, Object request, Class<T> responseType) {
		try {
			return restTemplate.postForObject(url, request, responseType);
		} catch (RestClientException e) {
			logger.error("Error posting to url " + url, e);
			return null;
		}
	}
}
