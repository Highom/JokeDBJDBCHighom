/**
 * @Author: Yannick Ruck
 * @Date: 04/09/2020
 */
package ch.bbw.yr.dao;

import ch.bbw.yr.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccessCsv implements DataBaseAccess, SetupDatabaseAccess {
    private ArrayList<Joke> jokes = new ArrayList<>();
    private Joke joke = new Joke();
    private String path = "jdbc:hsqldb:file:D:\\Tools\\Installs\\intellij-idea-community-portable\\Projects\\JokeDB\\src\\main\\resources\\excel\\hsqldb";

    @Override
    public void setupDB(){
        try {
            Connection conn = DriverManager.getConnection(
                    path);
            Statement s = conn.createStatement();
            s.execute("DROP TABLE IF EXISTS joke");
            s.execute("CREATE TEXT TABLE joke (id int IDENTITY, joke varchar(100), rating int, date datetime)");
            s.execute("SET TABLE joke SOURCE 'joke.csv;ignore_first=true;fs=\\semi'");
            conn.close();
            s.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    @Override
    public ArrayList<Joke> getAllJokes() {
        try {
            Connection conn = DriverManager.getConnection(
                    path);
            Statement s = conn.createStatement();
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

    //add date and id to csv!
    @Override
    public Joke getJokeById(int id) {
        try {
            Connection conn = DriverManager.getConnection(path);
            PreparedStatement SqlStatement = conn.prepareStatement("SELECT * FROM joke WHERE id = ?");
            SqlStatement.setInt(1, id);
            ResultSet rs = SqlStatement.executeQuery();
            while (rs.next()) {
                joke = JokeFillerCsv.createJokeObject(rs);
            }
            conn.close();
            SqlStatement.close();
            rs.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return joke;
    }

    @Override
    public void addJoke(Joke newJoke) {
        try {
            Connection conn = DriverManager.getConnection(path);
            PreparedStatement SqlStatement = conn.prepareStatement("INSERT INTO joke (joke,rating,date) VALUES (?,?,?);");
            SqlStatement.setString(1, newJoke.text);
            SqlStatement.setInt(2, newJoke.rating);
            SqlStatement.setDate(3,  newJoke.date);
            SqlStatement.executeUpdate();
            conn.close();
            SqlStatement.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    @Override
    public void updateJoke(int id, Joke newJoke) {
        try {
            Connection conn = DriverManager.getConnection(path);
            PreparedStatement SqlStatement = conn.prepareStatement("UPDATE joke SET joke=?, rating=? WHERE id=?");
            SqlStatement.setString(1, newJoke.text);
            SqlStatement.setInt(2, newJoke.rating);
            SqlStatement.setInt(3, id);
            SqlStatement.executeUpdate();
            conn.close();
            SqlStatement.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }

    @Override
    public void deleteJoke(int id) {
        try {
            Connection conn = DriverManager.getConnection(path);
            PreparedStatement SqlStatement = conn.prepareStatement("DELETE FROM joke WHERE id=?");
            SqlStatement.setInt(1, id);
            SqlStatement.executeUpdate();
            conn.close();
            SqlStatement.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }
}
