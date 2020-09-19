/**
 *
 * Rest Api for jokes
 *
 * @Author: Yannick Ruck
 * @Date: 04/09/2020
 */
package ch.bbw.yr.model;

import ch.bbw.yr.dao.DataBaseAccess;
import ch.bbw.yr.factory.DataAccessFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class JokeController {

    DataAccessFactory factory = new DataAccessFactory();

    DataBaseAccess daoSql = factory.createDAO("sql");
    JokeBook bookSql = new JokeBook(daoSql);

    DataBaseAccess daoMdb = factory.createDAO("mdb");
    JokeBook bookMdb = new JokeBook(daoMdb);

    DataBaseAccess daoCsv = factory.createDAO("csv");
    JokeBook bookCsv = new JokeBook(daoCsv);

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/sql/jokes")
    public ArrayList<Joke> allSql() {
        return bookSql.getJokes();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/sql/jokes/{id}")
    public Joke oneSql(@PathVariable int id) {
        return bookSql.getJokeById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/sql/jokes")
    public void addJokeSQL(@RequestBody Joke newJoke) {
        bookSql.addJoke(newJoke);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/sql/jokes/{id}")
    public void updateJokeSQL(@PathVariable int id, @RequestBody Joke newJoke) {
        bookSql.updateJoke(id ,newJoke);
    }

    @CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/csv/jokes/{id}")
    public Joke oneCsv(@PathVariable int id) {
        return bookCsv.getJokeById(id);
    }

    @PostMapping("/csv/jokes")
    public void addJokeCsv(@RequestBody Joke newJoke) {
        bookCsv.addJoke(newJoke);
    }

    @PutMapping("/csv/jokes/{id}")
    public void updateJokeCsv(@PathVariable int id, @RequestBody Joke newJoke) {
        bookCsv.updateJoke(id ,newJoke);
    }

    @DeleteMapping("/csv/jokes/{id}")
    public void deleteJokeCsv(@PathVariable int id) {
        bookCsv.deleteJoke(id);
    }
}
