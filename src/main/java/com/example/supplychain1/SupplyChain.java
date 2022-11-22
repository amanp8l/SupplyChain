package com.example.supplychain1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SupplyChain extends Application {
    private static final int height=600, width=700, upperLine=50;
    Pane bodyPane =new Pane();

    public Login login = new Login();
    ProductDetails productDetails = new ProductDetails();
    private GridPane hearBar(){
        GridPane gridPane=new GridPane();
        gridPane.setPrefSize(width,upperLine-5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        TextField searchText = new TextField();
        searchText.setMinWidth(250);
        searchText.setPromptText(("Please enter here"));
        Button searchButton = new Button("Search");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(productDetails.getAllProducts());
            }
        });
        gridPane.add(searchText,0,0);
        gridPane.add(searchButton,1,0);
        return gridPane;
    }
    private GridPane loginPage(){
        Label emailLabel =new Label("Email");
        Label passwordLabel =new Label("Password");
        Label messageLabel=new Label("I am message");
        TextField emailTextField =new TextField();
        emailTextField.setPromptText("Please enter email");
        PasswordField passwordField =new PasswordField();
        passwordField.setPromptText("enter password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email=emailTextField.getText();
                String password=passwordField.getText();
                if(login.customerLogin(email, password)){
                    messageLabel.setText("Login Successfully");
                }else{
                    messageLabel.setText("Invalid User");
                }
//                messageLabel.setText("email - "+ email + " && pass - "+password);
            }
        });

        GridPane gridPane =new GridPane();
        gridPane.setMinSize(bodyPane.getMinWidth(), bodyPane.getMinHeight());
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(emailLabel,0,0);
        gridPane.add(emailTextField,1,0);
        gridPane.add(passwordLabel,0,1);
        gridPane.add(passwordField,1,1);
        gridPane.add(loginButton,0,2);
        gridPane.add(messageLabel,1,2);
        return gridPane;
    }
    Pane createContent(){
        Pane root =new Pane();
        root.setPrefSize(width,height+upperLine);
        bodyPane.setTranslateY(upperLine);
        bodyPane.setMinSize(width,height);
//        bodyPane.setBorder(new Border(Color.BLACK));
        bodyPane.getChildren().add(loginPage());
        root.getChildren().addAll(hearBar(),bodyPane);
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("HelloSupply Chain System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}