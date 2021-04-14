package database;

import Interface.SQLiteInterface;
import model.Admin;
import model.Trip;
import model.Users;

import java.sql.*;

public class SQLiteDB implements SQLiteInterface {
    private Connection c = null;
    private Statement stmt = null;
    private String loadStmt = "SELECT * FROM ";
    private String sizeStmt = "SELECT COUNT(*) FROM ";
    private String loginQuery = "select * from User where username=? and password=?";
    private int tripsAmount = 0;

    // SINGLETON DESIGN PATTERN
    private static SQLiteDB instance = new SQLiteDB();

    private SQLiteDB() {
        checkConnection();
    }

    public static SQLiteDB getInstance(){
        return instance;
    }


    // ESTABLISH CONNECTION WITH DB
    private void checkConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:BusStationDB.db");
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
    public Trip[] loadTrips() {
        Trip[] trips = null;
        try {
            stmt = c.createStatement();
            ResultSet tableSize = stmt.executeQuery(sizeStmt + "Trips");
            ResultSet resultSetTrips = stmt.executeQuery("SELECT * FROM Trips");
            loadSeats();
            tripsAmount = tableSize.getInt(1);
            tripsAmount++;
/*
            ResultSet resultSetSeats = stmt.executeQuery(loadStmt + "Seats");
*/
            trips = new Trip[tripsAmount];
            int i = 0;
            while(resultSetTrips.next()){
                trips[i] = new Trip(resultSetTrips.getInt("id"), resultSetTrips.getInt("type") == 0? "One Way" : "Round Trip", resultSetTrips.getString("start"), resultSetTrips.getString("dest"), resultSetTrips.getString("driver_name"), resultSetTrips.getInt("vehicle_num"), resultSetTrips.getString("date"), resultSetTrips.getString("time"), resultSetTrips.getFloat("price"));
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return trips;
    }

    private void loadSeats() {
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


    // WRITE DATA
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

    //AUTHENTICATE

    @Override
    public Users authenticateLogin(String username, String password) {
        try {
            PreparedStatement stmt = c.prepareStatement(loginQuery);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()){
                if(resultSet.getInt("type") == 1){ //ADMIN
                    Admin user = new Admin(resultSet.getString("firstname"), resultSet.getString("lastname"), username, password, resultSet.getInt("ID"), resultSet.getString("city"), resultSet.getString("country"), (resultSet.getInt("gender") == 1) ? "Male" : "Female");
                    return user;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean confirmReservation() {
        return false;
    }

    @Override
    public int getTripsAmount() {
        loadTrips();
        return tripsAmount;
    }
}
