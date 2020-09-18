/**
 * @Author: Yannick Ruck
 * @Date: 04/09/2020
 */
package ch.bbw.yr.model;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Joke {
    public int id;
    public String text;
    public int rating;
    public Date date;

    public void setupJoke(int id, String text, int rating, Date date){
        this.id = id;
        this.text = text;
        this.rating= rating;
        this.date = date;
    }
}
