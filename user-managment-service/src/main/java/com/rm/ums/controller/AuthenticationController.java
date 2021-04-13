package com.rm.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rm.ums.config.JWTTokenUtil;
import com.rm.ums.model.JWTRequest;
import com.rm.ums.model.JWTResponse;
import com.rm.ums.utils.EncryptionUtils;


@RestController
@RequestMapping("/api/auth/")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

    @PostMapping("/authenticate")
	public ResponseEntity<JWTResponse> createAuthenticationToken(@RequestBody JWTRequest authenticationRequest)
			throws BadCredentialsException {

		authenticate(authenticationRequest);

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JWTResponse(token));
	}

	private void authenticate(JWTRequest authenticationRequest) throws ResponseStatusException {
		
		boolean isValidRequest = true;
		
		if (StringUtils.isEmpty(authenticationRequest.getUsername()) || StringUtils.isEmpty(authenticationRequest.getPassword())) {
			isValidRequest = false;
		}
		
		if (!isValidRequest && !StringUtils.isEmpty(authenticationRequest.getAccesskey())) {
			String credentails = EncryptionUtils.decrypt(authenticationRequest.getAccesskey());
			String[] creds = credentails.split("==");
			if (creds.length == 2) {
				authenticationRequest.setUsername(creds[0]);
				authenticationRequest.setPassword(creds[1]);
				isValidRequest = true;
			}else {
				isValidRequest = false;				
			}
		}
		
		if (!isValidRequest) {
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, "INVALID_CREDENTIALS");
		}
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, "USER_DISABLED",e);
		} catch (BadCredentialsException e) {
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, "INVALID_CREDENTIALS",e);
		} catch (LockedException e) {
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, "USER_LOCKED",e);
		}
	}
}
