package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.Node;


public class MainMenuController {
	int currentUser;
	Manager M;
	Driver D;
	Passenger P;
	LoginAuthentication auth = new LoginAuthentication();
	public RadioButton AdminRadio;
	public RadioButton DriverRadio;
	public RadioButton UserRadio;
	public TextField LogUser;
	public PasswordField LogPass;
	
	
	// ------------------------- LOGIN TAB COMMANDS --------------------- \\
	
	public void UserAuthentication() {
		String username = LogUser.getText();
		String password = LogPass.getText();
		
		if(username.isEmpty() || password.isEmpty()) {
			currentUser = -1;
		}
		else if(AdminRadio.isSelected()) {
			currentUser = auth.authenticateAdmin(username, password);
		}
		else if(DriverRadio.isSelected()) {
			currentUser = auth.authenticateDriver(username, password);
		}
		else if(UserRadio.isSelected()) {
			currentUser = auth.authenticatePassenger(username, password);
		}
		else currentUser = -1;
	}
	
	public void homeUserLoader(ActionEvent e) throws IOException {
		Parent userHome = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
		Scene userHomeS = new Scene(userHome);
		
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(userHomeS);
	}
	
	public void homeAdminLoader(ActionEvent e) throws IOException {
		Parent adminHome = FXMLLoader.load(getClass().getResource("HomeScreenManager.fxml"));
		Scene adminHomeS = new Scene(adminHome);
		
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(adminHomeS);
	}
	
	public void homeDriverLoader(ActionEvent e) throws IOException {
		Parent adminHome = FXMLLoader.load(getClass().getResource("HomeScreenDriver.fxml"));
		Scene adminHomeS = new Scene(adminHome);
		
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(adminHomeS);
	}
	
	public void loginButton(ActionEvent e) throws IOException {
		UserAuthentication();
		if(currentUser == -1) {
			System.out.println("CurrentUser = -1");
			AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you choose the user type\n and enter the correct username/passowrd!");
		}
		else if(AdminRadio.isSelected()) {
			M = auth.getManager(currentUser);
			homeAdminLoader(e);
		}
		else if(DriverRadio.isSelected()) {
			D = auth.getDriver(currentUser);
			homeDriverLoader(e);
		}
		else if(UserRadio.isSelected()) {
			P = auth.getPassenger(currentUser);
			homeUserLoader(e);
		}
	}
	
	// ------------------------- REGISTER TAB COMMANDS --------------------- \\
	
	
}
