package json.jsonparsing.parser;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import json.jsonparsing.model.Country;

/**
 * Created by vijay on 4/24/16.
 */
public class CountryTypeAdapter extends TypeAdapter {

    @Override
    public void write(JsonWriter out, Object value) throws IOException {
        Country country = (Country)value;
        out.beginObject();
        out.name("name").value(country.getName());
        out.name("capital").value(country.getCapital());
        out.name("population").value(country.getPopulation());
        out.name("region").value(country.getRegion());
        out.name("subregion").value(country.getSubRegion());
        out.name("demonym").value(country.getDemonym());
        out.name("timezones").value(flattenList(country.getTimeZones()));
        out.name("borders").value(flattenList(country.getBorders()));
        out.endObject();
    }

    private String flattenList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + ";");
        }
        return sb.toString();
    }

    @Override
    public Country read(final JsonReader in) throws IOException {
        final Country country = new Country();

        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "name":
                    country.setName(in.nextString());
                    break;
                case "capital":
                    country.setCapital(in.nextString());
                    break;
                case "population":
                    country.setPopulation(in.nextInt());
                    break;
                case "region":
                    country.setRegion(in.nextString());
                    break;
                case "subregion":
                    country.setSubRegion(in.nextString());
                    break;
                case "demonym":
                    country.setDemonym(in.nextString());
                    break;
                case "timezones":
                    country.setTimeZones(unflatten(in.nextString()));
                    break;
                case "borders":
                    country.setBorders(unflatten(in.nextString()));
                    break;
            }
        }
        in.endObject();
        return country;
    }

    private List<String> unflatten(String s) {
        if (s != null) {
            List<String> list = new ArrayList<>();
            String[] strings = s.split(";");
            return Arrays.asList(strings);
        }
        return null;
    }
}
