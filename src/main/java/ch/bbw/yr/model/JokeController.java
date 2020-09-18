/**
 *
 * Rest Api for jokes
 *
 * @Author: Yannick Ruck
 * @Date: 04/09/2020
 */
package ch.bbw.yr.model;

import ch.bbw.yr.dao.DataBaseAccess;
import ch.bbw.yr.dao.DataBaseAccessCsv;
import ch.bbw.yr.dao.DataBaseAccessMDB;
import ch.bbw.yr.dao.DataBaseAccessSQL;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class JokeController {

    DataBaseAccess daoSql = new DataBaseAccessSQL();
    JokeBook bookSql = new JokeBook(daoSql);

    DataBaseAccess daoMdb = new DataBaseAccessMDB();
    JokeBook bookMdb = new JokeBook(daoMdb);

    DataBaseAccess daoCsv = new DataBaseAccessCsv();
    JokeBook bookCsv = new JokeBook(daoCsv);

    @GetMapping("/sql/jokes")
    public ArrayList<Joke> allSql() {
        return bookSql.getJokes();
    }

    @GetMapping("/sql/jokes/{id}")
    public Joke oneSql(@PathVariable int id) {
        return bookSql.getJokeById(id);
    }

    @PostMapping("/sql/jokes")
    public void addJokeSQL(@RequestBody Joke newJoke) {
        bookSql.addJoke(newJoke);
    }

    @PutMapping("/sql/jokes/{id}")
    public void updateJokeSQL(@PathVariable int id, @RequestBody Joke newJoke) {
        bookSql.updateJoke(id ,newJoke);
    }

    @DeleteMapping("/sql/jokes/{id}")
    public void deleteJokeSQL(@PathVariable int id) {
        bookSql.deleteJoke(id);
    }



    @GetMapping("/mdb/jokes")
    ArrayList<Joke> allMdb() {
        return bookMdb.getJokes();
    }

    @GetMapping("/mdb/jokes/{id}")
    public Joke oneMdb(@PathVariable int id) {
        return bookMdb.getJokeById(id);
    }

    @PostMapping("/mdb/jokes")
    public void addJokeMDB(@RequestBody Joke newJoke) {
        bookMdb.addJoke(newJoke);
    }

    @PutMapping("/mdb/jokes/{id}")
    public void updateJokeMDB(@PathVariable int id, @RequestBody Joke newJoke) {
        bookMdb.updateJoke(id ,newJoke);
    }

    @DeleteMapping("/mdb/jokes/{id}")
    public void deleteJokeMDB(@PathVariable int id) {
        bookMdb.deleteJoke(id);
    }

    @GetMapping("/csv/jokes")
    ArrayList<Joke> allCsv() {
        return bookCsv.getJokes();
    }
}
