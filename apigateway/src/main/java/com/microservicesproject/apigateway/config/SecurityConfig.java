
@Configuration
@EnableWebfluxSecurity
public class SecurityConfig {
    
   @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
          http.csrf().disable()
                .authorizeExchange(exchanges -> exchanges
                 .pathMatchers("/eureka/**").permitAll()
                 .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt());
          return http.build();
     }


}
