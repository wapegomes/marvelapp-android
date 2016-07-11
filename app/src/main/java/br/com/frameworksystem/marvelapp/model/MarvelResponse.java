package br.com.frameworksystem.marvelapp.model;

import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by wgomes on 11/07/16.
 */

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS)
public class MarvelResponse<T> {
    public int code;
    public String status;
    public T data;

    @Override
    public String toString() {
        return "MarvelResponse{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
