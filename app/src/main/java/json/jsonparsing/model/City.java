package json.jsonparsing.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by vijay on 12/30/15.
 */
@JsonObject
public class City {
    @JsonField
    public String name;

    @JsonField
    public String zip;
}
