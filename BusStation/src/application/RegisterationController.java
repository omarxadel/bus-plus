package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterationController implements Initializable {
	Database d;
	Passenger p;
	public String user,pass;
	public ChoiceBox<String> GenderSelectReg;
	public Button SignUpMain;
	public Button Return;
	public String Gender;
	public TextField RegUserC;
	public PasswordField RegPassC;
	public PasswordField ReregPass1;
	public TextField FnameReg;
	public TextField LnameReg;
	public TextField CityReg;
	public TextField CountryReg;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		interfaceInit();
		
	}
	
	public void homeUserLoader(ActionEvent e, Passenger p) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("HomeScreen.fxml"));
		Parent userHome = loader.load();
		Scene userHomeS = new Scene(userHome);
		
		HomeScreenController controller = loader.getController();
		controller.getProfile(p);
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(userHomeS);
	}
	
	
	public void getData(String username, String password) {	
		RegUserC.setText(username);
		RegPassC.setText(password);
	}
	
	
	public void interfaceInit() {
		GenderSelectReg.getItems().addAll("Male","Female");
		GenderSelectReg.setValue("Male");
	}
	
	
	public void SignUpMainClicked(ActionEvent e) throws IOException {
		String Gender = GenderSelectReg.getValue();
		this.Gender = Gender;
		d = new Database();
		p = d.addPassengerData(FnameReg.getText(), LnameReg.getText(), RegUserC.getText(), RegPassC.getText(), CityReg.getText(), CountryReg.getText(), this.Gender);
		AlertBox.display("SUCCESS!", "Welcome to Bus " + FnameReg.getText(), "Proceed");
		homeUserLoader(e, p);
	}


}
