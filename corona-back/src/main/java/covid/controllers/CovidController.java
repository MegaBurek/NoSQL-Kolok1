package covid.controllers;

import covid.models.Country;
import covid.services.CovidAPI;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/covid")
public class CovidController {

    @Autowired
    CovidAPI covidAPI;

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Country>> getAllCountries() throws IOException, JSONException {
        return new ResponseEntity<>(covidAPI.getAllCountries(), HttpStatus.OK);
    }

}
