
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import database.SqliteDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Users;
import ui_components.AlertBox;


public class MainMenuController implements Initializable{
	SqliteDB db = SqliteDB.getInstance();
	private double xOffset, yOffset;
	private Users user;

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
		// MOVE THE WINDOW
		main_menu_root.setOnMousePressed(mouseEvent -> {
			xOffset = main_menu_root.getScene().getWindow().getX() - mouseEvent.getScreenX();
			yOffset = main_menu_root.getScene().getWindow().getY() - mouseEvent.getScreenY();
		});

		main_menu_root.setOnMouseDragged(mouseEvent -> {
			main_menu_root.getScene().getWindow().setX(mouseEvent.getScreenX() + xOffset);
			main_menu_root.getScene().getWindow().setY(mouseEvent.getScreenY() + yOffset);
		});
	}


	// ------------------------- HANDLE ACTION --------------------- \\

	@FXML
	private void handleButtonAction(ActionEvent event){


	}

	@FXML
	private void handleKeyPressed(KeyEvent event){
		if(event.getSource().equals(username_input_login) || event.getSource().equals(password_input_login)){
			if(event.getCode() == KeyCode.ENTER){
				login();
			}
		}
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

	private void homeUserLoader(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/HomeScreen.fxml"));
		Parent userHome = null;
		try {
			userHome = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(userHome != null) {
			Scene userHomeS = new Scene(userHome);
			HomeScreenController controller = loader.getController();
			controller.setUser(user);
			Stage stage = (Stage) (main_menu_root.getScene().getWindow());
			stage.setScene(userHomeS);
		}
	}

	private void login(){
		user = db.authenticateLogin(username_input_login.getText(), password_input_login.getText());
		if(user != null) {
			homeUserLoader();
		}
		else{
			AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you choose the user type\n and enter the correct username/passowrd!", "OK");
		}
	}
	
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
		login();
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
