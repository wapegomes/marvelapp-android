package br.com.frameworksystem.marvelapp.model;

/**
 * Created by wgomes on 11/07/16.
 */




import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;


@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS)
public class CharactersDto extends MarvelCollection<Character>{

    public List<Character> getCharacters() {
        return results;
    }

    @Override
    public String toString() {
        return results.toString();
    }
}

