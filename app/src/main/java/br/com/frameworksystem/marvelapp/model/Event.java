package br.com.frameworksystem.marvelapp.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wgomes on 17/06/16.
 */

public class Event implements Serializable{

    public String id;
    public String title;
    public String description;
    public String resourceUri;
    public List<MarvelUrl> urls;
    public MarvelImage thumbnail;



}
