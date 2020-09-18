/**
 * @Author: Yannick Ruck
 * @Date: 04/09/2020
 */
package ch.bbw.yr.dao;

import ch.bbw.yr.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccessMDB implements DataBaseAccess {
    private ArrayList<Joke> jokes = new ArrayList<>();
    private Joke joke = new Joke();
    private String path = "jdbc:ucanaccess://src/main/resources/JokeDBAccess2003.mdb";
    private String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    @Override
    public ArrayList<Joke> getAllJokes() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(
                    path);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM joke");
            while (rs.next()) {
                jokes.add(JokeFillerMDB.createJokeObject(rs));
            }
            conn.close();
            s.close();
            rs.close();
        } catch (SQLException | ClassNotFoundException err) {
            err.printStackTrace();
        }
        return jokes;
    }


    @Override
    public Joke getJokeById(int id) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(path);
            PreparedStatement SqlStatement = conn.prepareStatement("SELECT * FROM joke WHERE jokeid=?");
            SqlStatement.setInt(1, id);
            ResultSet rs = SqlStatement.executeQuery();
            while (rs.next()) {
                joke = JokeFillerMDB.createJokeObject(rs);
            }
            conn.close();
            SqlStatement.close();
            rs.close();
        } catch (SQLException | ClassNotFoundException err) {
            err.printStackTrace();
        }
        return joke;
    }

    @Override
    public void addJoke(Joke newJoke) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(path);
            PreparedStatement SqlStatement = conn.prepareStatement("INSERT INTO joke (content,rating) VALUES (?,?);");
            SqlStatement.setString(1, newJoke.text);
            SqlStatement.setInt(2, newJoke.rating);
            SqlStatement.executeUpdate();
            conn.close();
            SqlStatement.close();
        } catch (SQLException | ClassNotFoundException err) {
            err.printStackTrace();
        }

    }

    @Override
    public void updateJoke(int id, Joke newJoke) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(path);
            PreparedStatement SqlStatement = conn.prepareStatement("UPDATE joke SET content=?, rating=? WHERE jokeid=?");
            SqlStatement.setString(1, newJoke.text);
            SqlStatement.setInt(2, newJoke.rating);
            SqlStatement.setInt(3, id);
            SqlStatement.executeUpdate();
            conn.close();
            SqlStatement.close();
        } catch (SQLException | ClassNotFoundException err) {
            err.printStackTrace();
        }

    }

    @Override
    public void deleteJoke(int id) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(path);
            PreparedStatement SqlStatement = conn.prepareStatement("DELETE FROM joke WHERE jokeid=?");
            SqlStatement.setInt(1, id);
            SqlStatement.executeUpdate();
            conn.close();
            SqlStatement.close();
        } catch (SQLException | ClassNotFoundException err) {
            err.printStackTrace();
        }
    }

}
