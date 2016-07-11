package br.com.frameworksystem.marvelapp.model;

import com.bluelinelabs.logansquare.annotation.JsonObject;

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
