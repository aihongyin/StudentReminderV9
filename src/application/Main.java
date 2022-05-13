package application;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {

	public static final Database database = new Database();

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Student Reminder");
		SignUp signupNew = new SignUp();
		signupNew.createFile();

		StudentReminder studentReminder = new StudentReminder(primaryStage);

		// Set the scene in primary stage
		primaryStage.setScene(studentReminder.getSignIn());

		primaryStage.show();
	}

	public static void main(String[] args) {

	//	Main.database.getAllAssignments().forEach((k, v) -> System.out.println(v.toString()));

		launch(args);
	}

	public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}
