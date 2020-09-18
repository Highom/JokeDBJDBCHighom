/**
 * @Author: Yannick Ruck
 * @Date: 06/09/2020
 */
package ch.bbw.yr.dao;

import ch.bbw.yr.model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFillerMDB {
    private static void fillJoke(Joke joke, ResultSet entry) throws SQLException {
        joke.setupJoke(
                entry.getInt("jokeId"),
                entry.getString("content"),
                entry.getInt("rating"),
                entry.getDate("date"));
    }

    public static Joke createJokeObject (ResultSet entry) throws SQLException{
        Joke joke = new Joke();
        fillJoke(joke, entry);
        return joke;
    }
}
