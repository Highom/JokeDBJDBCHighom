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

    public void addJoke(Joke newJoke) {dao.addJoke(newJoke);}

    public void updateJoke(int id, Joke newJoke) {dao.updateJoke(id,newJoke);}

    public void deleteJoke(int id) {dao.deleteJoke(id);}
}
