/**
 * @Author: Yannick Ruck
 * @Date: 04/09/2020
 */
package ch.bbw.yr.dao;

import ch.bbw.yr.dao.DataBaseAccess;
import ch.bbw.yr.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccessCsv implements DataBaseAccess {
    private ArrayList<Joke> jokes = new ArrayList<>();
    private Joke joke = new Joke();
    private String path = "jdbc:hsqldb:file:D:\\Tools\\Installs\\intellij-idea-community-portable\\Projects\\JokeDB\\src\\main\\resources\\excel\\hsqldb";
    @Override
    public ArrayList<Joke> getAllJokes() {
        try {
            Connection conn = DriverManager.getConnection(
                    path);
            Statement s = conn.createStatement();
            s.execute("DROP TABLE IF EXISTS joke");
            s.execute("CREATE TEXT TABLE joke (id int, joke varchar(100), rating int, date datetime)");
            s.execute("SET TABLE joke SOURCE 'joke.csv;ignore_first=true;fs=\\semi'");
            ResultSet rs = s.executeQuery("SELECT * FROM joke");
            while (rs.next()) {
                jokes.add(JokeFillerCsv.createJokeObject(rs));
            }
            conn.close();
            s.close();
            rs.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return jokes;
    }

    @Override
    public void addJoke(Joke newJoke) {

    }

    @Override
    public void updateJoke(int id, Joke newJoke) {

    }

    @Override
    public void deleteJoke(int id) {

    }

    @Override
    public Joke getJokeById(int id) {
        return null;
    }
}
