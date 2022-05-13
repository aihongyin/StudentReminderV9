package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddCustomAssignmentPane {

	public AddCustomAssignmentPane(StudentReminder studentReminder) {
		super();
		this.studentReminder = studentReminder;
		this.stage = studentReminder.getStage();
	}

	private final StudentReminder studentReminder;
	private final Stage stage;
	private GridPane gridPane;

	public GridPane createPane() {
		gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(50, 50, 50, 50));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		addUIControls();
		return gridPane;
	}

	private void addUIControls() {
		Label headerLabel = new Label("Add Custom Assignment");
		headerLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 28));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.LEFT);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		// Add Name Label
		Label nameLabel = new Label("Name : ");
		gridPane.add(nameLabel, 0, 1);

		// Add Name Text Field
		TextField nameField = new TextField();
		gridPane.add(nameField, 1, 1);

		// Add Start Label
		Label startLabel = new Label("Start date: ");
		gridPane.add(startLabel, 0, 2);

		// Add Start Field
		DatePicker startField = new DatePicker();
		gridPane.add(startField, 1, 2);

		// Add Due Label
		Label dueLabel = new Label("Due date: ");
		gridPane.add(dueLabel, 0, 3);

		// Add Due Field
		DatePicker dueField = new DatePicker();
		gridPane.add(dueField, 1, 3);

		// Add Save Button
		Button saveButton = new Button("Save");
		saveButton.setDefaultButton(true);
		gridPane.add(saveButton, 0, 4, 1, 2);
		GridPane.setMargin(saveButton, new Insets(20, 0, 20, 0));

		// Add Cancel Button
		Button cancelButton = new Button("Cancel");
		gridPane.add(cancelButton, 1, 4, 1, 2);
		GridPane.setMargin(cancelButton, new Insets(20, 0, 20, 0));

		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String name = nameField.getText();
				if (name.isEmpty()) {
					Main.showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your name");
					return;
				} else if (Main.database.hasAssignment(name)) {
					Main.showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Assignment " + name + " already exists");
					return;
				}
				if (startField.getValue() == null) {
					Main.showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your start date");
					return;
				}
				if (dueField.getValue() == null) {
					Main.showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
							"Please enter your due date");
					return;
				}

				Assignment newAssignment = new Assignment(0, name, "some detail", startField.getValue().atStartOfDay(),
						dueField.getValue().atStartOfDay(), false);
				Main.database.insertAssignment(newAssignment);

				Main.showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Save Successful!",
						"Saved assignment " + nameField.getText() + " : " + newAssignment);

			}
		});

		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(studentReminder.getHomepage());
			}
		});
	}

}
