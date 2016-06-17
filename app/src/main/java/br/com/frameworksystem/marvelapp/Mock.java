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
        character.setName();
        character.setDescription();
        character.getThumbnail();


        Character character2 = new Character();
        character2.setName();
        character2.setDescription();
        character2.getThumbnail();


        Character character3 = new Character();
        character3.setName();
        character3.setDescription();
        character3.getThumbnail();

        characterList.add(character);
        characterList.add(character2);
        characterList.add(character3);

        return characterList;


    }

}
