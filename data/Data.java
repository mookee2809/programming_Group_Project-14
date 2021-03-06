/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

class Data implements Comparable<Data> {

    private String iso_code;
    private String continent;
    private String location;
    private String date;
    private String new_cases;
    private String new_deaths;
    private String people_vaccinated;
    private String population;


    
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

    Data() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
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

    
    public void inputData(String[] Data)
    {
        if(Data[0]=="")
            this.iso_code = "None";
        else
            this.iso_code = Data[0];

        if(Data[1]=="")
            this.continent = "None";
        else
            this.continent = Data[1];

        if(Data[2]=="")
            this.location = "None";
        else
            this.location = Data[2];
        if(Data[3]=="")
            this.date = "None";
        else
            this.date = Data[3];
        if(Data[4]=="")
            this.new_cases = "None";
        else
            this.new_cases = Data[4];
        if(Data[5]=="")
            this.new_deaths = "None";
        else
            this.new_deaths = Data[5];
        if(Data[6]=="")
            this.people_vaccinated = "None";
        else
            this.people_vaccinated = Data[6];
        if(Data[7]=="")
            this.population = "None";
        else
            this.population = Data[7];
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
