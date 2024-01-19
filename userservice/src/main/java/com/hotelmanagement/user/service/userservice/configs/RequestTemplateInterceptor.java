package com.hotelmanagement.user.service.userservice.configs;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;


public class RequestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private OAuth2AuthorizedClientManager manager;

    private Logger logger= LoggerFactory.getLogger(RequestTemplateInterceptor.class);

    public RequestTemplateInterceptor(OAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        System.out.println("IN the interceptor");
        System.out.println("Manager : ---->"+manager);
        String token = manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build()).getAccessToken().getTokenValue();
        logger.info("Rest Template interceptor: Token :  {} ",token);

        request.getHeaders().add("Authorization","Bearer "+token);
        return execution.execute(request,body);
    }
    
}
