package database;

import Interface.SqliteInterface;

import javax.xml.transform.Result;
import java.sql.*;

public class SqliteDB implements SqliteInterface {
    private Connection c = null;
    private Statement stmt = null;
    private String loadStmt = "SELECT * FROM ";

    // SINGLETON DESIGN PATTERN
    private static SqliteDB instance = new SqliteDB();

    private SqliteDB() {

        checkConnection();
    }

    public static SqliteDB getInstance(){
        return instance;
    }


    // ESTABLISH CONNECTION WITH DB
    private void checkConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:BusStationDB.sqlite");
            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // LOAD DATA
    @Override
    public void loadUsers() {
        try {
            stmt = c.createStatement();
            ResultSet resultSet = stmt.executeQuery(loadStmt + "User");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void loadTrips() {
        try {
            stmt = c.createStatement();
            ResultSet resultSetTrips = stmt.executeQuery(loadStmt + "Trips");
            ResultSet resultSetSeats = stmt.executeQuery(loadStmt + "Seats");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void loadPrevalent() {
        try {
            stmt = c.createStatement();
            ResultSet resultSetLocation = stmt.executeQuery(loadStmt + "Location");
            ResultSet resultSetVehicles = stmt.executeQuery(loadStmt + "Vehicles");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void WriteUsers() {
        String query="INSERT INTO User (username,firstname,lastname,password,city,country,id,type,credit)" ;
        try {
            this.stmt=c.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void WriteTrips() {
        String query1="INSERT INTO Trips (id,dest,start,price,type,vehicle_num,driver_name,date,time)" ;
        try {
            this.stmt=c.createStatement();
            stmt.executeQuery(query1);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }

    @Override
    public void AddLocation() {
        String query2="INSERT INTO Location (name.position)" ;
        try {
            this.stmt=c.createStatement();
            stmt.executeQuery(query2);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }

    @Override
    public void AddVehicles() {
        String query3="INSERT INTO Vehicles (vehicle_num,type,model" ;
        try {
            this.stmt=c.createStatement();
            stmt.executeQuery(query3);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }


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
