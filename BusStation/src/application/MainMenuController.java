
package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.Node;


public class MainMenuController implements Initializable{
	int currentUser;
	Manager M;
	Driver D;
	Passenger P;
	LoginAuthentication auth;
	public RadioButton AdminRadio;
	public RadioButton DriverRadio;
	public RadioButton UserRadio;
	public TextField LogUser;
	public TextField RegUser;
	public PasswordField RegPass;
	public PasswordField RegPass1;
	public PasswordField LogPass;
	
	
	// ------------------------- Initialize Database --------------------- \\
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		auth = new LoginAuthentication();
		
	}

	
	
	// ------------------------- LOGIN TAB COMMANDS --------------------- \\
	
	public void UserAuthentication() {
		String username = LogUser.getText();
		String password = LogPass.getText();
		
		if (username== null || password==null)
		{
			currentUser = -1;
		}
		else if(username.isEmpty() || password.isEmpty()) {
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
	
	public void homeUserLoader(ActionEvent e,Passenger c) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("HomeScreen.fxml"));
		Parent userHome = loader.load();
		Scene userHomeS = new Scene(userHome);
		
		HomeScreenController controller = loader.getController();
		controller.getProfile(c);
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(userHomeS);
	}
	
	public void homeAdminLoader(ActionEvent e, Manager a, int index) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("HomeScreenManager.fxml"));
		Parent ManagerHome = loader.load();
		Scene MHome = new Scene(ManagerHome);
		
		HomeScreenManagerController controller = loader.getController();
		controller.getProfile(a);
		controller.D = auth.getDrivers();
		controller.currentuserInd = index;
		controller.choiceInit();
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(MHome);
	}
	
	public void homeDriverLoader(ActionEvent e, Driver b) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("HomeScreenDriver.fxml"));
		Parent DriverHome = loader.load();
		Scene DHome = new Scene(DriverHome);
		HomeScreenDriverController controller = loader.getController();
		controller.getProfile(b);
		controller.myTripsInit();
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(DHome);
	}
	
	private void clearFields() {
		LogUser.setText(null);
		LogPass.setText(null);
	}
	
	public void loginButton(ActionEvent e) throws IOException {
		UserAuthentication();
		clearFields();
		if(currentUser == -1) {
			System.out.println("CurrentUser = -1");
			AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you choose the user type\n and enter the correct username/passowrd!", "OK");
		}
		else if(AdminRadio.isSelected()) {
			M = auth.getManager(currentUser);
			homeAdminLoader(e, M, currentUser);
		}
		else if(DriverRadio.isSelected()) {
			D = auth.getDriver(currentUser);
			homeDriverLoader(e, D);
		}
		else if(UserRadio.isSelected()) {
			P = auth.getPassenger(currentUser);
			homeUserLoader(e, P);
		}
		
	}
	
	// ------------------------- REGISTER TAB COMMANDS --------------------- \\	
	
	public void regLoader(ActionEvent e, String username, String password) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Registeration.fxml"));
		Parent Reg = loader.load();
		Scene Regs = new Scene(Reg);
		
		RegisterationController controller = loader.getController();
		controller.getData(username, password);
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(Regs);
	}
	
	
	private boolean fieldsEmpty() {
		if(RegUser.getText() == null || RegPass.getText() == null || RegPass1.getText() == null) return true;
		else if(RegUser.getText().isEmpty() || RegPass.getText().isEmpty() || RegPass1.getText().isEmpty()) return true;
		else return false;
	}
	
	public void signUpButtonClicked(ActionEvent e) throws IOException {
		if(fieldsEmpty()) {
			AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you filled the fields with the correct data!", "OK");
		}
		else if(auth.userExist(RegUser.getText())) {
			AlertBox.display("UNEXPECTED INPUTS", "Username already exists! Please choose another!", "OK");
		}
		else if(passMatch()) {
			if(passLen() && userLen()) {
				String user = RegUser.getText();
				String pass = RegPass.getText();
				regLoader(e, user, pass);
			}
			else if(!userLen()) AlertBox.display("UNEXPECTED INPUTS!", "Username is too short! Make sure it's 4 or more characters!","OK");
			else if(!passLen()) AlertBox.display("UNEXPECTED INPUTS!", "Password is too short! Make sure it's 8 or more characters!", "OK");
		}
		else if(!passMatch()) {
			AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you re-enter the password correctly!", "OK");
		}
		else {}
	}
	
	private boolean passLen() {
			return (RegPass.getText().length() > 7);
		}
	private boolean passMatch() {
		return (RegPass.getText().equals(RegPass1.getText()));
	}
	private boolean userLen() {
		return (RegUser.getText().length() > 3);
	}


}
