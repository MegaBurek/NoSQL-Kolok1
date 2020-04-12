package covid.models;

public class Country {

    private String country_name;
    private String cases;
    private String deaths;
    private String region;
    private String total_recovered;
    private String new_deaths;
    private String new_cases;
    private String serious_critical;
    private String active_cases;
    private String total_cases_per_1m_population;

    public Country() {
    }

    public Country(String country_name, String cases, String deaths, String region, String total_recovered, String new_deaths, String new_cases, String serious_critical, String active_cases, String total_cases_per_1m_population) {
        this.country_name = country_name;
        this.cases = cases;
        this.deaths = deaths;
        this.region = region;
        this.total_recovered = total_recovered;
        this.new_deaths = new_deaths;
        this.new_cases = new_cases;
        this.serious_critical = serious_critical;
        this.active_cases = active_cases;
        this.total_cases_per_1m_population = total_cases_per_1m_population;
    }

    public Country(String country_name, String cases, String deaths, String total_recovered) {
        this.country_name = country_name;
        this.cases = cases;
        this.deaths = deaths;
        this.total_recovered = total_recovered;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTotal_recovered() {
        return total_recovered;
    }

    public void setTotal_recovered(String total_recovered) {
        this.total_recovered = total_recovered;
    }

    public String getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(String new_deaths) {
        this.new_deaths = new_deaths;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    public String getSerious_critical() {
        return serious_critical;
    }

    public void setSerious_critical(String serious_critical) {
        this.serious_critical = serious_critical;
    }

    public String getActive_cases() {
        return active_cases;
    }

    public void setActive_cases(String active_cases) {
        this.active_cases = active_cases;
    }

    public String getTotal_cases_per_1m_population() {
        return total_cases_per_1m_population;
    }

    public void setTotal_cases_per_1m_population(String total_cases_per_1m_population) {
        this.total_cases_per_1m_population = total_cases_per_1m_population;
    }
}
