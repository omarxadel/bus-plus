package Interface;

public interface SqliteInterface {
    public void loadUsers();
    public void loadTrips();
    public void loadPrevalent();
    public boolean authenticateLogin();
    public boolean confirmReservation();
}
