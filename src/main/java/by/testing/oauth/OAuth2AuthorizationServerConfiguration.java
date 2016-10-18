package by.testing.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 11.04.2016
 */
@SpringBootApplication
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfiguration extends
        AuthorizationServerConfigurerAdapter {

    private TokenStore tokenStore = new InMemoryTokenStore();

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        endpoints
                .tokenStore(this.tokenStore)
                .authenticationManager(this.authenticationManager)
                .tokenEnhancer(tokenEnhancer())
                .userDetailsService(userDetailsService)
                .pathMapping("/oauth/token", "/api/login");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        final Integer tokenExpireTime = 3600;
        clients
                .inMemory()
                .withClient("ta")
                .secret("ta")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(tokenExpireTime)
                .scopes("read", "write");
    }


    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }
}