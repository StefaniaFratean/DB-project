package db.Gameez.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

import java.time.Duration;

@Configuration
@EnableAsync
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.DEFAULT_FILTER_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DatabaseAuthenticationProvider authenticationProvider;

    @Bean
    public RoleVoter roleVoter() {
        RoleVoter roleVoter = new RoleVoter();
        roleVoter.setRolePrefix("");
        return roleVoter;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/static/**", "/css/**", "/img/**", "/templates/public/**");
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new UrlAuthenticationSuccessHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login**", "/favicon.**", "/403",
                        "/js/**", "/static/**", "/css/**", "/img/**", "/templates/public/**"
                ).permitAll()
                .antMatchers("/**").authenticated()
                .and().formLogin().loginPage("/login").successHandler(authenticationSuccessHandler())
                .and().logout()
                    .addLogoutHandler(new HeaderWriterLogoutHandler(
                            new ClearSiteDataHeaderWriter(
                                    ClearSiteDataHeaderWriter.Directive.CACHE,
                                    ClearSiteDataHeaderWriter.Directive.COOKIES,
                                    ClearSiteDataHeaderWriter.Directive.STORAGE)))
                    .logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/403")
                .and().csrf().disable()
                .authenticationProvider(authenticationProvider)
                .headers(headers ->
                        headers.httpStrictTransportSecurity(hstsConfig ->
                                hstsConfig
                                        .includeSubDomains(true)
                                        .preload(true)
                                        .maxAgeInSeconds(Duration.ofDays(365).toSeconds())));
    }
}
