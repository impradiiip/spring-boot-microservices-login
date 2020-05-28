package com.tom.mobileapp.securityauthserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tom.mobileapp.securityauthserver.MyUserDetailsService;
import com.tom.mobileapp.securityauthserver.jwt.util.JwtUtil;
import com.tom.mobileapp.securityauthserver.model.AuthenticationRequest;
import com.tom.mobileapp.securityauthserver.model.AuthenticationResponse;

@RestController
public class SecurityController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@GetMapping("/hello")
	public String firstPage() {
		return "Hello World";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@PostMapping("/current")
	public ResponseEntity<UserDetails> getCurrent() throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String authenticatedUserName = authentication.getName();
		if (authenticatedUserName.equals("anonymousUser"))
			throw new Exception();
		else
			return new ResponseEntity<UserDetails>((UserDetails) authentication.getPrincipal(), null, HttpStatus.OK);
	}
	
}
