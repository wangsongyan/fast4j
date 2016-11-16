package cn.wangsy.fast4j.web.config;
import org.scribe.builder.ServiceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.wangsy.fast4j.core.oauth2.api.GithubApi;
import cn.wangsy.fast4j.core.oauth2.config.OAuthTypes;
import cn.wangsy.fast4j.web.service.oauth.GithubOAuthService;
import cn.wangsy.fast4j.web.service.oauth.OAuthServiceDeractor;

@Configuration
public class OAuthConfig {
    
    private static final String CALLBACK_URL = "%s/oauth/%s/callback";
    
    @Value("${oAuth.github.state}") String state;
    @Value("${oAuth.github.clientId}") String githubClientId;
    @Value("${oAuth.github.clientSecret}") String githubClientSecret;
    @Value("${demo.host}") String host;
    
    @Bean
    public GithubApi githubApi(){
        return new GithubApi(state);
    }
    
    @Bean
    public OAuthServiceDeractor getGithubOAuthService(){
        return new GithubOAuthService(new ServiceBuilder()
            .provider(githubApi())
            .apiKey(githubClientId)
            .apiSecret(githubClientSecret)
            .callback(String.format(CALLBACK_URL, host, OAuthTypes.GITHUB))
            .build());
    }
    

}