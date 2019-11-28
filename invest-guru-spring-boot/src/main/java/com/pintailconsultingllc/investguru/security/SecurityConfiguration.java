package com.pintailconsultingllc.investguru.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Value("${auth0.audience}")
//    private String audience;
//
//    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//    private String issuer;
//
//    @Bean
//    JwtDecoder jwtDecoder() {
//        final NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);
//        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
//        OAuth2TokenValidator<Jwt> issuerValidator = JwtValidators.createDefaultWithIssuer(issuer);
//        OAuth2TokenValidator<Jwt> delegatingOAuth2TokenValidator = new DelegatingOAuth2TokenValidator<>(issuerValidator,
//                audienceValidator);
//        jwtDecoder.setJwtValidator(delegatingOAuth2TokenValidator);
//        return jwtDecoder;
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .mvcMatchers("/graphql").authenticated()
//                .and()
//                .oauth2ResourceServer().jwt();
//    }
}