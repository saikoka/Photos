package Controller;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
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

import javax.swing.*;

public class LoginController {
    @FXML TextField UserLog;
    @FXML Button LoginBtn;

    @FXML
    private void login(ActionEvent e) throws IOException{
        if(UserLog.getText().isEmpty()){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("ERROR");
            err.setContentText("Name and artist can't be blank.");
            err.showAndWait();
        }
        else if(UserLog.getText().equals("stock")){
            //Open user album list with stock photos in album
        }
        else if(UserLog.getText().equals("admin")){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/View/AdminSubSystem.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Admin Sub-System");
            stage.setScene(scene);
            stage.show();
            ((Node)(e.getSource())).getScene().getWindow().hide();
        }
        else{

        }

    }
}
