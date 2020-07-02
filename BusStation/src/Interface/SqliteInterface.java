package Interface;

public interface SqliteInterface {
    public void loadUsers();
    public void loadTrips();
    public void loadPrevalent();
    public void WriteUsers();
    public void WriteTrips();
    public void AddLocation();
    public void AddVehicles();
    public boolean authenticateLogin();
    public boolean confirmReservation();



}
