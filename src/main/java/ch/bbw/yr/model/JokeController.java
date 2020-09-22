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
    public ArrayList<Joke> addJokeSQL(@RequestBody Joke newJoke) {
         bookSql.addJoke(newJoke);
         return bookSql.getJokes();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/sql/jokes/{id}")
    public ArrayList<Joke> updateJokeSQL(@PathVariable int id, @RequestBody Joke newJoke) {
        bookSql.updateJoke(id ,newJoke);
        return bookSql.getJokes();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/sql/jokes/{id}")
    public ArrayList<Joke> deleteJokeSQL(@PathVariable int id) {
        bookSql.deleteJoke(id);
        return bookSql.getJokes();
    }



    @GetMapping("/mdb/jokes")
    public ArrayList<Joke> allMdb() {
        return bookMdb.getJokes();
    }

    @GetMapping("/mdb/jokes/{id}")
    public Joke oneMdb(@PathVariable int id) {
        return bookMdb.getJokeById(id);
    }

    @PostMapping("/mdb/jokes")
    public ArrayList<Joke> addJokeMDB(@RequestBody Joke newJoke) {
        bookMdb.addJoke(newJoke);
        return bookMdb.getJokes();
    }

    @PutMapping("/mdb/jokes/{id}")
    public ArrayList<Joke> updateJokeMDB(@PathVariable int id, @RequestBody Joke newJoke) {
        bookMdb.updateJoke(id ,newJoke);
        return bookMdb.getJokes();
    }

    @DeleteMapping("/mdb/jokes/{id}")
    public ArrayList<Joke> deleteJokeMDB(@PathVariable int id) {
        bookMdb.deleteJoke(id);
        return bookMdb.getJokes();
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
    public ArrayList<Joke> addJokeCsv(@RequestBody Joke newJoke) {
        bookCsv.addJoke(newJoke);
        return bookCsv.getJokes();
    }

    @PutMapping("/csv/jokes/{id}")
    public ArrayList<Joke> updateJokeCsv(@PathVariable int id, @RequestBody Joke newJoke) {
        bookCsv.updateJoke(id ,newJoke);
        return bookCsv.getJokes();
    }

    @DeleteMapping("/csv/jokes/{id}")
    public ArrayList<Joke> deleteJokeCsv(@PathVariable int id) {
        bookCsv.deleteJoke(id);
        return bookCsv.getJokes();
    }
}
