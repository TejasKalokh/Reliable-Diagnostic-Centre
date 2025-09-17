//package org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.Config;
//
//import org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.LoginSignup.UserdDtailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configurable
//@EnableWebSecurity
//public class SpringSeurity {
//
//    @Autowired
//    private UserdDtailService UserdetailService;
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.csrf(custmizer -> custmizer.disable());
//        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated());
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
//
//   @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        authProvider.setUserDetailsService(UserdetailService);
//        return authProvider;
//   }
//}
