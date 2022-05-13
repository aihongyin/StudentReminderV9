package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StudentReminder {

	private static final int SCENE_SIZE_Y = 500;
	private static final int SCENE_SIZE_X = 800;

	private final Stage stage;

	Scene signIn, signUp, homepage, addCustomAssignment;

	public StudentReminder(Stage primaryStage) {
		super();
		this.stage = primaryStage;

		createSignIn();
		createSignUp();
		createWelcome();
		createAddCustomAssignment();

	}

	private void createAddCustomAssignment() {
		addCustomAssignment = new Scene(new AddCustomAssignmentPane(this).createPane(), SCENE_SIZE_X, SCENE_SIZE_Y);
	}

	public Scene getSignIn() {
		return signIn;
	}

	public Scene getSignUp() {
		return signUp;
	}

	public Scene getHomepage() {
		return homepage;
	}

	public Stage getStage() {
		return stage;
	}

	private void createSignIn() {

		// Scene: The Sign In Page
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(8);
		gridPane.setVgap(8);
		gridPane.setAlignment(Pos.CENTER);

		Text title = new Text("Sign In");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label lblUserName = new Label("Username");
		final TextField textUserName = new TextField();
		Label lblPassword = new Label("Password");
		final PasswordField password = new PasswordField();
		Button btnLogin = new Button("Login");
		final Label lblMessage = new Label();
		Label signupPromote = new Label("Don't have an account?");
		Hyperlink signUpLink = new Hyperlink("Sign Up");
		Button clearButton = new Button("Clear");

		// Add action on the sign up link
		signUpLink.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(signUp);
			}
		});

		// Add action on the log in button
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				
				SignIn signin1 = new SignIn();
				boolean check = signin1.checkAccountForSignIn(textUserName.getText(),password.getText());
				
				if(check==true){
					  
					  // go to the homepage 
					  stage.setScene(homepage);
				      lblMessage.setText("Login Success");
				      lblMessage.setTextFill(Color.GREEN);              
				   	
				  }else{
					   lblMessage.setText("Wrong username/password!");
					   lblMessage.setTextFill(Color.RED);
					  }
					  textUserName.setText("");
					  password.setText("");
					 }});
				
				
			
		

		// Add action to the Clear button
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textUserName.clear();
				password.clear();
				lblMessage.setText(null);
			}
		});

		
		
		gridPane.add(title, 0, 0);
		gridPane.add(lblUserName, 0, 1);
		gridPane.add(textUserName, 1, 1);
		gridPane.add(lblPassword, 0, 2);
		gridPane.add(password, 1, 2);
		gridPane.add(btnLogin, 1, 3);
		gridPane.add(lblMessage, 1, 4);
		gridPane.add(signupPromote, 1, 5);
		gridPane.add(signUpLink, 1, 6);
		gridPane.add(clearButton, 1, 7);

		signIn = new Scene(gridPane, SCENE_SIZE_X, SCENE_SIZE_Y);
	}

	private void createSignUp() {

		// Scene 2: The sign Up Page
		Text signUptitle = new Text("Sign Up");
		signUptitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label username = new Label("Username:");
		final TextField usernameField = new TextField();
		Label signUppassword = new Label("Password:");
		final PasswordField passwordField = new PasswordField();
		Button buttonReturn = new Button("Return Sign In");
		buttonReturn.setOnAction(e -> stage.setScene(signIn));
		Button submit = new Button("submit");
		Button clearButton2 = new Button("Clear");
		submit.setPrefHeight(30);
		submit.setDefaultButton(true);
		submit.setPrefWidth(70);

		VBox layout2 = new VBox(20);
		layout2.setSpacing(10);
		layout2.setPadding(new Insets(100, 300, 300, 300));
		layout2.getChildren().addAll(signUptitle, username, usernameField, signUppassword, passwordField, submit,
				buttonReturn, clearButton2);
		signUp = new Scene(layout2, SCENE_SIZE_X, SCENE_SIZE_Y);

				
				//Add action to the clearButton2
				clearButton2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {         
				usernameField.clear();
				passwordField.clear();	
				}});
				
				
				
			
	// Add action on the submit button    
	submit.setOnAction(new EventHandler<ActionEvent>() {
	    public void handle(ActionEvent event) {
	    	
	    	
	        if(usernameField.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, signUp.getWindow(), 
	            "Error!", "Please Enter Your Name");          
	            return;
	        }
	      
	        if(passwordField.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, signUp.getWindow(), 
	            "Error!", "Please Enter Your Password");
	            return;
	        }
	        
	          
	        //Use the function checkAccountForSignUp of the class SignUp to check if the account or password
	    	//is already used
	    	SignUp signup = new SignUp();
	    	boolean check2 = signup.checkAccountForSignUp(usernameField.getText(),passwordField.getText());
	    		
	    	
	    	if(check2==true){
	    		showAlert(Alert.AlertType.ERROR, signUp.getWindow(), 
	    	            "Error!", "Username & password are used!  Create a new account!");          
	    	             	return;
	    	  }
	    	  
	    	
	    	
	    		signup.saveData(usernameField.getText(), passwordField.getText());
	            showAlert(Alert.AlertType.CONFIRMATION, signUp.getWindow(), 
	            "Successful!", "Welcome " + usernameField.getText() +"!");
	    
	    	            
	              
	    }
	    
	});
	
}
		
	
	
	public static void showAlert(Alert.AlertType alertType, Window window, String title, String message) {
				Alert alert = new Alert(alertType);
				alert.setTitle(title);
				alert.setHeaderText(null);
				alert.setContentText(message);
				alert.initOwner(window);
				alert.show();
			}
			
					
			

	private void createWelcome() {
		// Scene 3: the homepage
		Label label3 = new Label("Homepage");
		VBox layout3 = new VBox(20);
		Button btnCustom = new Button("Add Custom Assignment");
		btnCustom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(addCustomAssignment);
			}
		});
		layout3.getChildren().addAll(label3, btnCustom);

		homepage = new Scene(layout3, SCENE_SIZE_X, SCENE_SIZE_Y);

	}
}

