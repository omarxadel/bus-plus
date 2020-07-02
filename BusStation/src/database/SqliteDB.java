package database;

import Interface.SqliteInterface;

import java.sql.Connection;
import java.sql.Statement;

public class SqliteDB implements SqliteInterface {
    Connection c = null;
    Statement stmt = null;


    public SqliteDB() {
    }

    private boolean checkConnection(){
        //TODO: WRITE BODY OF FUNCTION
        return false;
    }

    @Override
    public void loadUsers() {

    }

    @Override
    public void loadTrips() {

    }

    @Override
    public void loadPrevalent() {

    }

    @Override
    public boolean authenticateLogin() {
        return false;
    }

    @Override
    public boolean confirmReservation() {
        return false;
    }
}
