package json.jsonparsing.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import json.jsonparsing.R;
import json.jsonparsing.model.Photo;
import json.jsonparsing.parser.GSONJSONParser;
import json.jsonparsing.parser.LoganSquareJSONParser;
import json.jsonparsing.rest.RestManager;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeRestCall();
            }
        });
        new LoganSquareJSONParser(this).execute();
        new GSONJSONParser(this).execute();
    }

    private void makeRestCall() {
        Log.d("test", "makeRestCall");
        final long startTime = SystemClock.elapsedRealtimeNanos();

        //Use GSON with default type adapter which uses reflection
        RestManager.getPhotos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<List<Photo>>() {
                               @Override
                               public void onCompleted() {
                                   Log.d("test", "completed reflection: " + (SystemClock.elapsedRealtimeNanos() - startTime));
                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onNext(List<Photo> countries) {
                               }
                           }
                );

        //Use GSON with custom type adapter without reflection
        final long startTimeNoRefl = SystemClock.elapsedRealtimeNanos();
        RestManager.getPhotosWithCustomTypeAdapters()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<List<Photo>>() {
                               @Override
                               public void onCompleted() {
                                   Log.d("test", "completed no reflection: " + (SystemClock.elapsedRealtimeNanos() - startTimeNoRefl));
                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onNext(List<Photo> countries) {
                               }
                           }
                );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
