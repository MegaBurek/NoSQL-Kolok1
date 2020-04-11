package covid.services;

import javax.validation.Valid;

import covid.models.LoginAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import covid.models.AccountData;
import covid.payload.AuthResponse;
import covid.repositories.AccountDataRepository;
import covid.repositories.PermissionRepository;
import covid.utils.TokenProvider;

@Service
public class LoginService {

	@Autowired
	private AccountDataRepository accountRepository;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginAttempt loginAttempt) {
		 Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
							loginAttempt.getUsername(),
							loginAttempt.getPassword()
	                )
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String token = tokenProvider.createToken(authentication);
		return ResponseEntity.ok(new AuthResponse(token));
	}
}
