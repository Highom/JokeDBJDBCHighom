/**
 * @Author: Yannick Ruck
 * @Date: 19/09/2020
 */
package ch.bbw.yr.factory;

import ch.bbw.yr.dao.DataBaseAccess;
import ch.bbw.yr.dao.DataBaseAccessCsv;
import ch.bbw.yr.dao.DataBaseAccessMDB;
import ch.bbw.yr.dao.DataBaseAccessSQL;

public class DataAccessFactory {

    public DataBaseAccess createDAO(String type) {

        switch (type)
        {
            case "sql":
                return new DataBaseAccessSQL();

            case "mdb":
                return new DataBaseAccessMDB();

            case "csv":
                return new DataBaseAccessCsv();

            default:
                break;
        }
        return null;
    }
}
