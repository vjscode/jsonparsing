package json.jsonparsing.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vijay on 4/23/16.
 */
public class Country {
    @SerializedName("name")
    String name;

    @SerializedName("capital")
    String capital;

    @SerializedName("population")
    int population;

    @SerializedName("demonym")
    String demonym;

    @SerializedName("timezones")
    List<String> timeZones;

    @SerializedName("borders")
    List<String> borders;

    @SerializedName("region")
    String region;

    @SerializedName("subregion")
    String subRegion;

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public String getDemonym() {
        return demonym;
    }

    public List<String> getTimeZones() {
        return timeZones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public String getRegion() {
        return region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public void setTimeZones(List<String> timeZones) {
        this.timeZones = timeZones;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }
}
