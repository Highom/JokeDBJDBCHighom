/**
 * @Author: Yannick Ruck
 * @Date: 04/09/2020
 */
package ch.bbw.yr.model;

import ch.bbw.yr.dao.DataBaseAccess;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JokeBook {
    private ArrayList<Joke> jokes;
    private DataBaseAccess dao;

    public JokeBook (DataBaseAccess dao){
        this.jokes = dao.getAllJokes();
        this.dao = dao;
    }

    public ArrayList<Joke> getJokes() {
        return this.jokes;
    }

    public Joke getJokeById(int id) {return dao.getJokeById(id);}

    public void addJoke(Joke newJoke) {
        newJoke.date = new java.sql.Date(System.currentTimeMillis());
        if (jokes.size() != 0){
            newJoke.id = jokes.get(jokes.size() - 1).id + 1;
        }

        dao.addJoke(newJoke);
        jokes.add(newJoke);
    }

    public void updateJoke(int id, Joke newJoke) {
        updateInArray(id,newJoke);
        dao.updateJoke(id,newJoke);
    }

    public void deleteJoke(int id) {
        jokes.removeIf(joke -> joke.id == id);
        dao.deleteJoke(id);
    }

    private void updateInArray (int id, Joke newJoke) {
        for(int i = 0; i < jokes.size(); i++){
            if(jokes.get(i).id == id){
                newJoke.id = jokes.get(i).id;
                newJoke.date = jokes.get(i).date;
                jokes.set(i, newJoke);
            }
        }
    }
}