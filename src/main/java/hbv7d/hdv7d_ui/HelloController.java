package hbv7d.hdv7d_ui;

import hbv7d.api.Api;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Api api = new Api();
        System.out.println(api.Name());
        welcomeText.setText(String.valueOf(api.Name()));
    }
}