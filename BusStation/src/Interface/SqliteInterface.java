package Interface;

import model.Users;

public interface SqliteInterface {
    public void loadUsers();
    public void loadTrips();
    public void loadPrevalent();
    public void WriteUsers();
    public void WriteTrips();
    public void AddLocation();
    public void AddVehicles();
    public Users authenticateLogin(String username, String password);
    public boolean confirmReservation();
}
