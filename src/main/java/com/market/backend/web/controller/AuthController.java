package com.market.backend.web.controller;

import com.market.backend.domain.dto.AuthenticationRequest;
import com.market.backend.domain.dto.AuthenticationResponse;
import com.market.backend.domain.service.UserDetailsService;
import com.market.backend.web.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest authenticationRequest) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
          authenticationRequest.getUsername(),
          authenticationRequest.getPassword()
      ));

      UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
      String jwt = jwtUtil.genenrateToken(userDetails);

      return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);

    } catch (BadCredentialsException badCredentialsException) {
      LOGGER.warn(badCredentialsException.getMessage(), badCredentialsException);
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
  }
}
