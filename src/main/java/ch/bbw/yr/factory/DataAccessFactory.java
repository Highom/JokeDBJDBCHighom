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

        DataBaseAccess dao = null;

        switch (type)
        {
            case "sql":
                dao = new DataBaseAccessSQL();
                break;

            case "mdb":
                dao = new DataBaseAccessMDB();
                break;

            case "csv":
                dao = new DataBaseAccessCsv();
                break;

            default:
                break;
        }

        return dao;

    }
}
