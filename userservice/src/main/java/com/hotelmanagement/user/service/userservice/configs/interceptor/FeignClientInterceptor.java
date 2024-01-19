package com.hotelmanagement.user.service.userservice.configs.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
@Component
@Configuration
public class FeignClientInterceptor implements RequestInterceptor {
    @Autowired
    private  OAuth2AuthorizedClientManager authorizedClientManager;
    @Override
    public void apply(RequestTemplate template) {
        System.out.println("hteloo");
        String token = this.authorizedClientManager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build()).getAccessToken().getTokenValue();
        template.header("Authorization", "Bearer " + token);
    }
    
}
