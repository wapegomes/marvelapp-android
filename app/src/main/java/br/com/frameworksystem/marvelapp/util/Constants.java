package br.com.frameworksystem.marvelapp.util;

/**
 * Created by wgomes on 04/07/16.
 */

public interface Constants {


    String DDL_CHARACTER = "CREATE TABLE [character] (\n" +
            "  [id] TEXT NOT NULL, \n" +
            "  [name] VARCHAR(100), \n" +
            "  [description] TEXT, \n" +
            "  [link] TEXT, \n" +
            "  [image] TEXT, \n" +
            "  [favorite] INTEGER DEFAULT 0, \n"+
            "  CONSTRAINT [] PRIMARY KEY ([id]));\n";

    String DDL_EVENT = "CREATE TABLE [event] (\n" +
            "  [id] TEXT NOT NULL, \n" +
            "  [name] VARCHAR(100), \n" +
            "  [description] TEXT, \n" +
            "  [image] TEXT, \n" +
            "  [link] TEXT, \n" +
            "  CONSTRAINT [] PRIMARY KEY ([id]));";
}
