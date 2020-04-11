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

import covid.models.Administrator;
import covid.services.AdministratorService;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Administrator>> getAll() {
        return new ResponseEntity<Iterable<Administrator>>(administratorService.getAll(), HttpStatus.OK);
    }
	

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Administrator> getById(@PathVariable String id) {
        Optional<Administrator> administrator = administratorService.getById(id);
        if(administrator.isPresent()) {
            return new ResponseEntity<Administrator>(administrator.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
    }
	
    @RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Administrator> addAdministrator(@RequestBody Administrator administrator){
    	administratorService.addAdministrator(administrator);
		return new ResponseEntity<Administrator>(administrator, HttpStatus.CREATED);
	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   	public ResponseEntity<Administrator> editAdministrator(@PathVariable String id, @RequestBody Administrator administrator){
   		administratorService.editAdministrator(id, administrator);
   		return new ResponseEntity<Administrator>(administrator, HttpStatus.OK);
   	}
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Administrator> removeAdministrator(@PathVariable String id) {
        try {
        	administratorService.deleteAdministrator(id);
        }catch (Exception e) {
            return new ResponseEntity<Administrator>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Administrator>(HttpStatus.NO_CONTENT);
    }

}
