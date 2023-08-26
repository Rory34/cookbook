package com.rorysteerprojects.cookbook.security.jwt;

import com.rorysteerprojects.cookbook.cookbook_api.UserDTO;
import com.rorysteerprojects.cookbook.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationResource {


    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService userDetailsService;

    public JwtAuthenticationResource(JwtTokenService jwtTokenService,
                                     AuthenticationManager authenticationManager,
                                     JwtUserDetailsService userDetailsService) {
        this.jwtTokenService = jwtTokenService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userDetailsService.save(user));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> authenticate(@RequestBody JwtTokenRequest jwtTokenRequest) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(jwtTokenRequest.username(),
                jwtTokenRequest.password());

        var authentication = authenticationManager.authenticate(authenticationToken);
        return ResponseEntity.ok(new JwtTokenResponse(jwtTokenService.generateToken(authentication)));
    }
}