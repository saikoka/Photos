package PhotoApp;

import Controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Photos extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Login.fxml"));
        Parent root = loader.load();

        LoginController listController = loader.getController();
        //listController.start(primaryStage);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Song Library");
        primaryStage.setResizable(false);
        primaryStage.show();

        /*Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));


        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
