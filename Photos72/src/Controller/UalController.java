package Controller;
import Model.Album;
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
import java.util.List;

public class UalController {

    @FXML TextField NewAlbum;
    @FXML TextField DeleteAlbum;
    @FXML TextField SearchDate;
    @FXML TextField SearchType;
    @FXML TextField SearchValue;
    @FXML TextField CurrentAlbum;
    @FXML TextField RenameAlbum;
    @FXML ListView<Album> AlbumView;
    @FXML Button Create;
    @FXML Button Delete;
    @FXML Button OpenAlbum;
    @FXML Button DateSearch;
    @FXML Button TagSearch;
    @FXML Button Rename;
    public static User currUser;

    @FXML
    public void createAlbum(ActionEvent e ) throws IOException{
        if(NewAlbum.getText().isEmpty()){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("ERROR");
            err.setContentText("No Album name specified");
            err.showAndWait();
        }
        else{
            if(currUser.findAlbum(NewAlbum.getText())){
                Alert err = new Alert(Alert.AlertType.ERROR);
                err.setTitle("ERROR");
                err.setContentText("Duplicate Album");
                err.showAndWait();
            }
            else{
                Album toAdd = new Album(NewAlbum.getText());
                List<Album> temp= currUser.getAlbumList();
                temp.add(toAdd);
                Collections.sort(temp);
                int index= temp.indexOf(toAdd);
                currUser.setAlbumList(temp);
                AlbumView.getItems().setAll(currUser.getAlbumList());
                AlbumView.getSelectionModel().select(index);

            }
        }

    }

    @FXML
    public void renameAlbum(ActionEvent e ) throws IOException{
            if(CurrentAlbum.getText().isEmpty() || RenameAlbum.getText().isEmpty()){
                Alert err = new Alert(Alert.AlertType.ERROR);
                err.setTitle("ERROR");
                err.setContentText("Current and/or New Album name field empty.");
                err.showAndWait();
            }
            else if(!currUser.findAlbum(CurrentAlbum.getText()) || currUser.findAlbum(RenameAlbum.getText())){
                if(!currUser.findAlbum(CurrentAlbum.getText()) && currUser.findAlbum(RenameAlbum.getText())){
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("ERROR");
                    err.setContentText("Current Album does not exist and can't rename to an album name that already exists.");
                    err.showAndWait();
                }
                else if(!currUser.findAlbum(CurrentAlbum.getText())){
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("ERROR");
                    err.setContentText("Current Album does not exist.");
                    err.showAndWait();
                }
                else{
                    Alert err = new Alert(Alert.AlertType.ERROR);
                    err.setTitle("ERROR");
                    err.setContentText("Can't rename to album that already exists.");
                    err.showAndWait();
                }
            }
            else{
                List<Album> temp = currUser.getAlbumList();
                for(Album x : temp){
                    if(x.getAlbumName().equals(CurrentAlbum.getText())){
                        x.setAlbumName(RenameAlbum.getText());
                    }
                }
                Collections.sort(temp);
                currUser.setAlbumList(temp);
                AlbumView.getItems().setAll(currUser.getAlbumList());
            }
    }

    @FXML
    public void deleteAlbum(ActionEvent e ) throws IOException{
        if(DeleteAlbum.getText().isEmpty()){
            Alert err = new Alert(Alert.AlertType.ERROR);
            err.setTitle("ERROR");
            err.setContentText("No Album to delete specified");
            err.showAndWait();
        }
        else{
            if(!currUser.findAlbum(DeleteAlbum.getText())){
                Alert err = new Alert(Alert.AlertType.ERROR);
                err.setTitle("ERROR");
                err.setContentText("Album does not exist");
                err.showAndWait();
            }
            else{
                List<Album> temp = currUser.getAlbumList();
                temp.removeIf(x -> x.getAlbumName().equals(DeleteAlbum.getText()));
                currUser.setAlbumList(temp);
                AlbumView.getItems().setAll(currUser.getAlbumList());
            }
        }
    }

    @FXML
    public void openAlbum(ActionEvent e ) throws IOException{
        FXMLLoader xd = new FXMLLoader();
        xd.setLocation(getClass().getResource("/View/OpAlb.fxml"));
        Scene scene = new Scene(xd.load());
        Stage stage = new Stage();
        stage.setTitle("Open Album");
        stage.setScene(scene);
        stage.show();
        //((Node) (e.getSource())).getScene().getWindow().hide();

    }


}
