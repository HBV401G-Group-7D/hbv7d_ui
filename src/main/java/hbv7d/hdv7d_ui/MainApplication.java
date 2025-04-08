package hbv7d.hdv7d_ui;

//import HBV401G.Group.DayTour7.main.Api;
//import hbv7d.Api;
import hbv7d.api.Api;
import hbv7d.hdv7d_ui.view.ViewSwitcher;
import hbv7d.main.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        ViewSwitcher.setScene(scene);
        ViewSwitcher.setStage(stage);
        stage.setTitle("Day Tour");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}