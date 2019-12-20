package kz.attractor.lab56.taskmanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
// основная настройка выполняется в этом классе

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.httpBasic();

        http.formLogin()
                .disable()
                .logout()
                .disable();

        http.csrf()
                .disable();

// Правило 1: Всё, что начинается с /subscriptions
// должно быть доступно только
// после авторизации пользователя
        http.authorizeRequests()
                .antMatchers("/users/**")
                .fullyAuthenticated()
                .antMatchers("/tasks/**")
                .fullyAuthenticated();

// Правило 2: Разрешить всё остальные запросы
        http.authorizeRequests()
                .anyRequest()
                .permitAll();
    }

}