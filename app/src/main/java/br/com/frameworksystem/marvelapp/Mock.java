package br.com.frameworksystem.marvelapp;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

import br.com.frameworksystem.marvelapp.model.Character;

/**
 * Created by wgomes on 16/06/16.
 */

public class Mock {

    public static List<Character> getCharacter() {

        List<Character> characterList = new ArrayList<>();

        Character character = new Character();
        character.setName("Spider-Man");
        character.setDescription("Bitten by a radioactive spider, high school student Peter " +
                "Parker gained the speed, strength and powers of a spider. Adopting the name Spider-Man, " +
                "Peter hoped to start a career using his new abilities. Taught that with great power comes " +
                "great responsibility, Spidey has vowed to use his powers to help people.");
        character.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/3/50/526548a343e4b,jpg");


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

}
