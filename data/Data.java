/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

public class Data implements Comparable<Data> {

    private String iso_code;
    private String continent;
    private String location;
    private String date;
    private String new_cases;
    private String new_deaths;
    private String people_vaccinated;
    private String population;

    @Override
    public String toString() {
        return "CovidData{" + "iso_code=" + iso_code + ", continent=" + continent + ", location=" + location + ", date=" + date + ", new_cases=" + new_cases + ", new_deaths=" + new_deaths + ", people_vaccinated=" + people_vaccinated + ", population=" + population + '}';
    }
    
    public void showProfile(){
        System.out.printf("%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s"
       ,iso_code ,continent, location, date, new_cases, new_deaths, people_vaccinated, population);
    }

    @Override
    public int compareTo(Data o) {
        int nc = Integer.parseInt(new_cases);
        int nc1 = Integer.parseInt(o.new_cases);
        int caseDiff;
        caseDiff = nc - nc1;
        if (caseDiff == 0 ){
            return date.compareTo(o.getDate());
        }
        return caseDiff;
    }

    public Data(String iso_code, String continent, String location, String date, String new_cases, String new_deaths, String people_vaccinated, String population) {
        this.iso_code = iso_code;
        this.continent = continent;
        this.location = location;
        this.date = date;
        this.new_cases = new_cases;
        this.new_deaths = new_deaths;
        this.people_vaccinated = people_vaccinated;
        this.population = population;
    }

    public String getIso_code() {
        return iso_code;
    }

    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    public String getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(String new_deaths) {
        this.new_deaths = new_deaths;
    }

    public String getPeople_vaccinated() {
        return people_vaccinated;
    }

    public void setPeople_vaccinated(String people_vaccinated) {
        this.people_vaccinated = people_vaccinated;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    

    

    

}
