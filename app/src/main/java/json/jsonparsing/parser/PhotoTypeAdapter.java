package json.jsonparsing.parser;

import android.util.Log;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import json.jsonparsing.model.Photo;

/**
 * Created by vijay on 4/24/16.
 */
public class PhotoTypeAdapter extends TypeAdapter {

    @Override
    public void write(JsonWriter out, Object value) throws IOException {
        Photo photo = (Photo)value;
        out.beginObject();
        out.name("albumId").value(photo.getAlbumId());
        out.name("id").value(photo.getId());
        out.name("thumbnailUrl").value(photo.getThumbnailUrl());
        out.name("title").value(photo.getTitle());
        out.name("url").value(photo.getUrl());
        out.endObject();
        Log.d("test", "country: " + photo);
    }

    @Override
    public Photo read(final JsonReader in) throws IOException {
        final Photo photo = new Photo();

        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "albumId":
                    photo.setAlbumId(in.nextInt());
                    break;
                case "id":
                    photo.setId(in.nextInt());
                    break;
                case "thumbnailUrl":
                    photo.setThumbnailUrl(in.nextString());
                    break;
                case "title":
                    photo.setTitle(in.nextString());
                    break;
                case "url":
                    photo.setUrl(in.nextString());
                    break;
            }
        }
        in.endObject();
        return photo;
    }
}
