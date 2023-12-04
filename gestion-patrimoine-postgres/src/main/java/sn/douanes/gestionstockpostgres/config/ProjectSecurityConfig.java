package sn.douanes.gestionstockpostgres.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import sn.douanes.gestionstockpostgres.filter.CsrfCookieFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(List.of("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                })).csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/contact","/register")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((requests)->requests
//                                .requestMatchers("/accueil").hasRole("USER")
//                                .requestMatchers("/gestion-utilisateur/*").hasRole("USER")
//                                .requestMatchers("/gestion-vehicule").hasRole("USER")

//                                .requestMatchers("/Vehicules").hasRole("USER")
//                                .requestMatchers("/AjouterVehicule").hasRole("USER")
//                                .requestMatchers("/ModifierVehicule").hasRole("USER")
//                                .requestMatchers("/SupprimerVehicule/*").hasRole("USER")
//
//                                .requestMatchers("/ArticleBonEntrees").hasRole("USER")
//                                .requestMatchers("/AjouterArticleBonEntree").hasRole("USER")
//                                .requestMatchers("/ModifierArticleBonEntree").hasRole("USER")
//                                .requestMatchers("/SupprimerArticleBonEntree/*").hasRole("USER")
//
//                                .requestMatchers("/BonEntrees").hasRole("USER")
//                                .requestMatchers("/AjouterBonEntree").hasRole("USER")
//                                .requestMatchers("/ModifierBonEntree").hasRole("USER")
//                                .requestMatchers("/SupprimerBonEntree/*").hasRole("USER")
//
//                                .requestMatchers("/Sections").hasRole("USER")
//                                .requestMatchers("/AjouterSections").hasRole("USER")
//                                .requestMatchers("/ModifierSections").hasRole("USER")
//                                .requestMatchers("/SupprimerSections/*").hasRole("USER")
//
//
//                                .requestMatchers("/Agents").hasRole("USER")
//                                .requestMatchers("/AjouterAgent").hasRole("USER")
//                                .requestMatchers("/ModifierAgent").hasRole("USER")
//                                .requestMatchers("/SupprimerAgent/*").hasRole("USER")
//
//
//                                .requestMatchers("/BordereauLivraisons").hasRole("USER")
//                                .requestMatchers("/AjouterBordereauLivraison").hasRole("USER")
//                                .requestMatchers("/ModifierBordereauLivraison").hasRole("USER")
//                                .requestMatchers("/SupprimerBordereauLivraison/*").hasRole("USER")


                                .requestMatchers("/**").permitAll()

//                        .requestMatchers("/myAccount").hasRole("USER")
//                        .requestMatchers("/myBalance").hasAnyRole("USER","ADMIN")
//                        .requestMatchers("/myLoans").authenticated()
//                        .requestMatchers("/myCards").hasRole("USER")
//                        .requestMatchers("/user").authenticated()
//                        .requestMatchers("/notices","/contact","/register").permitAll()
                )
                .oauth2ResourceServer(oauth2ResourceServerCustomizer ->
                        oauth2ResourceServerCustomizer.jwt(jwtCustomizer -> jwtCustomizer.jwtAuthenticationConverter(jwtAuthenticationConverter)));
        return http.build();
    }


}