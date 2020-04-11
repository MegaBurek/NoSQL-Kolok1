package covid.controllers;

import covid.models.User;
import covid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAll() {
        return new ResponseEntity<Iterable<User>>(userService.getAll(), HttpStatus.OK);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable String id) {
        Optional<User> user = userService.getById(id);
        if(user.isPresent()) {
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> editUser(@PathVariable String id, @RequestBody User user){
        userService.editUser(id, user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<User> removeUser(@PathVariable String id) {
        try {
            userService.deleteUser(id);
        }catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
