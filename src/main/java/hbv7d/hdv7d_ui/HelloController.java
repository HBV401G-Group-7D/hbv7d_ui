package hbv7d.hdv7d_ui;

import hbv7d.api.Api;
import hbv7d.model.Company;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    Api api = new Api();

    @FXML
    protected void onHelloButtonClick() {

//        System.out.println(api.Name());
//        welcomeText.setText(String.valueOf("api.Name())"));
        Company company = new Company(1, "testing company");
        api.createCompany(company);

        System.out.println(api.getCompany(1).getName());
    }
}