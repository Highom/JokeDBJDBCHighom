/**
 * @Author: Yannick Ruck
 * @Date: 04/09/2020
 */
package ch.bbw.yr;

import ch.bbw.yr.dao.DataBaseAccess;
import ch.bbw.yr.dao.DataBaseAccessCsv;
import ch.bbw.yr.dao.SetupDatabaseAccess;
import ch.bbw.yr.factory.DataAccessFactory;
import ch.bbw.yr.model.JokeBook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class JokeDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JokeDbApplication.class, args);

		DataAccessFactory factory = new DataAccessFactory();
		SetupDatabaseAccess setupdb = (SetupDatabaseAccess) factory.createDAO("csv");
		setupdb.setupDB();
	}
}
