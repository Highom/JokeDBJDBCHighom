/**
 * @Author: Yannick Ruck
 * @Date: 05/09/2020
 */
package ch.bbw.yr.dao;

import ch.bbw.yr.model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFillerSQL {
    private static void fillJoke(Joke joke, ResultSet entry) throws SQLException {
        joke.setupJoke(
                entry.getInt("id"),
                entry.getString("text"),
                entry.getInt("rating"),
                entry.getDate("date"));
    }

    public static Joke createJokeObject (ResultSet entry) throws SQLException{
        Joke joke = new Joke();
        fillJoke(joke, entry);
        return joke;
    }
}
