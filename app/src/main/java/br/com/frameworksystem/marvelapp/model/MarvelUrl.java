package br.com.frameworksystem.marvelapp.model;

import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by felip on 6/14/2016.
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS)
public class MarvelUrl {

    public String type;
    public String url;

    @Override
    public String toString() {
        return "MarvelUrl{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
