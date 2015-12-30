package json.jsonparsing.parser;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import json.jsonparsing.model.Place;

/**
 * Created by vijay on 12/29/15.
 */
public class GSONJSONParser extends JSONParser {

    private Context context;

    public GSONJSONParser(Context c) {
        super(c);
        this.context = c;
    }

    @Override
    protected void parse() {
        Log.d("test", "gson parse");
        try {
            long startTime = System.nanoTime();
            Place[] response = new Gson().fromJson(getReader("sample1.json"), Place[].class);
            Log.d("test", "GS time taken: " + (System.nanoTime() - startTime));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
