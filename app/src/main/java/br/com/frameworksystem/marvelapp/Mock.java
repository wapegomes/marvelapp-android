package br.com.frameworksystem.marvelapp;

import java.util.ArrayList;
import java.util.List;

import br.com.frameworksystem.marvelapp.model.Character;
import br.com.frameworksystem.marvelapp.model.Comic;
import br.com.frameworksystem.marvelapp.model.Event;

/**
 * Created by wgomes on 16/06/16.
 */

public class Mock {

    public static List<Character> getCharacters() {

        List<Character> characterList = new ArrayList<>();

        Character character = new Character();
        character.setName("Spider-Man");
        character.setDescription("Bitten by a radioactive spider, high school student Peter " +
                "Parker gained the speed, strength and powers of a spider. Adopting the name Spider-Man, " +
                "Peter hoped to start a career using his new abilities. Taught that with great power comes " +
                "great responsibility, Spidey has vowed to use his powers to help people.");
        character.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b.jpg");


        Character character2 = new Character();
        character2.setName("Iron Man");
        character2.setDescription("Wounded, captured and forced to build a weapon by his enemies, " +
                "billionaire industrialist Tony Stark instead created an advanced suit of armor to save " +
                "his life and escape captivity. Now with a new outlook on life, Tony uses his money and " +
                "intelligence to make the world a safer, better place as Iron Man.");
        character2.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/9/c0/527bb7b37ff55.jpg");


        Character character3 = new Character();
        character3.setName("Captain America");
        character3.setDescription("Vowing to serve his country any way he could, young Steve Rogers " +
                "took the super soldier serum to become America's one-man army. Fighting for the red, " +
                "white and blue for over 60 years, Captain America is the living, breathing symbol of " +
                "freedom and liberty.");
        character3.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/3/50/537ba56d31087.jpg");

        characterList.add(character);
        characterList.add(character2);
        characterList.add(character3);

        return characterList;


    }


    public static List<Event> getEvents() {

        List<Event> eventsList = new ArrayList<>();

        Event event = new Event();
        event.setTitle("Spider-Island");
        event.setDescription("This summer, heroes, villains and ordinary people across Manhattan gain " +
                "spider abilities, but not all realize that with great power comes great responsibility! " +
                "Can Spider-Man keep the peace? Dan Slott spearheads this arachna-tastic event in the pages " +
                "of Amazing Spider-Man!");
        event.setUrl("http://marvel.com/comics/events/305/spider-island?utm_campaign=apiRef&utm_source=277232a94db26746c653c879d30cec89");
        event.setImgUrl("http://i.annihil.us/u/prod/marvel/i/mg/3/70/51e827657c1d0.jpg");

        Event event2 = new Event();
        event2.setTitle("Age of Apocalypse");
        event2.setDescription("In a twisted version of the world they knew, the X-Men battle against the eternal mutant " +
                "pocalypse as Bishop seeks to repair the timeline. Legion, Xavier's own son, attempts to " +
                "kill off all of Xavier's enemies; however, when Legion attempts to murder Magneto, Xavier " +
                "sacrifices his own life to save Magnus. As a result, Magneto casts off his anti-human sentiments " +
                "and carries on Xavier's dream of peaceful co-existence, thereby founding the X-Men.");
        event2.setUrl("http://marvel.com/comics/events/227/age_of_apocalypse?utm_campaign=apiRef&utm_source=277232a94db26746c653c879d30cec89");
        event2.setImgUrl("http://i.annihil.us/u/prod/marvel/i/mg/5/e0/51ca0e08a6546.jpg");

        Event event3 = new Event();
        event3.setTitle("Secret Wars");
        event3.setDescription("The most powerful heroes and villains in the Marvel Universe square off " +
                "on Battleword with the victor promised their greatest dreams and desires! Writer Jim Shooter " +
                "and artists Mike Zeck and Bob Layton introduce the Beyonder in a 12-issue event featuring " +
                "the Avengers, the X-Men, the Fantastic Four, Spider-Man, Magneto, Doctor Doom and more!");
        event3.setUrl("http://marvel.com/comics/events/270/secret_wars?utm_campaign=apiRef&utm_source=277232a94db26746c653c879d30cec89");
        event3.setImgUrl("http://i.annihil.us/u/prod/marvel/i/mg/f/00/51cdeb7048dac.jpg");

        eventsList.add(event);
        eventsList.add(event2);
        eventsList.add(event3);


        return eventsList;

    }


