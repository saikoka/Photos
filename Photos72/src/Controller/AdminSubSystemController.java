package Controller;
import Model.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Collections;

public class AdminSubSystemController {
    @FXML TextField creation;
    @FXML TextField deletion;
    @FXML ListView<User> ListUser;
    @FXML Button Create;
    @FXML Button Delete;
    @FXML Button Logout;
    @FXML Button SafeQuit;

    @FXML
    private void createUser(ActionEvent e) throws IOException{
        if(creation.getText().isEmpty()){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("ERROR");
            err.setContentText("No username specified");
            err.showAndWait();
        }
        else{
            if(User.findUser(creation.getText())){
                Alert err = new Alert(Alert.AlertType.ERROR);
                err.setTitle("ERROR");
                err.setContentText("Duplicate username");
                err.showAndWait();
            }
            else{
                User newUser = new User(creation.getText());
                Collections.sort(User.userList);
                int index= User.userList.indexOf(newUser);
                ListUser.getItems().setAll(User.userList);
                ListUser.getSelectionModel().select(index);

            }
        }
    }

    @FXML
    private void deleteUser(ActionEvent e) throws IOException{
        if(deletion.getText().isEmpty()){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("ERROR");
            err.setContentText("No username specified");
            err.showAndWait();
        }
        else{
            if(!User.findUser(deletion.getText())){
                Alert err = new Alert(Alert.AlertType.ERROR);
                err.setTitle("ERROR");
                err.setContentText("Username not found");
                err.showAndWait();
            }
            else{

                User.userList.removeIf(x -> x.getUsername().equals(deletion.getText()));
                ListUser.getItems().setAll(User.userList);
            }
        }
    }

    @FXML
    private void logout(ActionEvent e) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        ((Node) (e.getSource())).getScene().getWindow().hide();
    }



}
