package covid.controllers;

import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import covid.services.CovidAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public String getAllCountries() throws IOException {
        return new String(covidAPI.getAllCountries());
    }

}