    public static List<Comic> getCommics(String characterName) {

        List<Comic> comicList = new ArrayList<>();

        if (characterName.equals("Spider-Man")) {

            Comic comic = new Comic();
            comic.setTitle("Amazing Spider-Man (2015) #15");
            comic.setDescription("“Power Play” comes to its rousing conclusion! Regent’s master plan is working until Mary Jane Watson gets into the fray!");
            List<String> languageList = new ArrayList<>();
            languageList.add("en-us");
            comic.setLanguages(languageList);
            comic.setPrice("3.99");
            comic.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/5/e0/576d530f0c30c.jpg");

            Comic comic2 = new Comic();
            comic2.setTitle("Spider-Man/Deadpool (2016) #6");
            comic2.setDescription("Deadpool goes Hollywood! See the M w/the M on the set of his own MOVIE! And he brings his pal Spidey along, as he has lots of experience selling out! All-Star Special Issue—written by Scott Aukerman of TV’s Comedy Bang Bang!");
            List<String> languageList2 = new ArrayList<>();
            languageList2.add("en-us");
            languageList2.add("pt_br");
            comic2.setLanguages(languageList);
            comic2.setPrice("3.99");
            comic2.setDetailUrl("http://marvel.com/comics/issue/52564/spider-mandeadpool_2016_6?utm_campaign=apiRef&utm_source=277232a94db26746c653c879d30cec89");
            comic2.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/6/40/576d3ce92b113.jpg");

            comicList.add(comic);
            comicList.add(comic2);

        } else if (characterName.equals("Iron Man")) {

            Comic comic = new Comic();
            comic.setTitle("All-New, All-Different Avengers (2015) #11");
            comic.setDescription("The Avengers--captives on the Stalag of Space! " +
                    "Its mysterious alien warden cannot be beaten by conventional means, but the Avengers’ " +
                    "prison break will take them into an even more dangerous realm!");
            List<String> languageList = new ArrayList<>();
            languageList.add("en-us");
            comic.setLanguages(languageList);
            comic.setPrice("3.99");
            comic.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/c/90/576d4bccd73b6.jpg");
            comic.setDetailUrl("http://marvel.com/comics/issue/55364/all-new_all-different_avengers_2015_11?utm_campaign=apiRef&utm_source=277232a94db26746c653c879d30cec89");

            Comic comic2 = new Comic();
            comic2.setTitle("Iron Man (2012) #10");
            comic2.setDescription("Death Head and Iron Man team-up to hunt down a genocidal criminal. " +
                    "Not the problem. A shipful of dead badoon. Not the problem. What Tony finds in " +
                    "the depths of that ship: the problem. Big problem. The lead into the biggest " +
                    "Tony Stark story of the year.");
            List<String> languageList2 = new ArrayList<>();
            languageList2.add("en-us");
            comic2.setLanguages(languageList);
            comic2.setPrice("1.99");
            comic2.setDetailUrl("http://marvel.com/comics/issue/46209/iron_man_2012_10?utm_campaign=apiRef&utm_source=277232a94db26746c653c879d30cec89");
            comic2.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/7/20/5182d6cde6399.jpg");

            comicList.add(comic);
            comicList.add(comic2);

        } else if (characterName.equals("Captain America")) {

            Comic comic = new Comic();
            comic.setTitle("Captain America: Steve Rogers (2016) #2");
            comic.setDescription("As Steve battles a resurgent Hydra more dangerous than ever before, " +
                    "he must confront a ghost from his past!");
            List<String> languageList = new ArrayList<>();
            languageList.add("en-us");
            comic.setLanguages(languageList);
            comic.setPrice("3.99");
            comic.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/4/c0/5769689a8d4d4.jpg");
            comic.setDetailUrl("http://marvel.com/comics/issue/57866/captain_america_steve_rogers_2016_2?utm_campaign=apiRef&utm_source=277232a94db26746c653c879d30cec89");

            Comic comic2 = new Comic();
            comic2.setTitle("Captain America (2011) #18");
            comic2.setDescription("The Omega Madbombs have been unleashed, " +
                    "and no one is safe! Agent 13 and Dum Dum Dugan duke it out with Baron Zemo in the depths of space! " +
                    "Captain America tackles Codename: Bravo and Queen Hydra with the fate of the world in the balance..." +
                    "But first he has to fight his way through an army of Discordians!");
            List<String> languageList2 = new ArrayList<>();
            languageList2.add("en-us");
            comic2.setLanguages(languageList);
            comic2.setPrice("1.99");
            comic2.setDetailUrl("http://marvel.com/comics/issue/40391/captain_america_2011_18?utm_campaign=apiRef&utm_source=277232a94db26746c653c879d30cec89");
            comic2.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/3/70/516857a41de34.jpg");

            comicList.add(comic);
            comicList.add(comic2);

        }

        return comicList;
    }
}
