package json.jsonparsing.rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import json.jsonparsing.model.Country;
import json.jsonparsing.parser.CountryTypeAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by vijay on 4/23/16.
 */
public class RestManager {

    private static String BASE_URL = "https://restcountries.eu/rest/v1/";

    public interface GetAllAPI {
        @GET("all")
        Observable<List<Country>> getCountries();
    }

    public static Observable<List<Country>> getCountriesInfo() {

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GetAllAPI service = retrofit.create(GetAllAPI.class);

        Observable<List<Country>> countries = service.getCountries();
        return countries;
    }

    public static Observable<List<Country>> getCountriesInfoWithCustomTypeAdapters() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Country.class, new CountryTypeAdapter())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GetAllAPI service = retrofit.create(GetAllAPI.class);

        Observable<List<Country>> countries = service.getCountries();
        return countries;
    }
}