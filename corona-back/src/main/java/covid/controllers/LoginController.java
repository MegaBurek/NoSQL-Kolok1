package covid.controllers;

import covid.models.LoginAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import covid.models.AccountData;
import covid.services.LoginService;


@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginAttempt loginAttempt) {
		return loginService.authenticateUser(loginAttempt);
	}
}