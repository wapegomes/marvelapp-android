package br.com.frameworksystem.marvelapp.model;


import java.util.List;

public class Character {

    public String id;
    public String name;
    public String description;
    public String modified;
    public String resourceUri;
    public List<MarvelUrl> urls;
    public MarvelImage thumbnail;
//    public MarvelResources<ComicResourceDto> comics;
//    public MarvelResources<StoryResourceDto> stories;
//    public MarvelResources<EventResourceDto> events;
//    public MarvelResources<SerieResourceDto> series;


    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", modified='" + modified + '\'' +
                ", resourceUri='" + resourceUri + '\'' +
                ", urls=" + urls +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
