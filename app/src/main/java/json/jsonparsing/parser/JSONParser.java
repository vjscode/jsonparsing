package json.jsonparsing.parser;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by vijay on 12/29/15.
 */
public class JSONParser extends AsyncTask<Void, Void, Void> {

    private Context context;
    public JSONParser(){}
    public JSONParser(Context c) {
        this.context = c;
    }
    protected void parse() {
    }

    @Override
    protected Void doInBackground(Void... voids) {
        parse();
        return null;
    }

    protected String readFile(String filename) {
        StringBuilder sb = new StringBuilder();

        try {
            InputStream json = context.getAssets().open(filename);
            BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
            in.close();
        } catch (Exception e) {

        }
        return sb.toString();
    }

    protected BufferedReader getReader(String filename) {
        try {
            InputStream json = context.getAssets().open(filename);
            BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            return in;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
