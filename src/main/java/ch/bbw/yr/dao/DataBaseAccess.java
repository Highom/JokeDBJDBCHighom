package ch.bbw.yr.dao;

import ch.bbw.yr.model.Joke;

import java.util.ArrayList;

public interface DataBaseAccess {

    ArrayList<Joke> getAllJokes();

    Joke getJokeById(int id);

    void addJoke(Joke newJoke);

    void updateJoke(int id, Joke newJoke);

    void deleteJoke(int id);
}
