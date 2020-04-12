package covid.services;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CovidAPI {

//    @Autowired
//    private CountryRepository countryRepository;


    public String getAllCountries() throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://coronavirus-monitor.p.rapidapi.com/coronavirus/cases_by_country.php")
                .get()
                .addHeader("x-rapidapi-host", "coronavirus-monitor.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "4555a47a82msh29e21085628ab97p166ae0jsn65ba7f99044b")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
