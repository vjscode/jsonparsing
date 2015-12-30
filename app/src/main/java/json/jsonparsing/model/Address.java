package json.jsonparsing.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by vijay on 12/30/15.
 */
@JsonObject
public class Address {
    @JsonField
    public String location;

    @JsonField
    public String address;

    @JsonField
    public String city;
}
