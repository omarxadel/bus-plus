
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import database.SqliteDB;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import model.Users;
import view.AlertBox;
import animatefx.animation.*;

import javax.swing.*;


public class MainMenuController implements Initializable{
	SqliteDB db = SqliteDB.getInstance();

	@FXML
	private Pane register_pane, login_pane;
	@FXML
	private TextField username_input_login, username_input_register;
	@FXML
	private PasswordField password_input_login;
	@FXML
	private Button login_btn, forgot_password_btn, create_account_btn, register_continue_btn;
	@FXML
	private Circle minimize_btn, exit_btn, resize_btn;
	@FXML
	private BorderPane main_menu_root;
	
	
	// ------------------------- Initialize --------------------- \\
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//TODO: Initialize Stuff
	}


	// ------------------------- HANDLE BUTTON CLICKS --------------------- \\

	@FXML
	private void handleButtonAction(ActionEvent event){


	}


	@FXML
	private void handleMouseClick(MouseEvent event){
		if(event.getSource() == (exit_btn)){
			System.exit(0);
		}
		if(event.getSource().equals(login_btn)){

		}
		if(event.getSource().equals(create_account_btn)){

		}

	}


	// ------------------------- LOGIN PANE OPERATIONS --------------------- \\

/*	public void homeUserLoader(ActionEvent e,Passenger c, int index) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("HomeScreen.fxml"));
		Parent userHome = loader.load();
		Scene userHomeS = new Scene(userHome);
		
		HomeScreenController controller = loader.getController();
		controller.getProfile(c);
		controller.currentuserIndex = index;
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(userHomeS);
	}*/
	
/*	public void homeAdminLoader(ActionEvent e, Admin a, int index) throws IOException {
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
	}*/
	
	private void clearFields(){
		password_input_login.setText(null);
		username_input_login.setText(null);
		username_input_register.setText(null);
	}
	
	public void loginButton(ActionEvent e) throws IOException {
		Users currentUser = db.authenticateLogin(username_input_login.getText(), password_input_login.getText());
		if(currentUser != null) {
			//TODO: LOGIN APPROVED ACTION
		}
		else{
			AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you choose the user type\n and enter the correct username/passowrd!", "OK");
		}
	}
	
	// ------------------------- REGISTER PANE COMMANDS --------------------- \\

	public void registerScreenCall(){
		register_pane.setVisible(true);
		login_pane.setVisible(false);
	}

/*	public void regLoader(ActionEvent e, String username, String password) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Registeration.fxml"));
		Parent Reg = loader.load();
		Scene Regs = new Scene(Reg);
		
		RegisterationController controller = loader.getController();
		controller.getData(username, password);
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(Regs);
	}*/
	
	
	/*private boolean fieldsEmpty() {
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
*/

}
