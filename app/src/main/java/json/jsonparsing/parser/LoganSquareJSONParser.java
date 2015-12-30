package json.jsonparsing.parser;

import android.content.Context;
import android.util.Log;

import com.bluelinelabs.logansquare.LoganSquare;

import json.jsonparsing.model.Place;

/**
 * Created by vijay on 12/29/15.
 */
public class LoganSquareJSONParser extends JSONParser {

    private Context context;

    public LoganSquareJSONParser(Context c) {
        super(c);
        this.context = c;
    }

    @Override
    protected void parse() {
        try {
            long startTime = System.nanoTime();
            String strJSON = readFile("sample1.json");
            Place response = LoganSquare.parse(strJSON, Place.class);
            Log.d("test", "LS time taken: " + (System.nanoTime() - startTime));
        } catch (Exception e) {
            return;
        }
    }
}
