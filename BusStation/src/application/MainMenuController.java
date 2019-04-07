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
	public TextField RegUser;
	public PasswordField RegPass;
	public PasswordField RegPass1;
	HomeScreenManagerController homeScreenM;
	
	
	// ------------------------- LOGIN TAB COMMANDS --------------------- \\
	
	public void UserAuthentication() {
		String username = LogUser.getText();
		String password = LogPass.getText();
		
		if(username == null || password == null) currentUser = -1;
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
	
	public void homeUserLoader(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("HomeScreen.fxml"));
		Parent userHome = loader.load();
		Scene userHomeS = new Scene(userHome);
		
		HomeScreenController controller = loader.getController();
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(userHomeS);
	}
	
	public void homeAdminLoader(ActionEvent e, Manager a) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("HomeScreenManager.fxml"));
		Parent ManagerHome = loader.load();
		Scene MHome = new Scene(ManagerHome);
		
		HomeScreenManagerController controller = loader.getController();
		controller.getProfile(a);
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(MHome);
	}
	
	public void homeDriverLoader(ActionEvent e) throws IOException {
		Parent adminHome = FXMLLoader.load(getClass().getResource("HomeScreenDriver.fxml"));
		Scene adminHomeS = new Scene(adminHome);
		
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(adminHomeS);
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
			AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you choose the user type\n and enter the correct username/passowrd!");
		}
		else if(AdminRadio.isSelected()) {
			M = auth.getManager(currentUser);
			homeAdminLoader(e, M);
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
	
	public boolean fieldsEmpty() {
		boolean flag=false;
		if(RegUser.getText() == null || RegPass.getText() == null || RegPass1.getText() == null) flag=true;
		else if (RegUser.getText().isEmpty() || RegPass.getText().isEmpty() || RegPass1.getText().isEmpty()) flag=true; 
		else flag= false;
		return flag;
	}
	
	public void regLoader(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Registeration.fxml"));
		Parent Reg = loader.load();
		Scene RegS = new Scene(Reg);
		
		HomeScreenManagerController controller = loader.getController();
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(RegS);
	}
	
	public void signUpButtonClicked(ActionEvent e) throws IOException {		
		if(fieldsEmpty())
			AlertBox.display("UNEXPECTED INPUT!", "Please make sure you filled all the fields with your data before proceeding!");
		else regLoader(e);
	}
		 
			
		
	}
	


