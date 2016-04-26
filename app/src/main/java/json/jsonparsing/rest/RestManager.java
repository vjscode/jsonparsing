package json.jsonparsing.rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import json.jsonparsing.model.Country;
import json.jsonparsing.model.Photo;
import json.jsonparsing.parser.CountryTypeAdapter;
import json.jsonparsing.parser.PhotoTypeAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by vijay on 4/23/16.
 */
public class RestManager {

    private static String BASE_COUNTRIES_URL = "https://restcountries.eu/rest/v1/";
    private static String BASE_PHOTOS_URL = "http://jsonplaceholder.typicode.com/";

    public interface GetAllAPI {
        @GET("all")
        Observable<List<Country>> getCountries();

        @GET("photos")
        Observable<List<Photo>> getPhotos();
    }

    public static Observable<List<Country>> getCountriesInfo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_COUNTRIES_URL)
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
                .baseUrl(BASE_COUNTRIES_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GetAllAPI service = retrofit.create(GetAllAPI.class);
        Observable<List<Country>> countries = service.getCountries();
        return countries;
    }

    public static Observable<List<Photo>> getPhotos() {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_PHOTOS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GetAllAPI service = retrofit.create(GetAllAPI.class);
        Observable<List<Photo>> photos = service.getPhotos();
        return photos;
    }

    public static Observable<List<Photo>> getPhotosWithCustomTypeAdapters() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Photo.class, new PhotoTypeAdapter())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_PHOTOS_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GetAllAPI service = retrofit.create(GetAllAPI.class);
        Observable<List<Photo>> photos = service.getPhotos();
        return photos;
    }
}