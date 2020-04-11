package covid.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import covid.models.AccountData;
import covid.services.AccountDataService;


@RestController
@RequestMapping("/account-data")
public class AccountDataController {

	@Autowired
	AccountDataService accountDataService;
	
    @RequestMapping(value="/all", method=RequestMethod.GET)
    public ResponseEntity<Iterable<AccountData>> getAccountData() {
        return new ResponseEntity<Iterable<AccountData>>(accountDataService.getAll(), HttpStatus.OK);
    }
	
 
	
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<AccountData> getAccountDataById(@PathVariable String id) {
        Optional<AccountData> accountData = accountDataService.getById(id);
        if(accountData.isPresent()) {
            return new ResponseEntity<AccountData>(accountData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<AccountData>(HttpStatus.NOT_FOUND);
    }
    
   
  

   
}


