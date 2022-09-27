package com.example.prestamos.security;


import com.example.prestamos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()

            .authorizeHttpRequests((requests) -> requests
                    //configuracion de rutas que permiten visualizar sin autenticacion
                    .antMatchers("/","/home","**/*.js", "/**/*.css", "/login/registro","/login/postregistro").permitAll()
                    //Todas la demas deben estar autenticadas
                    .anyRequest().authenticated()
            ).oauth2Login().defaultSuccessUrl("/inicio",true)
            .and()
            //aqui especificamos la pagina de login
            .formLogin((form) -> form
                    .loginPage("/login/login")
                    //indica a donde dirigirce despues del login exitoso
                    .permitAll().defaultSuccessUrl("/inicio",true)
            )
             //configuracion loggout
            .logout((logout) -> logout.permitAll());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.example.prestamos.entities.User userObject = this.userService.selectByUserName(username);
        System.out.println(username);
        if (userObject != null){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            return new User(
                    userObject.getCorreo(),
                    userObject.getPassword(),
                    authorities
            );
        }
        throw new UsernameNotFoundException(
                "User" + username + "not found.");
    }
    /*@Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }*/
}
