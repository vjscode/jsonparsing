package json.jsonparsing.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by vijay on 12/29/15.
 */
@JsonObject
public class Place {
    @JsonField
    public List<Address> addresses;

    @JsonField
    public City city;
}
